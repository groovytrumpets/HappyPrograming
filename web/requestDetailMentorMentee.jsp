<%-- 
    Document   : requestDetailMentorMentee
    Created on : Oct 24, 2024, 8:54:15 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

        <jsp:include page="headerMentee.jsp" />

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">User</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>User</li>
                        <li>Request Detail</li>

                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box" >
                            <div class="wc-title" style="display: flex">
                                <div class="col-md-4">
                                    <h4>Request Detail</h4>
                                </div>
                            </div>

                            <div class="widget-inner">
                                <div>Course Process: ${request.status}</div><br>
                                <div style="display: flex" class="row">
                                    <div class="col-md-7">
                                        <h6>Mentor</h6>
                                        <table class="table table-hover">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th scope="col">Mentor ID</th>
                                                    <th scope="col">Full name</th>
                                                    <th scope="col">Date of birth</th>                                               
                                                    <th scope="col">Profession</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${mentor.mentorId}</td>
                                                    <td>${mentor.fullName}</td>
                                                    <td>${mentor.dateOfBirth}</td>
                                                    <td>${cv.jobProfession}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col-md-5">
                                        <h6>Mentee</h6>
                                        <table class="table table-hover">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th scope="col">Mentee ID</th>
                                                    <th scope="col">Full name</th>
                                                    <th scope="col">Date of birth</th>                                               
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${mentee.menteeId}</td>
                                                    <td>${mentee.fullName}</td>
                                                    <td>${mentee.dateOfBirth}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="seperator"></div><br>
                                <div class="row">
                                    <div class="col-7">
                                        <div class="ml-auto">
                                            <h6>Skill info</h6>
                                        </div>
                                        <table class="table table-hover">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th scope="col">Skill Name</th>
                                                    <th scope="col">Image</th>
                                                    <th scope="col">Start date</th>
                                                    <th scope="col">End date</th>  
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${skill.skillName}</td>
                                                    <td><img src="data:image/jpeg;base64,${skill.base64ImageFile}" class="img-fluid" style="max-height: 100px; max-width: 100px"></td>
                                                    <td>${request.startDate}</td>
                                                    <td>${request.endDate}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <div class="ml-auto">
                                            <form action="requestdetailmentormentee" method="get">
                                                <input type="hidden" name="requestID" value="${request.requestId}">
                                                <label>Start date:</label>
                                                <input type="date" name="start" value="${requestScope.start}" onchange="this.form.submit()">
                                            </form>
                                            <div class="text-center">
                                                <h3>${formattedDateRange}</h3>
                                            </div>
                                            <div style="border: 1px solid #eaeaea; padding: 1px; background-color: #f9f9f9;">
                                                <table border="1" class="table table-hover text-center" style="border-collapse: separate; width: 100%; table-layout: fixed; border: #ddd">
                                                    <thead style="background-color: #f0f0f0;">
                                                        <tr>
                                                            <th style="border: none; padding: 10px; width: 10%;"></th>
                                                                <c:forEach var="day" items="${daysOfWeek}" varStatus="status">
                                                                <th style="padding: 10px; border-left: 1px solid #ddd; border-right: 1px solid #ddd;">
                                                                    ${fn:substring(day, 0, 3)}
                                                                    ${dateOfDay[day].monthValue}/${dateOfDay[day].dayOfMonth}
                                                                </th>
                                                            </c:forEach>
                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <tr>
                                                            <td style="border: 1px solid #ddd;">
                                                                <label>Slot</label>
                                                            </td>
                                                            <c:forEach var="day" items="${daysOfWeek}">
                                                                <td class="text-left" style="padding-bottom: 50px;
                                                                    <c:if test='${not empty slotsByDay[day]}'>background-color: #62d262;</c:if>
                                                                        border: 1px solid #ddd; border-radius: 3px;">
                                                                    <c:if test="${not empty slotsByDay[day]}">
                                                                        <c:forEach var="slot" items="${slotsByDay[day]}">
                                                                            <div>${slot.startTime} - ${slot.endTime}</div>
                                                                        </c:forEach>
                                                                    </c:if>
                                                                    <c:if test="${not empty slotInWeek[day]}">
                                                                        <c:forEach var="slotStatus" items="${slotInWeek[day]}">
                                                                            <c:choose>
                                                                                <c:when test="${slotStatus.status != null && slotStatus.status eq 'Attended'}">
                                                                                    <div style="display: flex"><p style="color: green">${slotStatus.status}</p></div>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                    <div style="display: flex"><p style="color: red">${slotStatus.status}</p> </div>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:forEach>

                                                                    </c:if>
                                                                </td>
                                                            </c:forEach>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
