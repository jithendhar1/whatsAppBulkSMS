package com.weblabs.srv;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import com.weblabs.utility.DBUtil;

import java.sql.*;
@WebServlet("/UploadServlet")
/*
 * @MultipartConfig( fileSizeThreshold = 1024 * 1024 * 2, // 2MB maxFileSize =
 * 1024 * 1024 * 10, // 10MB maxRequestSize = 1024 * 1024 * 50 // 50MB )
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Parse the uploaded XML file
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileContent);
            NodeList nodeList = doc.getElementsByTagName("record");
            conn = DBUtil.provideConnection();
            // Connect to the database
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/promotion", "root", "Jithu@990");
            pstmt = conn.prepareStatement("INSERT INTO phnbook (sno, phno, msg) VALUES (?, ?, ?)");

            // Iterate through XML nodes and insert data into the database
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String sno = element.getElementsByTagName("sno").item(0).getTextContent();
                    String phno = element.getElementsByTagName("phno").item(0).getTextContent();
                    String msg = element.getElementsByTagName("msg").item(0).getTextContent();
                    pstmt.setString(1, sno);
                    pstmt.setString(2, phno);
                    pstmt.setString(3, msg);
                    pstmt.executeUpdate();
                }
            }

            // Redirect or display success message
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
            response.sendRedirect("error.jsp"); // Redirect to an error page
        } finally {
            // Close resources
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
