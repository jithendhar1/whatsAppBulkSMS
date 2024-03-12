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
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/line-awesome.min.css">
    <link rel="stylesheet" href="css/select2.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tstyles.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
    	.larger-checkbox {
        transform: scale(1.5); /* Change the scale factor as needed */
    	}
	</style>
    
</head>
<body>
        	<div class="main-wrapper">
			<jsp:include page="header.jsp" />
		
            <jsp:include page="sidebar.jsp" />
		
            <div class="page-wrapper">
       
          	<div class="content container-fluid">
						
			<div class="page-header">						
					
					
						<div class="row">
							<div class="col-sm-12">
								<h3 class="page-title">Promotion</h3>
								
							</div>
						</div>
					</div>
<form action="./GroupServlet" method="post">
    <div style="margin: 20px;">
    
 <div class="form-group">
    <div class="form-check form-check-inline">
        <input type="checkbox" id="all" name="all" class="form-check-input larger-checkbox">
    </div>
    <label class="col-form-label" for="all">ALL  Groups :</label>
 
</div>

    <div class="form-group">
    <label class="col-form-label" for="group1">Group - 1 :</label>
    <div class="form-check form-check-inline">
        <input type="checkbox" id="group1" name="group1" class="form-check-input larger-checkbox">
    </div>
</div>

<div class="form-group">
    <label class="col-form-label" for="group2">Group - 2:</label>
    <div class="form-check form-check-inline">
        <input type="checkbox" id="group2" name="group2" class="form-check-input larger-checkbox">
    </div>
</div>

<div class="form-group">
    <label class="col-form-label" for="group3">Group - 3:</label>
    <div class="form-check form-check-inline">
        <input type="checkbox" id="group3" name="group3" class="form-check-input larger-checkbox">
    </div>
</div>

<div class="form-group">
    <label class="col-form-label" for="group4">Group - 4:</label>
    <div class="form-check form-check-inline">
        <input type="checkbox" id="group4" name="group4" class="form-check-input larger-checkbox">
    </div>
</div>

    
       <div class="form-group">
    <label for="otp">SMS <span style="color: red;">*</span></label>
    <input id="otp" name="otp" class="form-control" type="text" style="width: 250px;">
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
<script src="js/jquery-3.2.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#all').change(function() {
                var checkboxes = $(this).closest('form').find(':checkbox').not(this);
                checkboxes.prop('checked', $(this).prop('checked'));
            });
        });
    </script>  
    
    <script>
        $(document).ready(function() {
            // Retrieve the count from request attribute
            var count = <%= request.getAttribute("count") %>;

            // Check if count is a multiple of 5 and show alert
            if ( count > 0) {
                alert('Delivered message count is at : ' + count);
            }
        });
    </script>  
</body>
</html>