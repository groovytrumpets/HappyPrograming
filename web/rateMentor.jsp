<%-- 
    Document   : rateMentor
    Created on : Oct 6, 2024, 8:01:59 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.Mentor" %>
<%@ page import="DAO.MentorDAO" %>
<%
    int mentorId = Integer.parseInt(request.getParameter("mentorId"));
    MentorDAO mentorDAO = new MentorDAO();
    Mentor mentor = mentorDAO.getMentorById(mentorId); // Assuming you have this method

    // Retrieve menteeId from request attribute
    int menteeId = (int) request.getAttribute("menteeId");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Rate Mentor</title>
        <style>
            .star-rating {
                direction: rtl;
                display: inline-block;
                font-size: 20px;
            }
            .star-rating input[type="radio"] {
                display: none;
            }
            .star-rating label {
                color: #ddd;
                font-size: 30px;
            }
            .star-rating input:checked ~ label {
                color: #f5b301;
            }
            .star-rating label:hover,
            .star-rating label:hover ~ label {
                color: #f5b301;
            }
        </style>
    </head>
    <body>
        <h1>Rate Mentor: <%= mentor.getFullName() %></h1>

        <p><strong>Mentee ID:</strong> <%= menteeId %></p>
        <p><strong>Mentor ID:</strong> <%= mentorId %></p>

        <form action="ratementor" method="POST">
            <input type="hidden" name="menteeId" value="<%= menteeId %>" />
            <input type="hidden" name="mentorId" value="<%= mentorId %>" />

            <!-- Rating Section -->
            <h3>Rate:</h3>
            <div class="star-rating">
                <input type="radio" id="5-stars" name="rating" value="5"><label for="5-stars">★</label>
                <input type="radio" id="4-stars" name="rating" value="4"><label for="4-stars">★</label>
                <input type="radio" id="3-stars" name="rating" value="3"><label for="3-stars">★</label>
                <input type="radio" id="2-stars" name="rating" value="2"><label for="2-stars">★</label>
                <input type="radio" id="1-star" name="rating" value="1"><label for="1-star">★</label>
            </div>

            <!-- Comment Section -->
            <h3>Comment:</h3>
            <textarea name="comment" rows="4" cols="50" placeholder="Leave your comment here..."></textarea><br>

            <input type="submit" value="Submit Rating">
        </form>

    </body>
</html>
