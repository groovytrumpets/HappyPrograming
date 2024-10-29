<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Payment</title>
        <!-- Bootstrap core CSS -->
        <link href="/vnpay_jsp/assets/bootstrap.min.css" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="/vnpay_jsp/assets/jumbotron-narrow.css" rel="stylesheet">
        <script src="/vnpay_jsp/assets/jquery-1.11.3.min.js"></script>
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
        <style>
            .important-balance {
                font-size: 1.0em;             /* Increase the font size for prominence */
                font-weight: bold;            /* Bold text */
                color: #2c3e50;              /* Darker, more sophisticated text color */
                background-color: #ecf0f1;   /* Light background for contrast */
                padding: 15px;                /* More padding for a comfortable feel */
                border: 2px solid #3498db;   /* Bright blue border for emphasis */
                border-radius: 10px;         /* Rounded corners */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
                text-align: center;           /* Centered text */
                margin-top: 10px;            /* Space above the display */
            }

            .important-balance label {
                font-size: 1.2em;             /* Slightly larger label */
                color: #34495e;               /* Darker color for the label */
                display: block;               /* Make label a block element */
                margin-bottom: 8px;           /* Space below the label */
            }
        </style>

    </head>

    <body>
        <header class="header rs-nav">
            <jsp:include page="header.jsp" />
        </header>
        <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner3.jpg);">
            <div class="container">
                <div class="page-banner-entry">
                    <h1 class="text-white">Payment</h1>
                </div>
            </div>
        </div>

        <div class="container" style="margin-top: 100px">
            <div class="header clearfix"></div>

            <div class="row">
                <!-- User Details Column -->
                <div class="col-md-6">
                    <div class="col-lg-7 col-md-7">
                        <form class="contact-bx ajax-form">
                            <div class="ajax-message"></div>
                            <div class="heading-bx left">
                                <h2 class="title-head">Wallet<span> Detail</span></h2>
                            </div>
                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label>Your Username</label>
                                        <input  class="form-control valid-character" value="${sessionScope.acc.username}" disabled/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label for="holdDisplay">Hold</label>
                                        <div id="holdDisplay" class="important-balance" disabled>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label for="walletDisplay">Balance</label>
                                        <div id="walletDisplay" class="important-balance" disabled>
                                        </div>
                                    </div>
                                </div>






                            </div>
                        </form>
                    </div>
                </div>


                <!-- Charge Money Column -->
                <div class="col-md-6">
                    <h3 >Charge Money</h3>
                    <p style="color: red">${error}</p>
                    <div class="table-responsive">
                        <form action="vnpayajax" id="frmCreateOrder" method="post">
                            <div class="form-group">
                                <label for="amount">Amount</label>
                                <input 
                                    class="form-control" 
                                    data-val="true" 
                                    data-val-number="The field Amount must be a number." 
                                    data-val-required="The Amount field is required." 
                                    id="amount"  
                                    name="amount" 
                                    type="number" 
                                    required 
                                    />
                            </div>

                            <h4>Pay through VNPAY</h4>
                            <img src="https://vnpay.vn/s1/statics.vnpay.vn/2023/6/0oxhzjmxbksr1686814746087.png" width="100px" height="100px" alt="vnpay">

                            <div class="form-group" hidden>
                                <h5>Cách 1: Chuyển hướng sang Cổng VNPAY chọn phương thức thanh toán</h5>
                                <input type="radio" id="bankCode" name="bankCode" value="VNP">
                                <label for="bankCode">Cổng thanh toán VNPAYQR</label><br>

                                <h5>Cách 2: Tách phương thức tại site của đơn vị kết nối</h5>
                                <input type="radio" id="bankCode" name="bankCode" value="VNPAYQR">
                                <label for="bankCode">Thanh toán bằng ứng dụng hỗ trợ VNPAYQR</label><br>

                                <input type="radio" id="bankCode" name="bankCode" value="VNBANK">
                                <label for="bankCode">Thanh toán qua thẻ ATM/Tài khoản nội địa</label><br>

                                <input type="radio" id="bankCode" name="bankCode" value="INTCARD">
                                <label for="bankCode">Thanh toán qua thẻ quốc tế</label><br>
                            </div>

                            <div class="form-group" hidden>
                                <h5>Chọn ngôn ngữ giao diện thanh toán:</h5>
                                <input type="radio" id="language" name="language" value="vn">
                                <label for="language">Tiếng Việt</label><br>

                                <input type="radio" id="language" name="language" value="en">
                                <label for="language">Tiếng Anh</label><br>
                            </div>

                            <button type="submit" class="btn btn-default">Pay</button>
                        </form>
                    </div>
                </div>
            </div>

            <p>&nbsp;</p>

            <div class="container mt-5">
                <div class="row">
                    <div class="col-12 mb-4">
                        <div class="card shadow-sm">
                            <div class="card-header bg-primary text-white text-center">
                                <h5 class="mb-0">Payment History</h5>
                            </div>
                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table table-striped mb-0">
                                        <thead class="table-light text-uppercase small">
                                            <tr>
                                                <th class="sortable" data-column-index="0">Payment ID</th>
                                                <th class="sortable" data-column-index="1">Payment Date</th>
                                                <th class="sortable" data-column-index="2">Payment Type</th>
                                                <th class="sortable" data-column-index="3">Amount</th>
                                            </tr>
                                        </thead>
                                        <tbody id="paymentTableBody">
                                            <c:forEach var="payments" items="${list}">
                                                <tr>
                                                    <td>${payments.paymentId}</td>
                                                    <td >${payments.paymentDate}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${payments.receiver == 'admin'}">Charging Money</c:when>
                                                            <c:otherwise>Paying for Mentor</c:otherwise>
                                                        </c:choose>

                                                    </td>
                                                    <td>
                                                        <div class="d-flex align-items-center">
                                                            <c:choose>
                                                                <c:when test="${payments.receiver == 'admin'}">
                                                                    <span class="text-success"><i class="ti-arrow-up"></i></span>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                    <span class="text-danger"><i class="ti-arrow-down"></i></span>
                                                                    </c:otherwise>
                                                                </c:choose>

                                                            <span class="ms-2">${payments.totalAmount}</span>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                  
                                </div>
                            </div>
                            <div class="card-footer d-flex justify-content-center">
                                <nav>
                                    <ul class="pagination mb-0">
                                        <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                                            <a class="page-link" href="payment?page=${currentPage - 1}">Previous</a>
                                        </li>
                                        <c:forEach begin="1" end="${totalPages}" var="i">
                                            <li class="page-item ${currentPage == i ? 'active' : ''}">
                                                <a class="page-link" href="payment?page=${i}">${i}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                                            <a class="page-link" href="payment?page=${currentPage + 1}">Next</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <jsp:include page="footer.jsp" />
        <script type="text/javascript">
                                        $("#frmCreateOrder").submit(function () {
                                            var postData = $("#frmCreateOrder").serialize();
                                            var submitUrl = $("#frmCreateOrder").attr("action");
                                            $.ajax({
                                                type: "POST",
                                                url: submitUrl,
                                                data: postData,
                                                dataType: 'JSON',
                                                success: function (x) {
                                                    if (x.code === '00') {
                                                        if (window.vnpay) {
                                                            vnpay.open({width: 768, height: 600, url: x.data});
                                                        } else {
                                                            location.href = x.data;
                                                        }
                                                        return false;
                                                    } else {
                                                        alert(x.Message);
                                                    }
                                                }
                                            });
                                            return false;
                                        });
        </script>
        <script>
            // JavaScript to format numbers as VND
            const hold = ${wallet.hold}; // Example: Replace with `cv.price` value
            const balance = ${wallet.balance}; // Example: Replace with `wallet.balance` value

            // Function to format as VND with commas
            function formatVND(value) {
                return new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(value);
            }

            // Update the spans with formatted values
            document.getElementById('walletDisplay').textContent = formatVND(balance);
            document.getElementById('holdDisplay').textContent = formatVND(hold);

        </script>

    </body>
</html>
