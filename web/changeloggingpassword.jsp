<%-- 
    Document   : changeloggingpassword
    Created on : Sep 22, 2024, 4:56:16 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Password</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: 'Roboto', sans-serif;
                background-color: #f4f4f9;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            h2 {
                color: #333;
                text-align: center;
                font-size: 24px;
            }

            form {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                width: 100%;
            }

            label {
                font-size: 14px;
                color: #555;
                margin-bottom: 8px;
                display: block;
            }

            input[type="password"] {
                width: 95%;
                padding: 10px;
                margin: 10px 0 20px 0;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 16px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                width: 100%;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            .message {
                margin-top: 10px;
                color: #d9534f;
                text-align: center;
            }
        </style>
    </head>
    <body>

        <form action="changeloggingpassword" method="post">
            <h2>Change Your Password</h2>

            <label for="oldPassword">Old Password</label>
            <input type="password" id="oldPassword" name="oldPassword" required/>

            <label for="newPassword">New Password</label>
            <input type="password" id="newPassword" name="newPassword" required/>

            <label for="confirmPassword">Confirm New Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required/>

            <input type="submit" value="Change Password"/>

            <p class="message"><%= request.getAttribute("message") %></p>
        </form>

    </body>
</html>
