<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>



<%
HttpSession sdsession = request.getSession(true);

// Retrieve the username attribute from the session
String username = (String) sdsession.getAttribute("username");
%>


<!DOCTYPE html>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Page Title</title>
    <!-- Add your CSS and other meta tags here -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/M.css">
    
</head>
<body>
    <div class="header">
     
        <div class="header-left">
    
          <img src="assets/Logo.jpeg" width="110" height="58" alt="">
            
      
        </div>
       
        <div class="page-title-box">
            <h3>WhatsApp Bulk SMS</h3>
        </div>
        
        <a id="mobile_btn" class="mobile_btn" href="#sidebar"><i class="fa fa-bars"></i></a>

        <!-- Header Menu -->
        <ul class="nav user-menu">

            
         
           
            <li class="nav-item dropdown has-arrow main-drop">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> 
                   <div class="user-img">
                            <img src="assets/user.jpg" alt="User Picture">
                              <span class="status online"></span>
                   </div>
                   </a>

               
                <div class="dropdown-menu">
                  
                <a class="dropdown-item" href="profile.jsp">My Profile</a>
                    <a class="dropdown-item" href="logout.jsp">Logout</a>
                    <a class="dropdown-item" href="reset_password.jsp">Reset Password</a>
                </div>
            </li>
            <!-- /User Profile -->
        </ul>
        <!-- /Header Menu -->

        <!-- Mobile Menu -->
        <div class="dropdown mobile-user-menu">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
            <div class="dropdown-menu dropdown-menu-right">
               <a class="dropdown-item" href="profile.jsp">My Profile</a> 
                <!-- <a class="dropdown-item" href="settings.jsp">Settings</a> -->
                <a class="dropdown-item" href="logout.jsp">Logout</a>
                <a class="dropdown-item" href="reset_password.jsp">Reset Password</a>
            </div>
        </div>
        <!-- /Mobile Menu -->
    </div>

    <!-- Add your content here -->

    <!-- Add your JavaScript includes and scripts here -->
     <script src="js/jquery-3.2.1.min.js"></script>

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
    <!-- <script src="js/app.js"></script> -->
</body>

</html>