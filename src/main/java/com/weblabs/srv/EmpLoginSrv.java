package com.weblabs.srv;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weblabs.utility.DBUtil;



@WebServlet("/EmpLoginSrv")
public class EmpLoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpLoginSrv() {
		super();
	}

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // You can handle GET requests here if needed
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (validate(request, username, password)) {
	            // Check if the username is for an admin
				/*
				 * if ("admin@gmail.com".equals(username)) {
				 * response.sendRedirect("admin_dashboard.jsp"); } else {
				 */	                
	        	response.sendRedirect("user.jsp");
	            
	        } else {
	            String errorMessage = "Invalid username or password";
	            request.setAttribute("error", errorMessage);
	            request.setAttribute("wrongusername", "true"); // Set wrongusername attribute
	            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            rd.forward(request, response);
	        }
	    }

	
	private boolean validate(HttpServletRequest request, String username, String password) {
	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;

	    try {
	        // Assuming "users" table has columns "email" and "password"
	        String sql = "SELECT email, name FROM logins WHERE email=? AND password=?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet result = ps.executeQuery();
	        if (result.next()) {
	            HttpSession session = request.getSession();
	            session.setAttribute("name", result.getString("name"));
	            session.setAttribute("Email", result.getString("email"));
				/*
				 * session.setAttribute("userID", result.getString("userID"));
				 * session.setAttribute("RoleID", result.getString("RoleID"));
				 */
	            con.close();
	            return true;
	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        request.setAttribute("wrongpassword", "true"); // Set wrongpassword attribute
	    } finally {
	        // Ensure that resources are properly closed in case of an exception
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return false;
	}

}

