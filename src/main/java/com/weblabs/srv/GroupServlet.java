package com.weblabs.srv;

import com.weblabs.DAO.CustomerDAO;
import com.weblabs.beans.CustomerBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@WebServlet("/GroupServlet")
public class GroupServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This set will store all unique phone numbers from the selected groups
        Set<String> phoneNumbers = new HashSet<>();
        String otp = request.getParameter("otp");
      
            processGroup(request, "group1", phoneNumbers);
            processGroup(request, "group2", phoneNumbers);
            processGroup(request, "group3", phoneNumbers);
            processGroup(request, "group4", phoneNumbers);
       

 
        SendMessageGroupSrv tv = new SendMessageGroupSrv();
       
      //  tv.sendOtp(phoneNumbers.toArray(new String[0]), otp);
          int count = tv.sendOtp(phoneNumbers.toArray(new String[0]), otp);
          request.setAttribute("count", count); // Use setAttribute to pass the count
          RequestDispatcher rd = request.getRequestDispatcher("/promotion_groupid.jsp");
          rd.forward(request, response);
    }
       
   

    private void processGroup(HttpServletRequest request, String groupName, Set<String> phoneNumbers) {
        if (request.getParameter(groupName) != null) {
            List<CustomerBean> customers = CustomerDAO.getCustomersByUserGroup(groupName);
            for (CustomerBean customer : customers) {
                phoneNumbers.add(customer.getPhno()); 
            }
        }
    }
}
