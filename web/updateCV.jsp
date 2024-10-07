<%-- 
    Document   : updateCV
    Created on : 17 thg 9, 2024, 12:33:22
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/teacher-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
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
        <title>Update CV of mentor</title>

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
                            <img alt="" class="ttr-logo-mobile" src="assets/images/logo-mobile.png" width="30" height="30">
                            <img alt="" class="ttr-logo-desktop" src="assets/images/logo-white.png" width="160" height="27">
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
                                    <a href="teacher-profile.html" class="ttr-material-button"><span class="ttr-label">Update CV of mentor</span></a>
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
                    <h4 class="breadcrumb-title">Update CV of mentor</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Update CV of mentor</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Update CV of mentor</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="cvupdate" method="post" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="ml-auto">
                                                <h3>1. Personal Details</h3>
                                            </div>
                                        </div>


                                        <div>
                                            <input class="form-control" type="hidden" name="mentorId" value="${requestScope.uFound.mentorId}" >
                                            <input class="form-control" type="hidden" name="cvId" value="${requestScope.cvId}" >
                                            
                                        </div>
                                        <div class="form-group col-12">
                                            <div class=" text-center">
                                                
                                                <img id="userAvatar" src="getCVimage?id=${requestScope.cvFound.cvId}" class="rounded-circle" alt="" style=" margin: 50px 10px;width: 150px">
                                            </div>
                                            <div>
                                                <div style="text-align: center">
                                                <label for="avatar" class="btn-secondry">Avatar file</label>
                                                <span id="file-path"></span>
                                                <input id="avatar" class="form-control" type="file" name="avatar" value="${requestScope.cvFound.avatar}" accept=".jpg, .jpeg, .png, .gif" hidden>
                                                <% String errorMessage = request.getParameter("errorMessage"); %>
<% if (errorMessage != null) { %>
    <div class="alert alert-danger"><%= errorMessage %></div>
<% } %>
                                                <c:if test="${requestScope.error2!=null}">
                                                    <span class="help" style="color: red">Your file is too big, please choose file smaller than 5MB.</span>
                                                </c:if>
                                                    
                                                 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Full Name</label>
                                            <div>
                                                <input class="form-control" type="text" name="fullname" value="${requestScope.uFound.fullName}" required >
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Account name</label>
                                            <div>
                                                <input class="form-control" type="text" name="username" value="${requestScope.uFound.username}"required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Date of Birth</label>
                                            <div>
                                                <input class="form-control" type="date" name="dob" value="${requestScope.uFound.dateOfBirth}"required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Email</label>
                                            <div>
                                                <c:if test="${requestScope.error==email_exists}">
                                                <input class="form-control" type="email" name="email" value="${requestScope.email}" required>
                                                </c:if>
                                                <c:if test="${requestScope.error!=email_exists}">
                                                    <input class="form-control" type="email" name="email" value="" required>
                                                <span class="help" style="color: red">Your email used by another user !</span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Phone No.</label>
                                            <div>
                                                <input class="form-control" type="number" name="phone" value="${requestScope.uFound.phone}">
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Sex</label>
                                            <div>
                                                <select name="gender" class="">
                                                    <option value="Male"<c:if test="${requestScope.uFound.gender == 'Male'}">selected</c:if>>Male</option>
                                                    <option value="Female"<c:if test="${requestScope.uFound.gender == 'Female'}">selected</c:if>>Female</option>
                                                    <option value="Other"<c:if test="${requestScope.uFound.gender == 'Other'}">selected</c:if>>Other</option>
                                                    </select>

                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Address</label>
                                                <div>
                                                    <input class="form-control" type="text" name="address" value="${requestScope.uFound.address}">
                                            </div>
                                        </div>

                                        <div class="seperator"></div>

                                        <div class="col-12 m-t20">
                                            <div class="ml-auto m-b5">
                                                <h3>2. CV detail</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Profession</label>
                                            <div>
                                                <input class="form-control" type="text" name="profession" value="${requestScope.cvFound.jobProfession}">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Framework</label>
                                            <div>
                                                <input class="form-control" type="text" name="framework" value="${requestScope.cvFound.framework}">
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Education</label>
                                            <div>
                                                <input class="form-control" type="text" name="education" value="${requestScope.cvFound.education}">
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Price</label>
                                            <div>
                                                <input class="form-control" type="number" name="price" step="0.0001" value="${requestScope.cvFound.price}"required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Activity</label>
                                            <div>
                                                <input class="form-control" type="text" name="activity" value="${requestScope.cvFound.activity}">
                                            </div>
                                        </div>

                                        <div class="form-group col-6">
                                            <label class="col-form-label">Profession Introduction</label>
                                            <div>
                                                <textarea class="form-control" name="professionIntroduction" >${requestScope.cvFound.professionIntroduction} </textarea>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Service description</label>
                                            <div>
                                                <textarea class="form-control" name="serviceDescription">${requestScope.cvFound.serviceDescription} </textarea>
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Select skills</label><br/>
                                            <label class="col-form-label"><i>Delete Your Skills</i></label>
                                            <div>
                                                <ul class="border p-3 rounded mr-3 mb-3" class="category" style="list-style-type: none;display: flex; flex-wrap: wrap; gap: 10px;">
                                                    <c:forEach items="${requestScope.skillMentor}" var="c">
                                                        <li>
                                                            <div class="check-box">
                                                                <label class="col-form-label">
                                                                    <input type="checkbox" class="checkbox" name="deleteSkills" value="${c.skillId}">
                                                                    ${c.skillName} </label>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <br/>
                                            <label class="col-form-label"><i>Add Skills</i></label>
                                            <div>
                                                <ul class="border p-3 rounded mr-3 mb-3" class="category" style="list-style-type: none;display: flex; flex-wrap: wrap; gap: 10px;">
                                                    <c:forEach items="${requestScope.skillList}" var="c">
                                                        <li>
                                                            <div class="check-box">
                                                                <label class="col-form-label">
                                                                    <input type="checkbox" class="checkbox" name="addSkills" value="${c.skillId}">
                                                                    ${c.skillName}</label>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Archivement description</label>
                                            <div>
                                                <textarea class="form-control" name="experience">${requestScope.cvFound.experience} </textarea>
                                            </div>
                                        </div>


                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>


                                        <div class="col-12">
                                            <button type="submit" class="btn">Save changes</button>
                                            <a href="cvlist?id=${requestScope.cvFound.mentorId}" type="reset" style=" color: white" class="btn-secondry">Cancel</a>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
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
        <!-- comment<script src='assets/vendors/switcher/switcher.js'></script> -->
        <script>
            // Pricing add
            function newMenuItem() {
                var newElem = $('tr.list-item').first().clone();
                newElem.find('input').val('');
                newElem.appendTo('table#item-add');
            }
            if ($("table#item-add").is('*')) {
                $('.add-item').on('click', function (e) {
                    e.preventDefault();
                    newMenuItem();
                });
                $(document).on("click", "#item-add .delete", function (e) {
                    e.preventDefault();
                    $(this).parent().parent().parent().parent().remove();
                });
            }
            //file path
            const input = document.getElementById('avatar');
            const filePathDisplay = document.getElementById('file-path');

            input.addEventListener('change', function () {
                const fileName = input.files[0].name; // Lấy tên file được chọn
                filePathDisplay.textContent = "File selected: " + fileName; // Hiển thị tên file
            });
        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/teacher-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>
