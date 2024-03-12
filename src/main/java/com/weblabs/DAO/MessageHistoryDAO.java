package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.weblabs.beans.MessageHistoryBean;
import com.weblabs.utility.DBUtil;


public class MessageHistoryDAO {

	
	public static List<MessageHistoryBean> getdateYHQM(String customDate) {
	    List<MessageHistoryBean> transactions = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBUtil.provideConnection();
	        String query;

	        if ("yearly".equalsIgnoreCase(customDate)) {
	            query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory WHERE currentdate BETWEEN DATE_SUB(NOW(), INTERVAL 12 MONTH) AND NOW();";
	        } else if ("monthly".equalsIgnoreCase(customDate)) {
	            query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory WHERE MONTH(currentdate) = MONTH(NOW()) AND YEAR(transactiondate) = YEAR(NOW());";
	        } else if ("halfyearly".equalsIgnoreCase(customDate)) {
	            query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory WHERE currentdate BETWEEN DATE_SUB(NOW(), INTERVAL 6 MONTH) AND NOW();";
	        } else if ("quarterly".equalsIgnoreCase(customDate)) {
	            query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory WHERE currentdate BETWEEN DATE_SUB(NOW(), INTERVAL 3 MONTH) AND NOW();";
	        } else {
	            // Default query for a specific date
	            query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory WHERE currentdate = ?;";
	        }

	        // Prepare the statement with the query
	        preparedStatement = connection.prepareStatement(query);

	        // Set the parameter for the prepared statement (only for specific date, not needed for other cases)
	        if (!Arrays.asList("yearly", "monthly", "halfyearly", "quarterly").contains(customDate)) {
	            preparedStatement.setString(1, customDate);
	        }
	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	MessageHistoryBean transaction = new MessageHistoryBean();
		            transaction.setMssghistory_id(resultSet.getString("mssghistory_id"));
		            transaction.setPhone_number(resultSet.getString("phone_number"));
		            transaction.setOtp(resultSet.getString("otp"));
		            transaction.setDeliveryStatus(resultSet.getString("deliveryStatus"));
		            transaction.setCurrent_date(resultSet.getString("currentdate"));
		            
		            transactions.add(transaction);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	        }
	    }

	    return transactions;
	}


	 public static List<MessageHistoryBean> getAllHistory() {
	        List<MessageHistoryBean> AllHistory = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = DBUtil.provideConnection();
	            String query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory;";

	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	
	               
	            	MessageHistoryBean transaction = new MessageHistoryBean();
	            	 transaction.setMssghistory_id(resultSet.getString("mssghistory_id"));
			            transaction.setPhone_number(resultSet.getString("phone_number"));
			            transaction.setOtp(resultSet.getString("otp"));
			            transaction.setDeliveryStatus(resultSet.getString("deliveryStatus"));
			            transaction.setCurrent_date(resultSet.getString("currentdate"));
			            
			            AllHistory.add(transaction);
	            }
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	        } finally {
	            // Close database resources (connection, statement, result set)
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                // Handle exceptions
	                e.printStackTrace();
	            }
	        }

	        return AllHistory;
	    }
	 
	 public static List<MessageHistoryBean> getStartEndDate(String startDate, String endDate) {
		    List<MessageHistoryBean> transactions = new ArrayList<>();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT mssghistory_id, phone_number, otp, deliveryStatus, currentdate FROM mssghistory WHERE currentdate BETWEEN ? AND ? ;";
		        preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, startDate);
		        preparedStatement.setString(2, endDate);

		        resultSet = preparedStatement.executeQuery();

		        // Iterate through the result set
		        while (resultSet.next()) {
		        	MessageHistoryBean transaction = new MessageHistoryBean();
	            	 transaction.setMssghistory_id(resultSet.getString("mssghistory_id"));
			            transaction.setPhone_number(resultSet.getString("phone_number"));
			            transaction.setOtp(resultSet.getString("otp"));
			            transaction.setDeliveryStatus(resultSet.getString("deliveryStatus"));
			            transaction.setCurrent_date(resultSet.getString("currentdate"));
			            
		            transactions.add(transaction);
		        }
		    } catch (Exception e) {
		        // Handle exceptions
		        e.printStackTrace();
		    } finally {
		        // Close database resources (connection, statement, result set)
		        try {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connection != null) connection.close();
		        } catch (Exception e) {
		            // Handle exceptions
		            e.printStackTrace();
		        }
		    }

		    return transactions;
		}
	
}
