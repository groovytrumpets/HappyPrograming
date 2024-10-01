
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : Home
    Created on : 11 thg 9, 2024, 10:41:32
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

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
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

        <!-- REVOLUTION SLIDER CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/layers.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/settings.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/navigation.css">
        <!-- REVOLUTION SLIDER END -->	
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <header class="header rs-nav">
                <div class="top-bar">
                    <div class="container">
                        <div class="row d-flex justify-content-between">
                            <div class="topbar-left">
                                <ul>
                                    <li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
                                    <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>Support@website.com</a></li>
                                </ul>
                            </div>
                            <div class="topbar-right">
                                <ul>

                                    <li>
                                        <select class="header-lang-bx">
                                            <option data-icon="flag flag-uk">English UK</option>
                                            <option data-icon="flag flag-us">English US</option>
                                        </select>
                                    </li>
                                    <c:if test="${sessionScope.acc == null}">
                                        <li><a href="signin">Sign In</a></li>
                                        <li><a href="signup">Sign Up</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.acc != null}">
                                        <li>Welcome ${sessionScope.acc.username} !</li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sticky-header navbar-expand-lg">
                    <div class="menu-bar clearfix">
                        <div class="container clearfix">
                            <!-- Header Logo ==== -->
                            <div class="menu-logo">
                                <a href="home"><img src="https://daihoc.fpt.edu.vn/wp-content/uploads/2023/04/cropped-cropped-2021-FPTU-Long.png" alt=""></a>
                            </div>
                            <!-- Mobile Nav Button ==== -->
                            <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                            <!-- Author Nav ==== -->
                            <div class="secondary-menu">
                                <div class="secondary-inner">
                                    <ul>
                                        <c:if test="${sessionScope.acc == null}">
                                            <li><a href="javascript:;" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                                            <li><a href="javascript:;" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                                            <li><a href="javascript:;" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
                                            <!-- Search Button ==== -->
                                            <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
                                                </c:if>
                                                <c:if test="${sessionScope.acc != null}">
                                            <li>
                                                
                                                    <div data-toggle="dropdown" aria-expanded="false">
                                                        
                                                        <span  class="ttr-user-avatar"><img class="rounded-circle" src="assets/images/testimonials/pic3.jpg" width="45" height="45"></span>
                                                        
                                                    &nbsp;&nbsp;<span>${sessionScope.acc.username}</span>
                                                    </div>
                                                    
                                                    <div class="dropdown-menu">
                                                        
                                                            <a class="dropdown-item" href="user-profile.html">My profile</a>
                                                            <a class="dropdown-item" href="list-view-calendar.html">Change Password</a>
                                                            <a class="dropdown-item" href="mailbox.html">Messages</a>
                                                            <a class="dropdown-item" href="logout">Logout</a>
                                                        
                                                    </div>
                                                
                                            </li>
                                        </c:if>

                                    </ul>
                                </div>
                            </div>
                            <!-- Search Box ==== -->
                            <div class="nav-search-bar">
                                <form action="home">
                                    <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                                    <span><i class="ti-search"></i></span>
                                </form>
                                <span id="search-remove"><i class="ti-close"></i></span>
                            </div>
                            <!-- Navigation Menu ==== -->
                            <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                                <div class="menu-logo">
                                    <a href="home"><img src="https://daihoc.fpt.edu.vn/wp-content/uploads/2023/04/cropped-cropped-2021-FPTU-Long.png" alt=""></a>
                                </div>
                                <ul class="nav navbar-nav">	
                                    <li class="active"><a href="home;">Home</a>

                                    </li>
                                    <li><a href="javascript:;">Pages <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="javascript:;">About<i class="fa fa-angle-right"></i></a>
                                                <ul class="sub-menu">
                                                    <li><a href="about-1.html">About 1</a></li>
                                                    <li><a href="about-2.html">About 2</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="javascript:;">Event<i class="fa fa-angle-right"></i></a>
                                                <ul class="sub-menu">
                                                    <li><a href="event.html">Event</a></li>
                                                    <li><a href="events-details.html">Events Details</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="javascript:;">FAQ's<i class="fa fa-angle-right"></i></a>
                                                <ul class="sub-menu">
                                                    <li><a href="faq-1.html">FAQ's 1</a></li>
                                                    <li><a href="faq-2.html">FAQ's 2</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="javascript:;">Contact Us<i class="fa fa-angle-right"></i></a>
                                                <ul class="sub-menu">
                                                    <li><a href="contact-1.html">Contact Us 1</a></li>
                                                    <li><a href="contact-2.html">Contact Us 2</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="portfolio.html">Portfolio</a></li>
                                            <li><a href="profile.html">Profile</a></li>
                                            <li><a href="membership.html">Membership</a></li>
                                            <li><a href="error-404.html">404 Page</a></li>
                                        </ul>
                                    </li>
                                    <li class="add-mega-menu"><a href="javascript:;">Our Mentor <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu add-menu">
                                            <li class="add-menu-left">
                                                <h5 class="menu-adv-title">Our Mentor</h5>
                                                <ul>
                                                    <li><a href="courses.html">Courses </a></li>
                                                    <li><a href="courses-details.html">Courses Details</a></li>
                                                    <li><a href="profile.html">Instructor Profile</a></li>
                                                    <li><a href="event.html">Upcoming Event</a></li>
                                                    <li><a href="membership.html">Membership</a></li>
                                                </ul>
                                            </li>
                                            <li class="add-menu-right">
                                                <img src="assets/images/adv/adv.jpg" alt=""/>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="javascript:;">Blog <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="blog-classic-grid.html">Blog Classic</a></li>
                                            <li><a href="blog-classic-sidebar.html">Blog Classic Sidebar</a></li>
                                            <li><a href="blog-list-sidebar.html">Blog List Sidebar</a></li>
                                            <li><a href="blog-standard-sidebar.html">Blog Standard Sidebar</a></li>
                                            <li><a href="blog-details.html">Blog Details</a></li>
                                        </ul>
                                    </li>
                                    <li class="nav-dashboard"><a href="javascript:;">Dashboard <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="admin/index.html">Dashboard</a></li>
                                            <li><a href="admin/add-listing.html">Add Listing</a></li>
                                            <li><a href="admin/bookmark.html">Bookmark</a></li>
                                            <li><a href="admin/courses.html">Courses</a></li>
                                            <li><a href="admin/review.html">Review</a></li>
                                            <li><a href="admin/teacher-profile.html">Teacher Profile</a></li>
                                            <li><a href="admin/user-profile.html">User Profile</a></li>
                                            <li><a href="javascript:;">Calendar<i class="fa fa-angle-right"></i></a>
                                                <ul class="sub-menu">
                                                    <li><a href="admin/basic-calendar.html">Basic Calendar</a></li>
                                                    <li><a href="admin/list-view-calendar.html">List View Calendar</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="javascript:;">Mailbox<i class="fa fa-angle-right"></i></a>
                                                <ul class="sub-menu">
                                                    <li><a href="admin/mailbox.html">Mailbox</a></li>
                                                    <li><a href="admin/mailbox-compose.html">Compose</a></li>
                                                    <li><a href="admin/mailbox-read.html">Mail Read</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                                <div class="nav-social-link">
                                    <a href="javascript:;"><i class="fa fa-facebook"></i></a>
                                    <a href="javascript:;"><i class="fa fa-google-plus"></i></a>
                                    <a href="javascript:;"><i class="fa fa-linkedin"></i></a>
                                </div>
                            </div>
                            <!-- Navigation Menu END ==== -->
                        </div>
                    </div>
                </div>
            </header>
            <!-- Header Top END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- Main Slider -->
                <div class="section-area section-sp1 ovbl-dark bg-fix online-cours">
                    <video autoplay muted loop style="position: absolute;top: 50%;
                           left: 50%;
                           width: 100%;
                           height: 100%;object-fit: cover;transform: translate(-50%, -50%);">
                        <source src="https://www.harvard.edu/wp-content/uploads/2024/08/215303_small.mp4" type="video/mp4">
                    </video>

                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 text-center text-white">
                                <h2>Find a Hiring mentor</h2>
                                <h5>Struggling to mastering Hiring on your own?</h5>
                                <form class="cours-search" action="home">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="What do you want to learn today?	" name="search">
                                        <div class="input-group-append">
                                            <button class="btn" type="submit">Search</button> 
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="mw800 m-auto">
                            <div class="row">
                                <div class="col-md-4 col-sm-6">
                                    <div class="cours-search-bx m-b30">
                                        <div class="icon-box">
                                            <h3><i class="ti-user"></i><span class="counter">${requestScope.userNum}</span>+</h3>
                                        </div>
                                        <span class="cours-search-text">Clients</span>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-6">
                                    <div class="cours-search-bx m-b30">
                                        <div class="icon-box">
                                            <h3><i class="ti-book"></i><span class="counter">5</span>x</h3>
                                        </div>
                                        <span class="cours-search-text">Success Rate</span>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-12">
                                    <div class="cours-search-bx m-b30">
                                        <div class="icon-box">
                                            <h3><i class="ti-layout-list-post"></i><span class="counter">95</span>%</h3>
                                        </div>
                                        <span class="cours-search-text">Satisfaction</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Main Slider -->
                <div class="content-block">
                    <!-- Popular Courses -->
                    <div class="section-area section-sp2 popular-courses-bx">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 heading-bx left">
                                    <h2 class="title-head">Top Hiring <span>Mentor</span></h2>
                                    <p>Get mentored by industry-leading Hiring experts to mentor you towards your Hiring skill goals.</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="courses-carousel owl-carousel owl-btn-1 col-12 p-lr0">
                                    <div class="item">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <img src="assets/images/courses/pic1.jpg" alt="">
                                                <a href="#" class="btn">Read More</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                <span>Programming</span>
                                            </div>
                                            <div class="cours-more-info">
                                                <div class="review">
                                                    <span>3 Review</span>
                                                    <ul class="cours-star">
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                    </ul>
                                                </div>
                                                <div class="price">
                                                    <del>$190</del>
                                                    <h5>$120</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <img src="assets/images/courses/pic2.jpg" alt="">
                                                <a href="#" class="btn">Read More</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                <span>Programming</span>
                                            </div>
                                            <div class="cours-more-info">
                                                <div class="review">
                                                    <span>3 Review</span>
                                                    <ul class="cours-star">
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                    </ul>
                                                </div>
                                                <div class="price">
                                                    <del>$190</del>
                                                    <h5>$120</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <img src="assets/images/courses/pic3.jpg" alt="">
                                                <a href="#" class="btn">Read More</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                <span>Programming</span>
                                            </div>
                                            <div class="cours-more-info">
                                                <div class="review">
                                                    <span>3 Review</span>
                                                    <ul class="cours-star">
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                    </ul>
                                                </div>
                                                <div class="price">
                                                    <del>$190</del>
                                                    <h5>$120</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <img src="assets/images/courses/pic4.jpg" alt="">
                                                <a href="#" class="btn">Read More</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                <span>Programming</span>
                                            </div>
                                            <div class="cours-more-info">
                                                <div class="review">
                                                    <span>3 Review</span>
                                                    <ul class="cours-star">
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                    </ul>
                                                </div>
                                                <div class="price">
                                                    <del>$190</del>
                                                    <h5>$120</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Popular Courses END -->
                    <div class="section-area section-sp2 bg-fix ovbl-dark join-bx text-center" style="background-image:url(https://daihoc.fpt.edu.vn/templates/fpt-university/images/header.jpg);">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="join-content-bx text-white">
                                        <h2>At your fingertips: <br>  dedicated career coach</h2>
                                        <h4><span class="counter">${requestScope.mentorNum}</span>+ mentors available</h4>
                                        <p>Want to start a new dream career? Successfully build your startup? Itching to learn high-demand skills? Work smart with an online mentor by your side to offer expert advice and guidance to match your zeal. Become unstoppable using HappyPrograming.</p>
                                        <a href="#" class="btn button-md">Join Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Form END -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6 m-b30">
                                    <h2 class="title-head ">Achieve your goals with <br> <span class="text-primary"> the help of a Hiring mentor</span></h2>
                                    <h4><span class="counter">2000</span>+ Mentor</h4>
                                    <p>Reaching new heights is easier when you do so with some help from qualified mentors. Know everything that there is to know about one of the fastest-growing languages out there today.</p>
                                    <a href="#" class="btn button-md">Join Now</a>
                                </div>
                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon1.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Learn under a team of mentors</h5>
                                                    <p>Why learn from 1 mentor when you can learn from 2? Sharpen your Hiring skills with the guidance of multiple mentors.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon2.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Hand-picked online Hiring mentors</h5>
                                                    <p>Get pros to make you a pro. We mandate the highest standards for competency and communication.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon3.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Real Hiring industry experience</h5>
                                                    <p>Master Hiring, no fluff. Only expert advice to help you hone your skills.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon4.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Cancel anytime</h5>
                                                    <p>Hiring expert by retaining the ability to end, pause, and continue your mentorship subscription as you please.</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Testimonials -->
                    <div class="section-area section-sp1 bg-fix ovbl-dark text-white" style="background-image:url(https://daihoc.fpt.edu.vn/templates/fpt-university/images/header.jpg);">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">3000</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Completed Request</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">${requestScope.userNum}</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Happy Clients</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">1500</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Questions Answered</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">1000</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Ordered Coffee's</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Testimonials END -->
                    <!-- Testimonials ==== -->
                    <div class="section-area section-sp2">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 heading-bx left">
                                    <h2 class="title-head text-uppercase">what people <span>say</span></h2>
                                    <p>We’ve already delivered 1-on-1 mentorship to thousands of students, professionals, managers and executives</p>
                                </div>
                            </div>
                            <div class="testimonial-carousel owl-carousel owl-btn-1 col-12 p-lr0">

                                <div class="item">
                                    <div class="testimonial-bx">
                                        <div class="testimonial-thumb">
                                            <img src="assets/images/testimonials/pic1.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h5 class="name">Peter Packer</h5>
                                            <p>-Art Director</p>
                                        </div>
                                        <div class="testimonial-content">
                                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...</p>
                                        </div>
                                    </div>
                                </div>

                                <div class="item">
                                    <div class="testimonial-bx">
                                        <div class="testimonial-thumb">
                                            <img src="assets/images/testimonials/pic2.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h5 class="name">Peter Packer</h5>
                                            <p>-Art Director</p>
                                        </div>
                                        <div class="testimonial-content">
                                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type...</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Testimonials END ==== -->
                </div>
                <!-- contact area END -->
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <footer>
                <div class="footer-top">
                    <div class="pt-exebar">
                        <div class="container">
                            <div class="d-flex align-items-stretch">
                                <div class="pt-logo mr-auto" style="width: 200px">
                                    <a href="home"><img src="https://daihoc.fpt.edu.vn/wp-content/uploads/2023/04/cropped-cropped-2021-FPTU-Long.png" alt=""/></a>
                                </div>
                                <div class="pt-social-link">
                                    <ul class="list-inline m-a0">
                                        <li><a href="#" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                                <div class="pt-btn-join">
                                    <a href="#" class="btn ">Join Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-12 col-sm-12 footer-col-4">
                                <div class="widget">
                                    <h5 class="footer-title">Sign Up For A Newsletter</h5>
                                    <p class="text-capitalize m-b20">Weekly Breaking news analysis and cutting edge advices on job searching.</p>
                                    <div class="subscribe-form m-b20">
                                        <form class="subscription-form" action="http://educhamp.themetrades.com/demo/assets/script/mailchamp.php" method="post">
                                            <div class="ajax-message"></div>
                                            <div class="input-group">
                                                <input name="email" required="required"  class="form-control" placeholder="Your Email Address" type="email">
                                                <span class="input-group-btn">
                                                    <button name="submit" value="Submit" type="submit" class="btn"><i class="fa fa-arrow-right"></i></button>
                                                </span> 
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-5 col-md-7 col-sm-12">
                                <div class="row">
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Company</h5>
                                            <ul>
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="about-1.html">About</a></li>
                                                <li><a href="faq-1.html">FAQs</a></li>
                                                <li><a href="contact-1.html">Contact</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Get In Touch</h5>
                                            <ul>
                                                <li><a href="http://educhamp.themetrades.com/admin/index.html">Dashboard</a></li>
                                                <li><a href="blog-classic-grid.html">Blog</a></li>
                                                <li><a href="portfolio.html">Portfolio</a></li>
                                                <li><a href="event.html">Event</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Courses</h5>
                                            <ul>
                                                <li><a href="courses.html">Courses</a></li>
                                                <li><a href="courses-details.html">Details</a></li>
                                                <li><a href="membership.html">Membership</a></li>
                                                <li><a href="profile.html">Profile</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-5 col-sm-12 footer-col-4">
                                <div class="widget widget_gallery gallery-grid-4">
                                    <h5 class="footer-title">Our Gallery</h5>
                                    <ul class="magnific-image">
                                        <li><a href="assets/images/gallery/pic1.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic1.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic2.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic2.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic3.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic3.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic4.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic4.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic5.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic5.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic6.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic6.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic7.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic7.jpg" alt=""></a></li>
                                        <li><a href="assets/images/gallery/pic8.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic8.jpg" alt=""></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 text-center"><a target="_blank" href="home">© 2024 HappyPrograming. All Rights Reserved.</a></div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- Footer END ==== -->
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>

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
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <!-- comment <script src='assets/vendors/switcher/switcher.js'></script>-->
    </body>

</html>


