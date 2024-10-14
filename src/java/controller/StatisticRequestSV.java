/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.RequestDAO;
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

/**
 *
 * @author asus
 */
@WebServlet(name = "StatisticRequestSV", urlPatterns = {"/statisticrequest"})
public class StatisticRequestSV extends HttpServlet {

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
            out.println("<title>Servlet StatisticRequestSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatisticRequestSV at " + request.getContextPath() + "</h1>");
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
        try {
            HttpSession session = request.getSession();
            User curUser = (User) session.getAttribute("acc");
//            MenteeDAO actMentee = new MenteeDAO();
//            MentorDAO actMentor = new MentorDAO();
            RequestDAO requestdao = new RequestDAO();
            if (curUser == null) {
                response.sendRedirect("signin");
                return;
            }
            PrintWriter out = response.getWriter();
            int roleID = curUser.getRoleId();
            Mentee curMentee = new Mentee();
            if (roleID == 2) {
                //curMentee = requestdao.getAllRequest();
                //curMentee = actMentee.findMenteeByUsername(curUser.getUsername());
                //request.setAttribute("mentee", curMentee);
            } else if (roleID == 1) {
                //Mentor curMentor = actMentor.findMentorByUsername(curUser.getUsername());
                //request.getRequestDispatcher("cvlist?id=" + curMentor.getMentorId()).forward(request, response);
                return;
            }

            request.getRequestDispatcher("updateProfileMentee.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
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
