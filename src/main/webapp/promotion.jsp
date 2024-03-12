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
<title>Promotion</title>
<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.png">
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
		<jsp:include page="header.jsp" />
            <jsp:include page="sidebar.jsp" />
            <div class="page-wrapper">

                <div class="content container-fluid">
				
					<!-- Page Header -->
					<div class="page-header">
						<div class="row">
							<div class="col-sm-12">
								<h3 class="page-title">Upload A File</h3>
								
							</div>
						</div>
					</div>

          <form action="DBstoringSrv" method="post" enctype="multipart/form-data"> 
        Select XML File: <input  type="file" name="file" id="file"><br>
        <input style="background-color: #32cd2391;" type="submit" value="Upload" name="submit">
    </form>
</div> 
 </div> 
  </div> 
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
        
</body>
</html>