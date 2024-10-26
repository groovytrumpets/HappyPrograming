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
                                <h2 class="title-head">User<span> Detail</span></h2>
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
                                        <label>Your Email Address</label>
                                        <input class="form-control" value="${sessionScope.acc.email}" disabled=""/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label>Your Phone</label>
                                        <input class="form-control int-value" value="${mentee.phone}" disabled/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label for="walletDisplay">Balance</label>
                                        <div id="walletDisplay" class="important-balance" disabled>
                                          
                                        </div>
                                    </div>
                                </div>


                                <script>
                                    // Assuming wallet is a number
                                    let wallet = ${wallet}; // Example wallet amount
                                    document.getElementById("walletDisplay").innerText = wallet.toLocaleString('vi-VN', {
                                        style: 'currency',
                                        currency: 'VND'
                                    });
                                </script>


                            </div>
                        </form>
                    </div>
                </div>


                <!-- Charge Money Column -->
                <div class="col-md-6">
                    <h3>Charge Money</h3>
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
    </body>
</html>
