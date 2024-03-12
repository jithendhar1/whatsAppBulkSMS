package com.weblabs.srv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.utility.DBUtil;

@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String[] number = request.getParameterValues("phone_number");
    	
    
        for (String phno : number) {
        	
        
            String phoneNumber = "91" + phno;
            String otp = request.getParameter("otp");

        String graphApiUrl = "https://graph.facebook.com/v18.0/263851053470482/messages";
        String accessToken = "EAAyPxl33sp4BO8zgDiuLe5oJ3ZA4bQZC0ZBNVEuOmZCcmiFlFcZAEbabvpSoNzdD0mUIwhgmEP7aTZBZBd3tAozH5uV2Ns7fUmLbEaGkhPNzTHiEHnLZCBZBeJAEtWderDilTfmlwc7yErffPDsBQlRTypKcG56vZA3GXTbRVsATSxOXErZC7sYZC9KyTHLBUzAjvKVnDNkIomlejQUJ7bSdD50ZD"; // Dynamic access token

        URL url = new URL(graphApiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        String jsonInputString = "{"
                + "\"messaging_product\": \"whatsapp\","
                + "\"to\": \"" + phoneNumber + "\","
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

        
        // Read response
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder responseBody = new StringBuilder(); // Renamed the variable
            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine);
            }
            // Print response
            System.out.println(responseBody.toString());
            
            String deliveryStatus = (responseCode == 200) ? "Delivered" : "Not Delivered";
            try (Connection connection = DBUtil.provideConnection()) {
                String insertQuery = "INSERT INTO mssghistory (phone_number, otp, deliveryStatus,currentdate) VALUES (?, ?, ?, CURDATE())";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, phoneNumber);
                    preparedStatement.setString(2, otp);
                    preparedStatement.setString(3, deliveryStatus);
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}

}
