/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CVDAO;
import DAO.MenteeDAO;
import DAO.MentorDAO;
import DAO.RateDAO;
import Model.CV;
import Model.Mentee;
import Model.Mentor;
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
@WebServlet(name = "RateMentorSV", urlPatterns = {"/ratementor"})
public class RateMentorSV extends HttpServlet {

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
            out.println("<title>Servlet RateMentorSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RateMentorSV at " + request.getContextPath() + "</h1>");
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
        MenteeDAO actMentee = new MenteeDAO();
        MentorDAO actMentor = new MentorDAO();
        CVDAO cvdao = new CVDAO();
        RateDAO ratedao = new RateDAO();

        if (curUser == null) {
            response.sendRedirect("signin");
            return;
        }
        PrintWriter out = response.getWriter();
        int roleID = curUser.getRoleId();
        Mentee curMentee = new Mentee();
        if (roleID == 2) {
            curMentee = actMentee.findMenteeByUsername(curUser.getUsername());
            request.setAttribute("mentee", curMentee);
        } else if (roleID == 1) {
            Mentor curMentor = actMentor.findMentorByUsername(curUser.getUsername());
            response.sendRedirect("home");
            return;
        }
        String mentorId_raw = request.getParameter("mentorId");
        int mentorId;
        try {
            mentorId = Integer.parseInt(mentorId_raw);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid mentor ID");
            return;
        }

        Mentor mentor = actMentor.getMentorById(mentorId);
        if (mentor == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Mentor not found");
            return;
        }
        

        request.setAttribute("cvmentor", cvdao.getCVbyMentorId(mentorId));
        request.setAttribute("mentor", mentor);
        request.getRequestDispatcher("rateMentor.jsp").forward(request, response);
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
        // Get the session
        HttpSession session = request.getSession();
        User curUser = (User) session.getAttribute("acc");
        MenteeDAO actMentee = new MenteeDAO();
        MentorDAO actMentor = new MentorDAO();
        if (curUser == null) {
            response.sendRedirect("signin");
            return;
        }
        PrintWriter out = response.getWriter();
        int roleID = curUser.getRoleId();
        Mentee curMentee = new Mentee();
        if (roleID == 2) {
            curMentee = actMentee.findMenteeByUsername(curUser.getUsername());
            request.setAttribute("mentee", curMentee);
        } else if (roleID == 1) {
            Mentor curMentor = actMentor.findMentorByUsername(curUser.getUsername());
            response.sendRedirect("home");
            return;
        }

        int menteeId = curMentee.getMenteeId(); // Get the menteeId from the current mentee

        // Retrieve the mentor ID from the request
        int mentorId = Integer.parseInt(request.getParameter("mentorId"));
        int rate = Integer.parseInt(request.getParameter("rating"));
        String comment = request.getParameter("comment");

        // Use RateDAO to save the rating
        RateDAO rateDAO = new RateDAO();
        rateDAO.saveRating(menteeId, mentorId, rate, comment);

        // Redirect back to the mentor profile or success page
        response.sendRedirect("viewprofilecv?id=" + mentorId);
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
