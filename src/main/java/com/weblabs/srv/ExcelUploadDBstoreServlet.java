package com.weblabs.srv;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.poi.ss.usermodel.*;
import com.weblabs.utility.DBUtil;

@WebServlet("/ExcelUploadServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2 MB
    maxFileSize = 1024 * 1024 * 10,       // 10 MB
    maxRequestSize = 1024 * 1024 * 50     // 50 MB
)
public class ExcelUploadDBstoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
            if (filePart == null) {
                throw new IllegalArgumentException("File part not found. Please upload a file.");
            }
            try (InputStream inputStream = filePart.getInputStream();
                 Workbook workbook = WorkbookFactory.create(inputStream)) {
                Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();
                try (Connection connection = DBUtil.provideConnection()) {
                    String insertQuery = "INSERT INTO phnbook (sno, phno, msg) VALUES (?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            preparedStatement.setString(1, getStringCellValue(row.getCell(0)));
                            preparedStatement.setString(2, getPhoneNumberString(row.getCell(1)));
                            preparedStatement.setString(3, getStringCellValue(row.getCell(2)));
                            preparedStatement.addBatch();
                        }
                        preparedStatement.executeBatch(); // Execute batch
                    }
                }
                response.getWriter().print("Data imported successfully!");
            } // IOException can be thrown here
        } catch (IOException | IllegalArgumentException | SQLException e) {
            handleSpecificException(e, response);
        }
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Convert numeric value to string
                return String.valueOf(cell.getNumericCellValue());
            default:
                return null;
        }
    }

    private String getPhoneNumberString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                // Format numeric value as a string without scientific notation
                return String.format("%.0f", cell.getNumericCellValue());
            default:
                return null;
        }
    }

    private void handleSpecificException(Exception e, HttpServletResponse response) throws IOException {
        if (e instanceof IllegalArgumentException || e instanceof IOException) {
            response.getWriter().print("Error processing the file: " + e.getMessage());
        } else if (e instanceof SQLException) {
            response.getWriter().print("Database error occurred: " + e.getMessage());
        } else {
            response.getWriter().print("An unexpected error occurred: " + e.getMessage());
        }
    }
}
