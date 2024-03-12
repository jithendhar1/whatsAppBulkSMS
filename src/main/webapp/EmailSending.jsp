<%@ page import="java.util.List" %>
<%@page import="com.weblabs.DAO.CustomerDAO"%>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <meta name="description" content="Smarthr- Bootstrap Admin Template">
    <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
    <meta name="author" content="Dreamguys - Bootstrap Admin Template">
    <meta name="robots" content="noindex, nofollow">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="assets/favico n.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Lineawesome CSS -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

    <!-- Select2 CSS -->
    <link rel="stylesheet" href="css/select2.min.css">

    <!-- Datetimepicker CSS -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
        <!-- table styles CSS -->
     <link rel="stylesheet" href="css/tstyles.css">
</head>
<body>
	<!-- Main Wrapper -->
        <div class="main-wrapper">
		
			<!-- Header -->
             <jsp:include page="header.jsp" />
			<!-- /Header -->
			
			<!-- Sidebar -->
            <jsp:include page="sidebar.jsp" />
			<!-- /Sidebar -->
			
			<!-- Page Wrapper -->
            <div class="page-wrapper">
            
                <div class="content container-fluid">
				
					<!-- Page Header -->
					<div class="page-header">
					
					
						<div class="row">
							<div class="col-sm-12">
								<h3 class="page-title">Email Sending</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
									<li class="breadcrumb-item active">Email Sending</li>
								</ul>
							</div>
						</div>
					</div>

<form id="myForm" action="EmailSendSRV" method="post">
				 <input type="hidden" id="action" name="action" value="">	
         <!--  <form action="./AddCSSrv" method="post">
 
     <form action="./EditCSSrv" method="post"> -->

								
									
								<div class="row">
									  <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label>Email</label>
                <select id="phone_number" name="email" multiple>
                    <option value="Select">Select</option>
                    <%
                        List<CustomerBean> transactions = CustomerDAO.getAllCustomer();
                        for (CustomerBean transaction : transactions) {
                    %>
                        <option><%= transaction.getEmail()%></option>
                    <%
                        }
                    %>
                </select> 
            </div>
        </div>
    </div>
									<div class="col-sm-6 col-md-6 col-lg-3">
										<div class="form-group">
											<label>Massage</label>
											<input class="form-control"  type="text" name="message">
										</div>
									</div>
								</div>
						
    <input  id="action1" name="action1" value="email" style="display:none;">

<div class="text-center">
    <button style="background-color: #32cd23;" class="btn btn-primary submit-btn" type="button" onclick="setSelectedAction('email')">Email Send</button>
        <button  style="background-color: #32cd23;" class="btn btn-primary submit-btn" type="button" onclick="setSelectedAction('whatsapp')">WhatsApp Send</button>
  </div>
</form>
</div>
<script>
    function setSelectedAction(action) {
        document.getElementById('action1').value = action;
        document.getElementById('myForm').submit();
    }
</script>
         
         <!-- jQuery -->
        <script src="js/jquery-3.2.1.min.js"></script>

		<!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

		<!-- Slimscroll JS -->
		<script src="js/jquery.slimscroll.min.js"></script>
		
		<!-- Datatable JS -->
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.bootstrap4.min.js"></script>

		<!-- Custom JS -->
		<script src="js/app.js"></script>

         
</body>
</html>