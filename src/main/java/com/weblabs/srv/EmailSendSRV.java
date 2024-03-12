package com.weblabs.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.DAO.EmailDAO;

@WebServlet("/EmailSendSRV")
public class EmailSendSRV extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action1");

        String[] emails = request.getParameterValues("email");
        String message = request.getParameter("message");

        if (action != null && action.equals("email") && emails != null && emails.length > 0 && message != null) {
            for (String email : emails) {
                String username = EmailDAO.getnameByEmail(email);
                ReferalLinkGenarate.sendLinkEmail(email, username, message);
            }
            response.sendRedirect("EmailSending.jsp");
        } else if (action != null && action.equals("whatsapp")) {
        	
            String[] phoneNumbers = new String[emails.length]; // Assuming each email has a corresponding phone number
            for (int i = 0; i < emails.length; i++) {
                phoneNumbers[i] = EmailDAO.getPHByEmail(emails[i])[0]; // Assuming getPHByEmail returns an array of phone numbers
            
             SedOTP sedOTP = new SedOTP();
			sedOTP.sendOtp(phoneNumbers, message);
        }
        }

}
}
