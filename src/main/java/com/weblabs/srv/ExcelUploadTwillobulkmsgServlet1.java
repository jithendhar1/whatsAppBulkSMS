package com.weblabs.srv;
import java.io.IOException;
import java.io.InputStream;
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

@WebServlet("/ExcelUploadServlet1")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2 MB
    maxFileSize = 1024 * 1024 * 10,       // 10 MB
    maxRequestSize = 1024 * 1024 * 50     // 50 MB
)
public class ExcelUploadTwillobulkmsgServlet1 extends HttpServlet {
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
                TwilloSrv twilloSrv = new TwilloSrv(); // Create an instance of your TwilloSrv class
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    String phno = getStringCellValue(row.getCell(0)); // Assuming phone numbers are in the first column
                    String otp = getStringCellValue(row.getCell(1)); // Assuming OTPs are in the second column
                    twilloSrv.sendOtp(phno, otp); // Send OTP using TwilloSrv
                }
                response.getWriter().print("Data imported successfully!");
            } // IOException can be thrown here
        } catch (IOException | IllegalArgumentException e) {
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
                return String.valueOf((long) cell.getNumericCellValue());
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
