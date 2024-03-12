<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet" %>
<%@ page import="javax.servlet.ServletException, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.utility.DBUtil" %>

<%
    HttpSession sdsession = request.getSession(true);
    // Retrieve the username attribute from the session
    String username = (String) sdsession.getAttribute("userID");
%> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Page Title</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

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

    <style>
        /* Set a fixed height for the sidebar and enable scrollbar */
        #sidebar {
            height: 1000px; /* Set a fixed height */
            overflow-y: auto; /* Enable vertical scrollbar */
        }
    </style>

</head>

<body>
    <div class="sidebar" id="sidebar">
        <div class="sidebar-inner slimscroll">
            <div id="sidebar-menu" class="sidebar-menu">
                <ul>
                    <li class="submenu">
                        <a href="#"><i class="la la-dashboard"></i>
                            <span> Dashboard</span>
                            <span class="menu-arrow"></span>
                        </a>
                        <ul> 
                            <li class="admin-dashboard-link"><a href="user.jsp">Dashboard</a></li>                 
                        </ul>
                  </li>
                    <li class="menu-title">
                        <span>Main</span>
                    </li>

                            <li class="admin-dashboard-link"><a href="promotion.jsp">File uploading</a></li>
                            <li class="admin-dashboard-link"><a href="promotion_name.jsp">Send by Name</a></li>
                            <li class="admin-dashboard-link"><a href="promotion_groupid.jsp">Send by Group</a></li>
                            <li class="admin-dashboard-link"><a href="report.jsp">Reports</a></li>
                            <li class="admin-dashboard-link"><a href="EmailSending.jsp">Email Send</a></li>

            
                </ul>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
<script>

</script>
    <!-- Bootstrap Core JS -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- Slimscroll JS -->
    <script src="js/jquery.slimscroll.min.js"></script>

    <!-- Select2 JS -->
    <script src="js/select2.min.js"></script>

    <!-- Datetimepicker JS -->
    <script src="js/moment.min.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>

    <!-- Custom JS -->
    <script src="js/app.js"></script>

    <script>
        // JavaScript for expand/collapse functionality
        var submenuItems = document.querySelectorAll(".submenu");
       // debugger;
        submenuItems.forEach(function (item) {
            item.addEventListener("click", function () {
                this.classList.toggle("open");
            });
        });
    </script>
</body>

</html>

