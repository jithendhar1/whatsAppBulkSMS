package com.weblabs.srv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.MalformedURLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.utility.DBUtil;

@WebServlet("/SendMessageGroupSrv")
public class SendMessageGroupSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String[] phoneNumbers = request.getParameterValues("number");
        String otp = request.getParameter("otp");
        
       // sendOtp(phoneNumbers, otp);
        
       int count = sendOtp(phoneNumbers, otp);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendMessageGroupSrv</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Operation completed. Messages sent: " + count + "</h2>");
            if (count % 2 == 0 && count != 0) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Count is a multiple of 5: " + count + "');");
                out.println("</script>");
            }
            out.println("</body>");
            out.println("</html>");
        }
   
    
    
    
    }

	     
  
   // int count=0;
  //  public void sendOtp(String[] phoneNumbers, String otp) throws MalformedURLException {
    public int sendOtp(String[] phoneNumbers, String otp) {
        int count = 0;     
        for (String phoneNumber : phoneNumbers) {
            String phoneNumberWithCountryCode = "91" + phoneNumber;

            String graphApiUrl = "https://graph.facebook.com/v18.0/263851053470482/messages";
            String accessToken = "EAAyPxl33sp4BO4HfBcYlOMC1JFWlJkvPt585Sfs1NJ5RVfhU3VkkMWKHdqmBYfjDkaD05CchC4MUaRkDdPjVqZBUrrEcr9wfN2i9FE3UQunLgPG2C8qowKYyEeaCDbl5DaQOY7Im2OLZAE1DVFqqwcSCQvpoGon8Gz7lpWN4xztvzy8gK7HMuZA6TwoJpF00mvcUoHhwAbdf0NVllAZD"; // Dynamic access token

            try {
                URL url = new URL(graphApiUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Authorization", "Bearer " + accessToken);
                con.setRequestProperty("Content-Type", "application/json");
                con.setDoOutput(true);

                String jsonInputString = "{"
                        + "\"messaging_product\": \"whatsapp\","
                        + "\"to\": \"" + phoneNumberWithCountryCode + "\","
                        + "\"type\": \"template\","
                        + "\"template\": {"
                        + "\"name\": \"" + otp + "\","
                        + "\"language\": { \"code\": \"en_US\" }"
                        + "}"
                        + "}";

                // Write POST data
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.writeBytes(jsonInputString);
                    wr.flush();
                }

                // Get response code
                int responseCode = con.getResponseCode();
                System.out.println("Response Code: " + responseCode);
                String deliveryStatus = (responseCode == 200) ? "Delivered" : "Not Delivered";
                try (Connection connection = DBUtil.provideConnection()) {
                    String insertQuery = "INSERT INTO mssghistory (phone_number, otp, deliveryStatus, currentdate) VALUES (?, ?, ?, CURDATE())";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, phoneNumber);
                        preparedStatement.setString(2, otp);
                        preparedStatement.setString(3, deliveryStatus);
                        preparedStatement.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // Read response
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    StringBuilder responseBody = new StringBuilder(); // Renamed the variable
                    while ((inputLine = in.readLine()) != null) {
                        responseBody.append(inputLine);
                    }
                    // Print response
                    System.out.println(responseBody.toString());
                   
                    count++;
                    
                 
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle or log the exception
            }
            
        }
        return count;
    }

}
