package com.weblabs.srv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SedOTP {


    public void sendOtp(String[] phoneNumbers, String otp) throws IOException {
        String graphApiUrl = "https://graph.facebook.com/v18.0/263851053470482/messages";
        String accessToken = "EAAyPxl33sp4BO4HfBcYlOMC1JFWlJkvPt585Sfs1NJ5RVfhU3VkkMWKHdqmBYfjDkaD05CchC4MUaRkDdPjVqZBUrrEcr9wfN2i9FE3UQunLgPG2C8qowKYyEeaCDbl5DaQOY7Im2OLZAE1DVFqqwcSCQvpoGon8Gz7lpWN4xztvzy8gK7HMuZA6TwoJpF00mvcUoHhwAbdf0NVllAZD"; // Replace this with your actual Facebook access token

        for (String phoneNumber : phoneNumbers) {
            String phoneNumberWithCountryCode = "91" + phoneNumber;

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

                // Read response
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    StringBuilder responseBody = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        responseBody.append(inputLine);
                    }
                    // Print response
                    System.out.println(responseBody.toString());
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle or log the exception
            }
        }
    }
}
