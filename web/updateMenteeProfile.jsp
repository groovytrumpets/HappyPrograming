<%-- 
    Document   : updateMenteeProfile
    Created on : Oct 3, 2024, 2:31:03 PM
    Author     : asus
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Update Profile</title>
    </head>
    <body>
        <h1>Edit Mentee Profile</h1>

        <c:if test="${not empty error}">
            <div style="color: red;">${error}</div>
        </c:if>

            <c:out value="${requestScope.mentee.menteeId}"/>  <!-- This will display the menteeId on the page -->
        <h2>Mentee ID: ${requestScope.mentee.menteeId}</h2> <!-- This should show the mentee ID -->



        <form action="updatementeeprofile" method="post" enctype="multipart/form-data">
            <input type="hidden" name="menteeId" value="${requestScope.mentee.menteeId}"/>

            <label for="username">Username:</label>
            <input type="text" name="username" value="${requestScope.mentee.username}" required/><br/>

            <label for="fullName">Full Name:</label>
            <input type="text" name="fullName" value="${requestScope.mentee.fullName}" required/><br/>

            <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" name="dateOfBirth" value="${requestScope.mentee.dateOfBirth}" required/><br/>


            <label for="gender">Gender:</label>
            <select name="gender" required>
                <option value="Male" <c:if test="${requestScope.mentee.gender == 'Male'}">selected</c:if>>Male</option>
                <option value="Female" <c:if test="${requestScope.mentee.gender == 'Female'}">selected</c:if>>Female</option>
                <option value="Other" <c:if test="${requestScope.mentee.gender == 'Other'}">selected</c:if>>Other</option>
                </select><br/>

                <label for="address">Address:</label>
                <input type="text" name="address" value="${requestScope.mentee.address}" required/><br/>

            <label for="email">Email:</label>
            <input type="email" name="email" value="${requestScope.mentee.email}" readonly/><br/>

            <label for="avatar">Upload Avatar:</label>
            <input type="file" name="avatar" accept="image/*"/><br/>

            <button type="submit">Update Profile</button>
        </form>

        <a href="menteeprofile">Back to Profile</a>
    </body>
</html>

