<%@page import="com.weblabs.DAO.MessageHistoryDAO"%>
<%@page import="com.weblabs.beans.MessageHistoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<meta name="description" content="Smarthr - Bootstrap Admin Template">
<meta name="keywords"
	content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
<meta name="author" content="Dreamguys - Bootstrap Admin Template">
<meta name="robots" content="noindex, nofollow">
<title>Report - template</title>
<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/line-awesome.min.css">
<link rel="stylesheet" href="css/select2.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/tstyles.css">
<script>
function updateDropdown(updateType) {
    var selectedValue = "";
    if (updateType === 'date') {
        selectedValue = document.getElementById("dateyhqm").value;
    } else if (updateType === 'StartDate') {
        selectedValue = document.getElementById("StartDate").value;
    } else if (updateType === 'EndDate') {
        selectedValue = document.getElementById("EndDate").value;
    }

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("transactionTableBody").innerHTML = this.responseText;
        }
    };

    if (updateType === 'date') {
        xhttp.open("GET", "MssgHistorydateyhqmSrv?date1=" + selectedValue, true);
    } else if (updateType === 'StartDate' || updateType === 'EndDate') {
        xhttp.open("GET", "MssgHistoryStartDateSrv?StartDate=" + document.getElementById("StartDate").value + "&EndDate=" + document.getElementById("EndDate").value, true);
    }
    xhttp.send();
}

</script>
</head>
<body>
	<!-- Main Wrapper -->
	<div class="main-wrapper">
	<jsp:include page="header.jsp" />
            <jsp:include page="sidebar.jsp" />
		<div class="page-wrapper">

			<!-- Page Content -->
			<div class="content container-fluid">

				<!-- Page Header -->
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<div id="welcomeMessage"
								style="text-align: center; margin-top: 20px; font-size: 24px;">
								Welcome
								
							</div>
							<h3 class="page-title">Report</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="admin_dashboard.jsp">Dash board</a></li>
								<li class="breadcrumb-item active">Report</li>
							</ul>
						</div>

					</div>
				</div>
				<label   style="margin-left: 20px;" for="dateyhqm">Messages History Date:</label> 
				<select style="width: 120px;height:30px;" class="input" name="dateyhqm" id="dateyhqm" onchange="updateDropdown('date')">
					<option>Select</option>
					<option value="yearly">Yearly</option>
					<option value="halfyearly">Halferly</option>
					<option value="quarterly">Quartely</option>
					<option value="monthly">Monthly</option>
                 </select> 
	
			<label style="margin-left: 50px;" for="StartDate">StartDate:</label>
			 <input style="width: 120px;height:30px;"
					 class="input" id="StartDate" name="StartDate"
					type="date" onchange="updateDropdown('StartDate')">
					
					
			<label style="margin-left: 50px;" for="EndDate">EndDate:</label>
			 <input style="width: 120px;height:30px;"
					class="input" id="EndDate" name="EndDate"
					type="date" onchange="updateDropdown('EndDate')">
			
			<br><br>
				<table >
					<thead>
						<tr>
						
						
							<th>ID</th>
							<th>Phno</th>
							<th>Otp</th>
							<th>Delivery Status</th>
							<th>Current Date</th>
							
							
						</tr>
					</thead>
					<tbody id="transactionTableBody">
						<%-- <% 
						 String updateType = request.getParameter("updateType");
					     String customDate = request.getParameter("dateyhqm");
                         String StartDate = request.getParameter("StartDate");
                         String EndDate = request.getParameter("EndDate");

                            List<MessageHistoryBean> tax = null;
                            
                              if ("date".equals(updateType)) {
                                tax = MessageHistoryDAO.getdateYHQM(customDate);
                              } else if ("StartDate".equals(updateType)) {
                                tax = MessageHistoryDAO.getStartEndDate(StartDate,EndDate);
                              } else {
                                // Default case, load all transactions
                                tax = MessageHistoryDAO.getAllHistory();
                              }                          
                            for (MessageHistoryBean tasks : tax) {                            	                           	
                        %>
						<tr>											
							<td><%=tasks.getMssghistory_id() %></td>
							<td><%=tasks.getPhone_number() %></td>
							<td><%=tasks.getOtp() %></td>
							<td><%=tasks.getDeliveryStatus() %></td>
							<td><%=tasks.getCurrent_date() %></td>
							<td><%=tasks.get %></td>							
							
						</tr>
						<%
                            }
                        %> --%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slimscroll.min.js"></script>
	<script src="js/select2.min.js"></script>		
</body>
</html>