<%-- 
    Document   : rateMentor
    Created on : Oct 6, 2024, 8:01:59 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.Mentor" %>
<%@ page import="DAO.MentorDAO" %>
<%
    int mentorId = Integer.parseInt(request.getParameter("mentorId"));
    MentorDAO mentorDAO = new MentorDAO();
    Mentor mentor = mentorDAO.getMentorById(mentorId); // Assuming you have this method

    // Retrieve menteeId from request attribute
    int menteeId = (int) request.getAttribute("menteeId");
%>

<!DOCTYPE html>
<html lang="en">
    <!-- Mirrored from educhamp.themetrades.com/demo/admin/teacher-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
    <head>
        <title>Rate Mentor</title>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Create CV of mentor</title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

        <!-- Star Rating CSS -->
        <style>
            .star-rating {
                direction: rtl;
                display: inline-block;
                font-size: 20px;
            }
            .star-rating input[type="radio"] {
                display: none;
            }
            .star-rating label {
                color: #ddd;
                font-size: 30px;
                cursor: pointer;
            }
            .star-rating input:checked ~ label {
                color: #f5b301;
            }
            .star-rating label:hover,
            .star-rating label:hover ~ label {
                color: #f5b301;
            }
        </style>
    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <!-- Header Menu Start -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <div class="ttr-logo-box">
                    <div>
                        <a href="index.html" class="ttr-logo">
                            <img alt="" class="ttr-logo-mobile" src="assets/images/logo-mobile.png" width="30" height="30">
                            <img alt="" class="ttr-logo-desktop" src="assets/images/logo-white.png" width="160" height="27">
                        </a>
                    </div>
                </div>
                <div class="ttr-header-menu">
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="index.html" class="ttr-material-button">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="courses.html">Our Courses</a></li>
                                    <li><a href="event.html">New Event</a></li>
                                    <li><a href="membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="ttr-header-right">
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="#" class="ttr-material-button"><i class="fa fa-search"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
        <!-- Header Menu End -->

        <!--Main container start-->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Rate Mentor</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Rate Mentor</li>
                    </ul>
                </div>	
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="widget-inner">
                                <form action="ratementor" method="POST">
                                    <input type="hidden" name="menteeId" value="<%= menteeId %>" />
                                    <input type="hidden" name="mentorId" value="<%= mentorId %>" />

                                    <!-- Rating Section -->
                                    <h3><%= mentor.getFullName() %></h3>
                                    <h4>FPT University</h4>
                                    
                                    <div class="star-rating">
                                        
                                        <input type="radio" id="5-stars" name="rating" value="5"><label for="5-stars">★</label>
                                        <input type="radio" id="4-stars" name="rating" value="4"><label for="4-stars">★</label>
                                        <input type="radio" id="3-stars" name="rating" value="3"><label for="3-stars">★</label>
                                        <input type="radio" id="2-stars" name="rating" value="2"><label for="2-stars">★</label>
                                        <input type="radio" id="1-star" name="rating" value="1"><label for="1-star">★</label>
                                    </div>

                                    <!-- Comment Section -->
                                    <h3>Comment:</h3>
                                    <textarea name="comment" rows="4" cols="50" placeholder="Leave your comment here..."></textarea><br>

                                    <input type="submit" value="Submit Rating">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!--Main container end-->

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
    </body>
</html>
