<%-- 
    Document   : requestreset
    Created on : Sep 22, 2024, 4:50:26 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Request Password Reset</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
            }
            .container {
                max-width: 400px;
                margin: auto;
                background: white;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }
            h2 {
                text-align: center;
                color: #333;
            }
            label {
                display: block;
                margin: 10px 0 5px;
            }
            input[type="text"],
            input[type="email"] {
                width: 100%;
                padding: 10px;
                margin: 5px 0 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
            }
            .message {
                text-align: center;
                margin-top: 10px;
            }
            .error {
                color: red;
            }
            .success {
                color: green;
            }
            .info {
                text-align: left;
                margin-bottom: 20px;
                color: #555;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Reset Password</h2>
            <p class="info">If you've forgotten your password, enter your account and email</p>
            <form action="passwordreset" method="post">
                <label for="accountName">Account Name:</label>
                <input type="text" id="account" name="account" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <input type="submit" value="Submit">
            </form>

            <!-- Display success or error messages -->
            <div class="message">
                <p class="error">${requestScope.error}</p>
                <p class="success">${requestScope.message}</p>
            </div>
        </div>
    </body>
</html>
