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
     
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>

<script>
    $(document).ready(function() {
        // Apply Select2 to the dropdown
        $('#selectedEmployee').select2({
            placeholder: 'Select user IDs',
            allowClear: true,
            multiple: true,
            // You can customize other options here
        });
    });
</script>
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
								<h3 class="page-title">Promotion</h3>
								
							</div>
						</div>
					</div>
<form action="./SendMessage" method="post">
    <div style="margin: 20px;">
    
<%--     <label for=phone_number> Customer name <span class="text-danger">*</span></label>
<select id="phone_number" name="phone_number" multiple>
    <option value="Select">Select</option>
    <%
        List<CustomerBean> transactions = CustomerDAO.getAllCustomer();
        for (CustomerBean transaction : transactions) {
    %>
        <option value="<%= transaction.getPhno() %>"><%= transaction.getName() %></option>
    <%
        }
    %>
</select>  --%>



 
<div class="form-group">
    <label for="phone_number" class="col-form-label">Customer name <span class="text-danger">*</span></label>
    <select style="width: 200px;" id="selectedEmployee" name="phone_number[]" class="form-control js-example-basic-multiple" multiple>
        <!-- <option value="Select">Select</option> -->
        <% List<CustomerBean> transactions = CustomerDAO.getAllCustomer(); %>
        <% for (CustomerBean transaction : transactions) { %>
            <option value="<%= transaction.getPhno() %>"><%= transaction.getName() %></option>
        <% } %>
    </select> 
</div>




        <div class="form-group">
            <label for="otp">SMS  <span style="color: red;">*</span></label>
            <input id="otp" name="otp" class="form-control" type="text" required>
        </div>

        <div class="submit-section">
            <button style="background-color: #32cd23;" type="submit" class="btn btn-primary submit-btn">Submit</button>
        </div>
    </div>
</form>

 </div> 
 </div> 
  </div> 

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.slimscroll.min.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.bootstrap4.min.js"></script>
        
</body>
</html>