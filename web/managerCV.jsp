<%-- 
    Document   : CVmanager
    Created on : 11 thg 10, 2024, 11:53:23
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
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
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <!--sidebar menu toggler start -->
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <!--sidebar menu toggler end -->
                <!--logo start -->
                <div class="ttr-logo-box">
                    <div>
                        <a href="index.html" class="ttr-logo">
                            <img class="ttr-logo-mobile" alt="" src="assets/images/logo-mobile.png" width="30" height="30">
                            <img class="ttr-logo-desktop" alt="" src="assets/images/logo-white.png" width="160" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <!-- header left menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="../index.html" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="../courses.html">Our Courses</a></li>
                                    <li><a href="../event.html">New Event</a></li>
                                    <li><a href="../membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header left menu end -->
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <!-- header right menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="#" class="ttr-material-button ttr-search-toggle"><i class="fa fa-search"></i></a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><i class="fa fa-bell"></i></a>
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
                                        <li>
                                            <span class="notification-icon dashbg-yellow">
                                                <i class="fa fa-shopping-cart"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Your order is placed</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 7 Min</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-red">
                                                <i class="fa fa-bullhorn"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Your item is shipped</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 2 May</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-green">
                                                <i class="fa fa-comments-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Sneha Jogi</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 14 July</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-primary">
                                                <i class="fa fa-file-word-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 15 Min</span>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="assets/images/testimonials/pic3.jpg" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="user-profile.html">My profile</a></li>
                                    <li><a href="list-view-calendar.html">Activity</a></li>
                                    <li><a href="mailbox.html">Messages</a></li>
                                    <li><a href="../login.html">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="ttr-hide-on-mobile">
                            <a href="#" class="ttr-material-button"><i class="ti-layout-grid3-alt"></i></a>
                            <div class="ttr-header-submenu ttr-extra-menu">
                                <a href="#">
                                    <i class="fa fa-music"></i>
                                    <span>Musics</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-youtube-play"></i>
                                    <span>Videos</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-envelope"></i>
                                    <span>Emails</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-book"></i>
                                    <span>Reports</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-smile-o"></i>
                                    <span>Persons</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-picture-o"></i>
                                    <span>Pictures</span>
                                </a>
                            </div>
                        </li>
                    </ul>
                    <!-- header right menu end -->
                </div>
                <!--header search panel start -->
                <div class="ttr-search-bar">
                    <form class="ttr-search-form">
                        <div class="ttr-search-input-wrapper">
                            <input type="text" name="qq" placeholder="search something..." class="ttr-search-input">
                            <button type="submit" name="search" class="ttr-search-submit"><i class="ti-arrow-right"></i></button>
                        </div>
                        <span class="ttr-search-close ttr-search-toggle">
                            <i class="ti-close"></i>
                        </span>
                    </form>
                </div>
                <!--header search panel end -->
            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <!-- side menu logo start -->
                <div class="ttr-sidebar-logo">
                    <a href="#"><img alt="" src="assets/images/logo.png" width="122" height="27"></a>
                    <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                            <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                            <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
                    </div> -->
                    <div class="ttr-sidebar-toggle-button">
                        <i class="ti-arrow-left"></i>
                    </div>
                </div>
                <!-- side menu logo end -->
                <!-- sidebar menu start -->
                <nav class="ttr-sidebar-navi">
                    <ul>
                        <li>
                            <a href="index.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-home"></i></span>
                                <span class="ttr-label">Dashborad</span>
                            </a>
                        </li>
                        <li>
                            <a href="courses.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Courses</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-email"></i></span>
                                <span class="ttr-label">Mailbox</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="mailbox.html" class="ttr-material-button"><span class="ttr-label">Mail Box</span></a>
                                </li>
                                <li>
                                    <a href="mailbox-compose.html" class="ttr-material-button"><span class="ttr-label">Compose</span></a>
                                </li>
                                <li>
                                    <a href="mailbox-read.html" class="ttr-material-button"><span class="ttr-label">Mail Read</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-calendar"></i></span>
                                <span class="ttr-label">Calendar</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="basic-calendar.html" class="ttr-material-button"><span class="ttr-label">Basic Calendar</span></a>
                                </li>
                                <li>
                                    <a href="list-view-calendar.html" class="ttr-material-button"><span class="ttr-label">List View</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="bookmark.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
                                <span class="ttr-label">Bookmarks</span>
                            </a>
                        </li>
                        <li>
                            <a href="review.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-comments"></i></span>
                                <span class="ttr-label">Review</span>
                            </a>
                        </li>
                        <li>
                            <a href="add-listing.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Add listing</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-user"></i></span>
                                <span class="ttr-label">My Profile</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="user-profile.html" class="ttr-material-button"><span class="ttr-label">User Profile</span></a>
                                </li>
                                <li>
                                    <a href="teacher-profile.html" class="ttr-material-button"><span class="ttr-label">Teacher Profile</span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="ttr-seperate"></li>
                    </ul>
                    <!-- sidebar menu end -->
                </nav>
                <!-- sidebar menu end -->
            </div>
        </div>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Dashboard</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Dashboard</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg1">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Total Frofit
                                </h4>
                                <span class="wc-des">
                                    All Customs Value
                                </span>
                                <span class="wc-stats">
                                    $<span class="counter">18</span>M 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 78%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        78%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg2">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    New Feedbacks
                                </h4>
                                <span class="wc-des">
                                    Customer Review
                                </span>
                                <span class="wc-stats counter">
                                    120 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 88%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        88%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg3">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    New Orders 
                                </h4>
                                <span class="wc-des">
                                    Fresh Order Amount 
                                </span>
                                <span class="wc-stats counter">
                                    772 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 65%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        65%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg4">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    New Users 
                                </h4>
                                <span class="wc-des">
                                    Joined New User
                                </span>
                                <span class="wc-stats counter">
                                    350 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 90%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        90%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                </div>
                <!-- Card END -->


                <div class="row">
                    <!-- Your Profile Views Chart -->



                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">

                            <div class="wc-title d-flex align-items-center">
                                <h4 class="d-inline-block" >Mentor List</h4>
                                <form action="managersearch" class="d-inline-block ml-auto" style="width: 300px">
                                    
                                        <div>
                                            <input type="text" class="form-control" placeholder="Search" name="mentor">
                                        </div>
                                    
                                </form>
                            </div>
                            <div class="widget-inner">
                                <div class="new-user-list" >
                                    <table class="table">
                                        <thead class="thead-light">
                                            <tr>
                                                <th scope="col">id#</th>
                                                <th scope="col">Account Name</th>
                                                <th scope="col">Avatar</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.mentorList}" var="c">

                                                <tr>
                                                    <th class="align-middle" scope="row">${c.mentorId}</th>
                                                    <td class="align-middle" style="max-width: 20px;word-wrap: break-word;">${c.username}</td>
                                                    <td class="align-middle">
                                                        <c:forEach items="${requestScope.listActiveCV}" var="cv">
                                                            <c:if test="${c.mentorId==cv.mentorId}">                                                            ${u.email}
                                                                <img src="getCVimage?id=${cv.cvId}" alt="" class="" style=" width: 75px;height: 75px;object-fit: cover;"/>
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td class="align-middle" style="max-width: 200px;word-wrap: break-word;">
                                                        <c:forEach items="${requestScope.listUser}" var="u">
                                                            <c:if test="${c.username==u.username}">
                                                                ${u.email}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>                                                
                                                    <td class="align-middle">
                                                        <span class="orders-btn">
                                                            <a href="cvmanagercate?id=${c.mentorId}" class="btn button-sm green">View CV List</a>
                                                        </span>
                                                    </td>
                                                </tr>
                                            </c:forEach>



                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">
                            <div class="wc-title d-flex align-items-center">
                                <h4 class="d-inline-block" >CV List</h4>
                                
                                    
                                    <div class="d-inline-block ml-auto">
                                        <a href="cvmanager" class="btn button-layout purple">Reset</a>
                                        </div>
                                    
                                
                            </div>
                            <div class="widget-inner">
                                <div class="orders-list">
                                    <c:if test="${not empty requestScope.error}">
                                        <div class="alert alert-danger" role="alert">
                                            ${requestScope.error}
                                        </div>
                                    </c:if>
                                    <ul>
                                        <c:forEach items="${requestScope.listCV}" var="v">

                                            <li>
                                                <span class="orders-title">
                                                    <a href="#" class="orders-title-name">${v.mentorId}</a>
                                                    <span class="orders-info">CV #${v.cvId} | Last change ${v.createDate}</span>
                                                </span>
                                                <c:if test="${v.status.equals('inactive')}">
                                                    <span class="orders-btn">
                                                        <a href="activecv?id=${v.cvId}" class="btn button-sm red">Inactive</a>
                                                        <a data-toggle="modal" data-target="#exampleModal${v.cvId}" href="#" class="btn button-sm primary ">View</a>
                                                    </span>

                                                </c:if>
                                                <c:if test="${v.status.equals('active')}">
                                                    <span class="orders-btn">
                                                        <a href="activecv?id=${v.cvId}" class="btn button-sm green">Active</a>
                                                        <a data-toggle="modal" data-target="#exampleModal${v.cvId}" href="#" class="btn button-sm primary ">View</a>
                                                    </span>
                                                </c:if>

                                            </li>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal${v.cvId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog modal-lg">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <c:forEach items="${requestScope.mentorList}" var="c">
                                                                <c:if test="${c.mentorId==v.mentorId}">
                                                                    <h5 class="modal-title text-center" id="exampleModalLabel">CV of Mentor: ${c.username}</h5>
                                                                </c:if>
                                                            </c:forEach>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>

                                                        <div class="modal-body">
                                                            <div class="widget-box">
                                                                <div class="widget-inner">
                                                                    <form class="edit-profile m-b30" action="cvcreate" method="post" enctype="multipart/form-data">
                                                                        <div class="row">
                                                                            <div class="col-12">
                                                                                <div class="ml-auto">
                                                                                    <h3>1. Personal Details</h3>
                                                                                </div>
                                                                            </div>



                                                                            <c:forEach items="${requestScope.mentorList}" var="c">
                                                                                <c:if test="${c.mentorId==v.mentorId}">
                                                                                    <div class="form-group col-12">
                                                                                        <div class=" text-center">

                                                                                            <img id="userAvatar" src="getCVimage?id=${v.cvId}" class="rounded-circle" alt="" style=" margin: 50px 10px;width: 150px;height: 150px;object-fit: cover;">
                                                                                            <div id="Imgstatus"></div>
                                                                                        </div>
                                                                                        <div style="text-align: center">
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-6">
                                                                                        <label class="col-form-label font-weight-bold">Full Name</label>
                                                                                        <div>
                                                                                            ${c.fullName}

                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-6">
                                                                                        <label class="col-form-label font-weight-bold">Account name</label>
                                                                                        <div>
                                                                                            ${c.username}
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-6">
                                                                                        <label class="col-form-label font-weight-bold">Date of Birth</label>
                                                                                        <div>
                                                                                            ${c.dateOfBirthFormatted}
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-6">
                                                                                        <label class="col-form-label font-weight-bold">Email</label>
                                                                                        <div>
                                                                                            <c:forEach items="${requestScope.listUser}" var="u">
                                                                                                <c:if test="${c.username==u.username}">
                                                                                                    ${u.email}
                                                                                                </c:if>
                                                                                            </c:forEach>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-3">
                                                                                        <label class="col-form-label font-weight-bold">Phone number</label>
                                                                                        <div>
                                                                                            ${c.phone}
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-3">
                                                                                        <label class="col-form-label font-weight-bold">Sex</label>
                                                                                        <div>
                                                                                            ${c.gender}

                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="form-group col-6">
                                                                                        <label class="col-form-label font-weight-bold">Address</label>
                                                                                        <div>
                                                                                            ${c.address}
                                                                                        </div>
                                                                                    </div>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <div class="seperator"></div>

                                                                            <div class="col-12 m-t20">
                                                                                <div class="ml-auto m-b5">
                                                                                    <h3>2. CV detail</h3>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Profession</label>
                                                                                <div>
                                                                                    ${v.jobProfession}
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Framework</label>
                                                                                <div>
                                                                                    ${v.framework}
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-3">
                                                                                <label class="col-form-label font-weight-bold">Education</label>
                                                                                <div>
                                                                                    ${v.education}
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-3">
                                                                                <label class="col-form-label font-weight-bold">Price</label>
                                                                                <div>
                                                                                    ${v.price}
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Activity</label>
                                                                                <div>
                                                                                    ${v.activity}
                                                                                </div>
                                                                            </div>

                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Profession Introduction</label>
                                                                                <div>
                                                                                    ${v.professionIntroduction}
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Service description</label>
                                                                                <div>
                                                                                    ${v.serviceDescription}
                                                                                </div>
                                                                            </div>

                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Skills</label><br/>
                                                                                <div>

                                                                                    <c:forEach items="${requestScope.listSkillList}" var="s">
                                                                                        <c:if test="${v.cvId==s.cvId}">
                                                                                            <c:forEach items="${requestScope.listSkill}" var="x">
                                                                                                <c:if test="${s.skillId==x.skillId}">
                                                                                                    <label class="col-form-label" >
                                                                                                        ${x.skillName} &nbsp;&nbsp;&nbsp;&nbsp;         
                                                                                                    </label>
                                                                                                </c:if>    
                                                                                            </c:forEach>

                                                                                        </c:if>
                                                                                    </c:forEach>

                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group col-6">
                                                                                <label class="col-form-label font-weight-bold">Archivement description</label>
                                                                                <div>
                                                                                    ${v.experience}
                                                                                </div>
                                                                            </div>


                                                                            <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>


                                                                            <div class="col-12">
                                                                                <br/>

                                                                            </div>
                                                                        </div>
                                                                    </form>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </ul>




                                </div>
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
        <script src='assets/vendors/calendar/moment.min.js'></script>
        <script src='assets/vendors/calendar/fullcalendar.js'></script>


    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
