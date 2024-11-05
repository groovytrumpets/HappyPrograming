<%-- 
    Document   : AdminMentorList
    Created on : Oct 3, 2024, 5:48:10 PM
    Author     : tuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

        <!-- header start -->
          <jsp:include page="headerAdmin.jsp" />
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">User</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>User</li>
                        <li>Mentor</li>

                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box" >
                            <div class="wc-title" style="display: flex">
                                <div class="col-md-4">
                                    <h4>Mentor List</h4>
                                </div>
                                <div class="mail-search-bar col-md-4">
                                    <form method="get" action="adminSearchMentor" style="display: flex; align-items: center;">
                                        <input type="text" name="search" placeholder="Search" class="form-control" style="flex: 1; margin-right: 10px;">
                                        <button type="submit" class="fa fa-search" style="padding: 10px;">
                                    </form>
                                </div>
                            </div>

                            <div class="widget-inner">
                                <table class="table-bordered">

                                    <tr>
                                        <th>STT</th>
                                        <th>ID</th>
                                        <th>Full Name</th>
                                        <th>Account name</th>
                                        <th>Profession</th>
                                        <th>Current Request</th>
                                        <th>Percentage completed</th>
                                        <th>Rate star</th>
                                        <th>Status</th>
                                    </tr>
                                    <c:set var="stt" value="${requestScope.stt}"/>
                                    <c:forEach items="${requestScope.listMent}" var="c">
                                        <form action="mentorListAdmin" method="post">
                                            <input type="hidden" name="page" value="${requestScope.indexPage}">
                                            <input type="hidden" name="numDis" value="${requestScope.numDis}">
                                            <input type="hidden" name="mentorId" value="${c.mentorId}">
                                            <input type="hidden" name="status" value="${c.status}">
                                            <c:set value="${stt +1}" var="stt"/>
                                            <tr>
                                                <td>${stt}</td>
                                                <td>${c.mentorId}</td>
                                                <td>${c.fullName}</td>
                                                <td>${c.username}</td>
                                                <td>
                                                    <c:forEach items="${requestScope.listCV}" var="cv">
                                                        <c:if test="${cv.mentorId eq c.mentorId}">
                                                            ${cv.jobProfession}
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>
                                                    <c:set var="accepted" value="0" />
                                                    <c:forEach items="${requestScope.requestAccList}" var="requestAcc">
                                                        <c:if test="${c.mentorId eq requestAcc.mentorId}">
                                                            <c:set value="${accepted + 1}" var="accepted" />
                                                        </c:if>
                                                    </c:forEach>
                                                    ${accepted}
                                                </td>
                                                <td>
                                                    <c:set var="complete" value="0" />
                                                    <c:forEach items="${requestScope.requestComList}" var="requestCom">
                                                        <c:if test="${c.mentorId eq requestCom.mentorId}">
                                                            <c:set value="${complete + 1}" var="complete" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:set var="allRequest" value="0" />
                                                    <c:forEach items="${requestScope.requestList}" var="request">
                                                        <c:if test="${c.mentorId eq request.mentorId}">
                                                            <c:set value="${allRequest + 1}" var="allRequest" />
                                                        </c:if>
                                                    </c:forEach>
                                                    <c:choose>
                                                        <c:when test="${allRequest > 0}">
                                                            <fmt:formatNumber value="${(complete * 100) / allRequest}" maxFractionDigits="2" />%
                                                        </c:when>
                                                        <c:otherwise>
                                                            0%
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <c:set var="countRate" value="0" />
                                                    <c:set var="sumRate" value="0"/>
                                                    <c:forEach items="${requestScope.listRate}" var="curRate">
                                                        <c:if test="${c.mentorId eq curRate.mentorId}">
                                                            <c:set value="${countRate + 1}" var="countRate" />
                                                            <c:set value="${sumRate + curRate.rate}" var="sumRate"/>
                                                        </c:if>
                                                    </c:forEach>
                                                     <c:choose>
                                                        <c:when test="${countRate > 0}">
                                                            <fmt:formatNumber value="${sumRate/countRate}" maxFractionDigits="2" /><i class="fa fa-star">
                                                        </c:when>
                                                        <c:otherwise>
                                                            0/5<i class="fa fa-star ">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${c.status eq 'Active'}">
                                                            <div class="btn-secondry add-item m-r5" style="background-color: #00a834">
                                                                <button type="submit" style="text-decoration: none; color: inherit; border: none; background: none; padding: 0; font: inherit; cursor: pointer;" >${c.status}</button>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="btn-secondry add-item m-r5">
                                                                <button type="submit" style="text-decoration: none; color: inherit; border: none; background: none; padding: 0; font: inherit; cursor: pointer;">${c.status}</button>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                </table>
                                <c:set var="page" value="${requestScope.indexPage}"/>
                                <div class="pagination" style="display: flex">
                                    <div class="col-md-6" >
                                        <div class="col-md-4">
                                            <form action="mentorListAdmin" method="get">
                                                <select name="numDis" id="numDis" onchange="this.form.submit()">
                                                    <option value="10" ${numDis == 10 ? 'selected' : ''}>10</option>
                                                    <option value="15" ${numDis == 15 ? 'selected' : ''}>15</option>
                                                    <option value="20" ${numDis == 20 ? 'selected' : ''}>20</option>
                                                </select>
                                                <noscript><input type="submit" value="Submit"></noscript>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="col-md-6" style="text-align: right">
                                        <c:forEach begin="${1}" end="${requestScope.numOfPage}" var="i">
                                            <a href="mentorListAdmin?page=${i}&numDis=${numDis}">${i}</a>
                                        </c:forEach>
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

    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>

