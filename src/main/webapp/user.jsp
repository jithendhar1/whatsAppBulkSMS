
<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %>
<%
HttpSession sdsession = request.getSession(true);

//Retrieve the username attribute from the session
String username = (String) sdsession.getAttribute("name");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
 <meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<meta name="description" content="xm-s1 Admin Template">
<meta name="keywords"
	content="admin, Cryptocurrency, account management">
<meta name="author" content="Weblabs - Admin Template">
<meta name="robots" content="noindex, nofollow">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/LOGOTrade.jpg">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Lineawesome CSS -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    <title>XMS1 User Dashboard</title>
</head>
<body>
    <!-- Main Wrapper -->
<div class="main-wrapper">
    <!-- Main Wrapper -->
   <!-- Header -->
    <!-- Include your header HTML here -->
    <jsp:include page="header.jsp" />

    <jsp:include page="sidebar.jsp" />

    <!-- Page Wrapper -->
    <div class="page-wrapper">

        <!-- Page Content -->
        <div class="content container-fluid">

            <!-- Page Header -->
            <div class="page-header">
                <div class="row align-items-center">
                <div class="col">
                        <div class="col-sm-12">
                            <!-- Display welcome message -->
                            <div id="welcomeMessage" style="text-align: center; margin-top: 20px; font-size: 24px;">
                                Welcome Admin!
                            </div>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                        <div class="card dash-widget">
                            <div class="card-body">
                             <a href="promotion.jsp" style="text-decoration: none; color: inherit;">
                                <span class="dash-widget-icon"><i class="fa fa-upload"></i></span>
                                <div class="dash-widget-info">
                                  <%--   <% BigDecimal roi = new BigDecimal("5.2"); %> --%>
                                  <%-- <% int roi = ROIDAO.totalCountByUsername(username); %>
                                    <h3><%= roi %></h3> --%>
                                    <span>File uploading</span>
                                </div>
                                 </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                        <div class="card dash-widget">
                            <div class="card-body">
                              <a href="promotion_name.jsp" style="text-decoration: none; color: inherit;">
                                <span class="dash-widget-icon"><i class="fa fa-whatsapp"></i></span>
                                <div class="dash-widget-info">
                                    <%-- <% int referralCount = 10; %> --%>
                                     <%-- <% int referralCount = ReffertalDAO.totalCountByUsername(username); %>
                                    <h3><%= referralCount %></h3> --%>
                                    <span>Send by Name</span>
                                </div>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                        <div class="card dash-widget">
                            <div class="card-body">
                            <a href="promotion_groupid.jsp" style="text-decoration: none; color: inherit;">
                                <span class="dash-widget-icon"><i class="fa fa-group"></i></span>
                                <div class="dash-widget-info">
                                   <%--  <% BigDecimal totalDeposits = new BigDecimal("5000.0"); %> --%>
                                  <%--  <% int totalDeposits = DepositDAO.totalCountByUsername(username); %>
                                    <h3><%= totalDeposits %></h3> --%>
                                    <span>Send by Group</span>
                                </div>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-lg-6 col-xl-3">
                        <div class="card dash-widget">
                            <div class="card-body">
                            <a href="report.jsp" style="text-decoration: none; color: inherit;">
                                <span class="dash-widget-icon"><i class="fa fa-wpforms"></i></span>
                                <div class="dash-widget-info">
                                    <%-- <% BigDecimal totalWithdrawals = new BigDecimal("200.0"); %> --%>
                                     <%-- <% int totalWithdrawals = WithdrawalDAO.totalCountByUsername(username); %>
                                    <h3><%= totalWithdrawals %></h3> --%>
                                    <span>Reports</span>
                                </div>
                                  </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div></div>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.slimscroll.min.js"></script>
     <!--    <script src="plugins/morris/morris.min.js"></script>-->
      
    </body>
</html>