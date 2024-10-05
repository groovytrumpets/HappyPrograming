/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.CV;

import DAO.CVDAO;
import Model.CV;
import Model.Mentor;
import Model.Rate;
import Model.Skill;
import Model.StatisticSkills;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="ViewProfileCVServlet", urlPatterns={"/viewprofilecv"})
public class ViewProfileCVServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ViewProfileCVServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewProfileCVServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        String error = request.getParameter("error");
        
        
        int id;
        CVDAO cvd = new CVDAO();
        try {
            id = Integer.parseInt(id_raw);
            Mentor mentor = cvd.getMentorByID(id);
            CV cv = cvd.getCVbyMentorId(mentor.getMentorId());
            String email = cvd.getUserEmail(id);
            List<Rate> rateList = cvd.getMentorRateList(id);
            List<StatisticSkills> mentorSkillList = cvd.getMentorSkillList(id);
            int rateAve = cvd.getAveRatebyId(id);
            request.setAttribute("skillMentor", mentorSkillList);
            
            
            
            request.setAttribute("error", error);
            request.setAttribute("email", email);
            request.setAttribute("uFound", mentor);
            request.setAttribute("cvFound", cv);
            request.setAttribute("rate", rateList);
            
            request.setAttribute("rateAve", rateAve);
            
            
            request.getRequestDispatcher("viewProfile-CV.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
