/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class PasswordChangeSV extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String email = request.getParameter("email");
        long expiryTime = (long) request.getSession().getAttribute("expiryTime");

        // Check if the token is valid and not expired
        if (token != null && System.currentTimeMillis() < expiryTime) {
            request.setAttribute("token", token);
            request.setAttribute("email", email); // Pass email to the JSP
            request.getRequestDispatcher("changepassword.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Invalid or expired token.");
            request.setAttribute("messageType", "error");
            request.getRequestDispatcher("requestreset.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String message;
        String messageType;

        if (newPassword.equals(confirmPassword)) {
            // Implement password update logic
            String email = (String) request.getSession().getAttribute("userEmail"); // Store userEmail when sending the reset email
            if (userDAO.updateUserPassword(email, newPassword)) {
                message = "Password successfully updated.";
                messageType = "success";
            } else {
                message = "Failed to update password. Please try again.";
                messageType = "error";
            }
        } else {
            message = "Passwords do not match.";
            messageType = "error";
        }

        request.setAttribute("message", message);
        request.setAttribute("messageType", messageType);
        request.getRequestDispatcher("changepassword.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
