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
import jakarta.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;
import util.Email;

/**
 *
 * @author asus
 */
public class PasswordResetSV extends HttpServlet {

    private UserDAO userDAO; // Assume you set this up in your servlet's init method

    @Override
    public void init() throws ServletException {
        // Initialize UserDAO
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String message;
        String messageType;

        String userEmail = userDAO.getUserEmailByEmail(email);

        if (userEmail != null) {
            String token = generateToken(); // Implement token generation
            long expiryTime = System.currentTimeMillis() + (15 * 60 * 1000); // 15 minutes
            HttpSession session = request.getSession();
            session.setAttribute("resetToken", token);
            session.setAttribute("expiryTime", expiryTime);
            session.setAttribute("userEmail", email); // Store user email

            // Construct the reset link
            String resetLink = "http://localhost:8080/happy_programming/passwordchange?token=" + token + "&email=" + email;
            boolean emailSent = Email.sendEmail(email, "Password Reset", "Click the link to reset your password: " + resetLink);

            if (emailSent) {
                message = "A password reset link has been sent to your email.";
                messageType = "success";
            } else {
                message = "Failed to send email. Please try again.";
                messageType = "error";
            }
        } else {
            message = "Email not registered. Please check and try again.";
            messageType = "error";
        }

        request.setAttribute("message", message);
        request.setAttribute("messageType", messageType);
        request.getRequestDispatcher("requestreset.jsp").forward(request, response);
    }

    private String generateToken() {
        // Create a secure random number generator
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[24]; // 24 bytes for a 192-bit token
        secureRandom.nextBytes(tokenBytes);

        // Encode the byte array to a Base64 string
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
