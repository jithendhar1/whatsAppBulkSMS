package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.weblabs.beans.CustomerBean;
import com.weblabs.utility.DBUtil;

public class CustomerDAO {

	
	public static List<CustomerBean> getFilteredCustomers(String whereClause, int start, int limit) {
		List<CustomerBean> FilteredCustomers = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.provideConnection();
			String query;
			if (whereClause != null && !whereClause.isEmpty()) {
				
				query = "SELECT sno, name, email, phno, updatedtime, isactive, usergroup FROM users  WHERE " + whereClause + " LIMIT ?, ?;";

			} else {
				
				query = "SELECT sno, name, email, phno, updatedtime, isactive, usergroup FROM users" + " LIMIT ?, ?;";
			}
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, limit);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CustomerBean project = new CustomerBean();
				 project.setSno(resultSet.getString("sno"));
	                project.setName(resultSet.getString("name"));
	                project.setEmail(resultSet.getString("email"));
	                project.setPhno(resultSet.getString("phno"));
	                project.setUpdatedtime(resultSet.getString("updatedtime"));
	                project.setIsactive(resultSet.getString("isactive"));
	                project.setUsergroup(resultSet.getString("usergroup"));
				

				FilteredCustomers.add(project);
			}
		} catch (SQLException e) {
			// Handle exceptions or log them properly
			e.printStackTrace();
		} finally {
			// closeResources(connection, preparedStatement, resultSet);
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Handle exceptions
				e.printStackTrace();
			}
		}

		return FilteredCustomers;
	}

	 public static List<CustomerBean> getAllCustomer() {
	        List<CustomerBean> allProjects = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = DBUtil.provideConnection();
	            String query = "SELECT sno, name, email, phno, updatedtime, isactive, usergroup FROM users WHERE isactive = '1' ";
	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	CustomerBean project = new CustomerBean();
	                project.setSno(resultSet.getString("sno"));
	                project.setName(resultSet.getString("name"));
	                project.setEmail(resultSet.getString("email"));
	                project.setPhno(resultSet.getString("phno"));
	                project.setUpdatedtime(resultSet.getString("updatedtime"));
	                project.setIsactive(resultSet.getString("isactive"));
	                project.setUsergroup(resultSet.getString("usergroup"));
	 
	                allProjects.add(project);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return allProjects;
	    }
	  
	 public static List<CustomerBean> getCustomersByUserGroup(String userGroup) {
		    List<CustomerBean> customersByGroup = new ArrayList<>();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT sno, name, email, phno, updatedtime, isactive, usergroup FROM users WHERE usergroup = ? AND isactive = '1' ";
		        preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, userGroup);
		        resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		            CustomerBean customer = new CustomerBean();
		            customer.setSno(resultSet.getString("sno"));
		            customer.setName(resultSet.getString("name"));
		            customer.setEmail(resultSet.getString("email"));
		            customer.setPhno(resultSet.getString("phno"));
		            customer.setUpdatedtime(resultSet.getString("updatedtime"));
		            customer.setIsactive(resultSet.getString("isactive"));
		            customer.setUsergroup(resultSet.getString("usergroup"));

		            customersByGroup.add(customer);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connection != null) connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return customersByGroup;
		}

}
