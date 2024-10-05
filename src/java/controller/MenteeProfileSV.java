/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.MenteeDAO;
import Model.Mentee;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
@WebServlet(name = "MenteeProfileSV", urlPatterns = {"/menteeprofile"})
public class MenteeProfileSV extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MenteeProfileSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MenteeProfileSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get existing session, do not create new one
        if (session != null) {
            User user = (User) session.getAttribute("acc"); // Retrieve the user object
            if (user != null) {
                String username = user.getUsername(); // Assuming you have a getUsername() method in User class

                // Create an instance of MenteeDAO to call the non-static method
                MenteeDAO menteeDAO = new MenteeDAO();
                Mentee mentee = menteeDAO.getMenteeByUsername(username); // Fetch Mentee by username
                session.setAttribute("mentee", mentee);

                if (mentee != null) {
                    request.setAttribute("mentee", mentee); // Set Mentee object in request
                    request.getRequestDispatcher("menteeProfile.jsp").forward(request, response); // Forward to JSP
                } else {
                    request.setAttribute("error", "Mentee not found.");
                    request.getRequestDispatcher("SignIn.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "No user is logged in. Please log in first.");
                request.getRequestDispatcher("SignIn.jsp").forward(request, response);

            }
        } else {
            request.setAttribute("error", "No user is logged in. Please log in first.");
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
