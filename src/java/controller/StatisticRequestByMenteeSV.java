/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.MenteeDAO;
import DAO.RequestDAO;
import Model.Mentee;
import Model.StatisticRequests;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author asus
 */
@WebServlet(name = "StatisticRequestByMenteeSV", urlPatterns = {"/statisticrequestbymentee"})
public class StatisticRequestByMenteeSV extends HttpServlet {

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
            out.println("<title>Servlet StatisticRequestByMenteeSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatisticRequestByMenteeSV at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User curUser = (User) session.getAttribute("acc");
        if (curUser == null) {
            response.sendRedirect("signin");
            return;
        }

        MenteeDAO menteeDAO = new MenteeDAO();
        RequestDAO requestDAO = new RequestDAO();
        int roleID = curUser.getRoleId();

        if (roleID == 2) {  // Only allow mentees
            Mentee curMentee = menteeDAO.findMenteeByUsername(curUser.getUsername());
            int menteeId = curMentee.getMenteeId();
            
            List<StatisticRequests> statistics = requestDAO.getRequestStatistics(menteeId);
            request.setAttribute("statistics", statistics);
            request.getRequestDispatcher("statisticRequestByMentee.jsp").forward(request, response);
        } else {
            response.sendRedirect("Home.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
