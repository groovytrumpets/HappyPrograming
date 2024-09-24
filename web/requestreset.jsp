<%-- 
    Document   : requestreset
    Created on : Sep 22, 2024, 4:50:26 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Password Reset</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            h2 {
                color: #333;
            }
            .container {
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                width: 300px;
                text-align: center;
            }
            input[type="email"] {
                width: 90%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            button {
                background-color: #28a745;
                color: white;
                border: none;
                padding: 10px;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }
            button:hover {
                background-color: #218838;
            }
            .message {
                color: red;
            }
            .success {
                color: green;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Request Password Reset</h2>
            <form action="passwordreset" method="post">
                <input type="email" name="email" placeholder="Enter your registered email" required />
                <button type="submit">Request Reset</button>
            </form>

            <%
                String message = (String) request.getAttribute("message");
                if (message != null) {
                    String messageType = (String) request.getAttribute("messageType");
                    String messageClass = messageType != null && messageType.equals("success") ? "success" : "message";
            %>
            <p class="<%= messageClass %>"><%= message %></p>
            <%
                }
            %>
        </div>
    </body>
</html>
