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
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class ChangeLoggingPasswordSV extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String username = (String) request.getSession().getAttribute("username");

        if (newPassword.equals(confirmPassword)) {
            try {
                UserDAO userDAO = new UserDAO();
                if (userDAO.validateUser(username, oldPassword)) {
                    if (userDAO.updatePassword(username, newPassword)) {
                        request.setAttribute("message", "Password changed successfully!");
                    } else {
                        request.setAttribute("message", "Password change failed.");
                    }
                } else {
                    request.setAttribute("message", "Invalid old password.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("message", "Database error.");
            }
        } else {
            request.setAttribute("message", "New passwords do not match.");
        }

        request.getRequestDispatcher("changeloggingpassword.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
