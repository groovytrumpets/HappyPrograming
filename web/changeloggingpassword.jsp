<%-- 
    Document   : changeloggingpassword
    Created on : Sep 22, 2024, 4:56:16 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Password</title>
        <link href="assets/css/assets.css" rel="stylesheet">
        <link href="assets/vendors/calendar/fullcalendar.css" rel="stylesheet">
        <link href="assets/css/typography.css" rel="stylesheet">
        <link href="assets/css/shortcodes/shortcodes.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/dashboard.css" rel="stylesheet">
        <link class="skin" href="assets/css/color/color-1.css" rel="stylesheet">
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- Header and menu from tesst.txt -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <div class="ttr-logo-box">
                    <a href="index.html" class="ttr-logo">
                        <img alt="" class="ttr-logo-mobile" src="assets/images/logo-mobile.png" width="30" height="30">
                        <img alt="" class="ttr-logo-desktop" src="assets/images/logo-white.png" width="160" height="27">
                    </a>
                </div>
                <div class="ttr-header-menu">
                    <ul class="ttr-header-navigation">
                        <li><a href="../index.html" class="ttr-material-button ttr-submenu-toggle">HOME</a></li>
                        <li><a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="../courses.html">Our Courses</a></li>
                                    <li><a href="../event.html">New Event</a></li>
                                    <li><a href="../membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <ul class="ttr-header-navigation">
                        <li><a href="#" class="ttr-material-button ttr-search-toggle"><i class="fa fa-search"></i></a></li>
                        <li><a href="#" class="ttr-material-button ttr-submenu-toggle"><i class="fa fa-bell"></i></a>
                            <div class="ttr-header-submenu noti-menu">
                                <div class="ttr-notify-header">
                                    <span class="ttr-notify-text-top">9 New</span>
                                    <span class="ttr-notify-text">User Notifications</span>
                                </div>
                                <div class="noti-box-list">
                                    <ul>
                                        <li>
                                            <span class="notification-icon dashbg-gray">
                                                <i class="fa fa-check"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 02:14</span>
                                            </span>
                                        </li>
                                        <!-- Additional notifications can go here -->
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="#" class="ttr-material-button ttr-submenu-toggle">
                                <span class="ttr-user-avatar"><img alt="" src="assets/images/testimonials/pic3.jpg" width="32" height="32"></span>
                            </a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="user-profile.html">My profile</a></li>
                                    <li><a href="list-view-calendar.html">Activity</a></li>
                                    <li><a href="mailbox.html">Messages</a></li>
                                    <li><a href="../login.html">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </header>

        <!-- Left sidebar menu from tesst.txt -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <div class="ttr-sidebar-logo">
                    <a href="#"><img alt="" src="assets/images/logo.png" width="122" height="27"></a>
                    <div class="ttr-sidebar-toggle-button">
                        <i class="ti-arrow-left"></i>
                    </div>
                </div>
                <nav class="ttr-sidebar-navi">
                    <ul>
                        <li><a href="index.html" class="ttr-material-button"><span class="ttr-icon"><i class="ti-home"></i></span><span class="ttr-label">Dashboard</span></a></li>
                        <li><a href="SkillList" class="ttr-material-button"><span class="ttr-icon"><i class="ti-email"></i></span><span class="ttr-label">Skill</span></a></li>
                        <li><a href="#" class="ttr-material-button"><span class="ttr-icon"><i class="ti-user"></i></span><span class="ttr-label">My Profile</span></a></li>
                        <!-- Additional sidebar items can go here -->
                    </ul>
                </nav>
            </div>
        </div>

        <!-- Main Content: Change Password Form -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Change Password</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Change Password</li>
                    </ul>
                </div>  
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Change Password</h4>
                            </div>
                            <div class="widget-inner">
                                <form action="changeloggingpassword" method="post">
                                    <p>${sessionScope.acc.username}</p>
                                    <p class="info">------ Please enter your username and password ------</p>

                                    <label for="username">Account Name</label>
                                    <input type="text" id="username" name="username" class="form-control" style="width: 250px" required/>

                                    <label for="oldPassword">Old Password</label>
                                    <input type="password" id="oldPassword" name="oldPassword" class="form-control" style="width: 250px" required/>

                                    <label for="newPassword">New Password</label>
                                    <input type="password" id="newPassword" name="newPassword" class="form-control" style="width: 250px" required/>

                                    <label for="confirmPassword">Confirm New Password</label>
                                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" style="width: 250px" required/>

                                    <input type="submit" class="btn btn-primary" style="margin-top: 20px;" value="Enter"/>

                                    <p style="color: green">${requestScope.message}</p>
                                    <p style="color: red">${requestScope.error}</p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assets/vendors/counter/waypoints-min.js"></script>
        <script src="assets/vendors/counter/counterup.min.js"></script>
        <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assets/vendors/masonry/masonry.js"></script>
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/vendors/chart/chart.min.js"></script>
        <script src="assets/js/admin.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
    </body>
</html>
