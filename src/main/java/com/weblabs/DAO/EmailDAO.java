package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.utility.DBUtil;


public class EmailDAO {

	public static String getnameByEmail(String Email) {
	    String userID = null;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBUtil.provideConnection();
	        String query = "SELECT name FROM users WHERE email =?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, Email);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            userID = resultSet.getString("name");
	        }
	    } catch (SQLException e) {
	        // Handle exceptions or log them properly
	        e.printStackTrace();
	    } finally {
	        // Close database resources
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	        }
	    }

	    return userID;
	}
	
	 public static String[] getPHByEmail(String email) {
	        List<String> userIDs = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = DBUtil.provideConnection();
	            String query = "SELECT phno FROM users WHERE email = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, email);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                userIDs.add(resultSet.getString("phno"));
	            }
	        } catch (SQLException e) {
	            // Handle exceptions or log them properly
	            e.printStackTrace();
	        } finally {
	            // Close database resources
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                // Handle exceptions
	                e.printStackTrace();
	            }
	        }

	        // Convert list to array
	        return userIDs.toArray(new String[0]);
	    }
}
