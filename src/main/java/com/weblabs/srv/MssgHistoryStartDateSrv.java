package com.weblabs.srv;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.DAO.MessageHistoryDAO;
import com.weblabs.beans.MessageHistoryBean;

@WebServlet("/MssgHistoryStartDateSrv")
public class MssgHistoryStartDateSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String StartDate = request.getParameter("StartDate");
        String EndDate = request.getParameter("EndDate");

        // Get the updated transactions based on the selected transaction type
        List<MessageHistoryBean> transactions = MessageHistoryDAO.getStartEndDate(StartDate,EndDate);

        // Prepare the HTML content for the updated table
        StringBuilder htmlContent = new StringBuilder();
        for (MessageHistoryBean task : transactions) {
            htmlContent.append("<tr>");
            htmlContent.append("<td>").append(task.getMssghistory_id()).append("</td>");
            htmlContent.append("<td>").append(task.getPhone_number()).append("</td>");
            htmlContent.append("<td>").append(task.getOtp()).append("</td>");
            htmlContent.append("<td>").append(task.getCurrent_date()).append("</td>");
            htmlContent.append("<td>").append(task.getDeliveryStatus()).append("</td>");
          
      
            htmlContent.append("</tr>");
        }

        // Set the content type and write the updated table content as the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(htmlContent.toString());
    }
}
