<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
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
        <title>Create request</title>

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
                            <a href="review.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-comments"></i></span>
                                <span class="ttr-label">Review</span>
                            </a>
                        </li>
                        <li>
                            <a href="add-listing.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Create request</span>
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
                    <h4 class="breadcrumb-title">Create request to mentor ${mentor.fullName}</h4>

                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <p style="color: red"> ${error}</p>
                                <p style="color: blue"> ${notify}</p>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="createrequest" method="post" id="slotForm">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="ml-auto">
                                                <h3>1. Content</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Title of request</label>
                                            <div>
                                                <input class="form-control" type="text" value="" name="title" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Content of request</label>
                                            <div>
                                                <input class="form-control" type="text" value="" name="content" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Deadline hour</label>
                                            <div>
                                                <input class="form-control" type="time" value="" name="hour" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Deadline date</label>
                                            <div>
                                                <input class="form-control" type="date" value="" name="date" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Start Date</label>
                                            <div>
                                                <input class="form-control" type="date" value="" name="start" id="start" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">End Date</label>
                                            <div>
                                                <input class="form-control" type="date" value="" name="end" id="end" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Framework</label>
                                            <div>
                                                <input class="form-control" type="text" value="" name="framework" required>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <div>
                                                <input class="form-control" type="hidden" value="${mid}" name="id">
                                            </div>
                                        </div>

                                        <div class="col-12 m-t20">
                                            <div class="ml-auto m-b5">
                                                <h3>2. Select skill</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Select Skills</label><br/>
                                            <div>
                                                <ul class="border p-3 rounded mr-3 mb-3 category" style="list-style-type: none; display: flex; flex-wrap: wrap; gap: 10px;">
                                                    <c:forEach items="${skillList}" var="c">
                                                        <li>
                                                            <div class="check-box">
                                                                <label class="col-form-label">
                                                                    <input type="checkbox" class="checkbox" name="addSkills" value="${c.skillId}">
                                                                    ${c.skillName}
                                                                </label>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>

                                        <div class="col-12 m-t20">
                                            <div class="ml-auto">
                                                <h3 class="m-form__section">3. Select slot</h3>
                                            </div>
                                        </div>
                                        <div class="col-12"> 
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Select Slots</label><br/>
                                                <div>
                                                    <table class="table border rounded">
                                                        <thead>
                                                            <tr>
                                                                <th scope="col">Select</th>
                                                                <th scope="col">Day in week</th>
                                                                <th scope="col">Start time</th>
                                                                <th scope="col">End time</th>
                                                                <th scope="col">Status</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${slotList}" var="s">
                                                                <tr>
                                                                    <td>
                                                                        <input type="checkbox" class="checkbox slot-checkbox" name="addSlot" value="${s.slotID}" data-day="${s.dayInWeek}" 
                                                                               <c:if test="${s.status == 'inavaiable'}" >
                                                                                   disabled
                                                                               </c:if>
                                                                               >
                                                                    </td>
                                                                    <td>${s.dayInWeek}</td>
                                                                    <td>${s.startTime}</td>
                                                                    <td>${s.endTime}</td>
                                                                    <td>${s.status}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody> 
                                                    </table>
                                                    <div class="col-12" style="margin-left: -15px">
                                                        <h3>Total Price: $<span id="totalPrice">0</span></h3>
                                                        <input type="hidden" id="totalPriceInput" name="totalPrice" value="">
                                                        <button type="submit" class="btn-secondry add-item m-r5">
                                                            <i class="fa fa-fw fa-plus-circle"></i>Create request
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
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
        <script src='assets/vendors/switcher/switcher.js'></script>

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
        </script>
        <script>
            // Price per selected day (for example purposes, let's assume each selected day costs $10)
            document.addEventListener('DOMContentLoaded', function () {
                // Price per selected day (make sure this variable is set correctly in your backend)
                const pricePerDay = ${cv.price};

                // Function to calculate the price based on selected days and date range
                function calculatePrice() {
                    const startDateInput = document.getElementById('start');
                    const endDateInput = document.getElementById('end');
                    const startDate = new Date(startDateInput.value);
                    const endDate = new Date(endDateInput.value);
                    const selectedDays = Array.from(document.querySelectorAll('.slot-checkbox:checked'))
                            .map(el => el.getAttribute('data-day'));
                    const dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

                    // Validate date inputs
                    if (isNaN(startDate) || isNaN(endDate) || startDate > endDate || selectedDays.length === 0) {
                        document.getElementById('totalPrice').textContent = '0';
                        return;
                    }

                    let totalDays = 0;

                    let currentDate = new Date(startDate);

                    // Count occurrences of selected days within the date range
                    while (currentDate <= endDate) {
                        const dayName = dayNames[currentDate.getDay()];
                        if (selectedDays.includes(dayName)) {
                            totalDays++;
                        }
                        currentDate.setDate(currentDate.getDate() + 1);
                    }
                    // Calculate total price
                    const totalPrice = totalDays * pricePerDay;
                    document.getElementById('totalPrice').textContent = totalPrice;
                    document.getElementById('totalPriceInput').value = totalPrice; // Set hidden input value
                }

                // Event listeners for date inputs
                document.getElementById('start').addEventListener('change', calculatePrice);
                document.getElementById('end').addEventListener('change', calculatePrice);

                // Event listeners for slot checkboxes
                document.querySelectorAll('.slot-checkbox').forEach(checkbox => {
                    checkbox.addEventListener('change', calculatePrice);
                });
            });

        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>