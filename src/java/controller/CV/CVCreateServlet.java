/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.CV;

import DAO.CVDAO;
import Model.CV;
import Model.Mentor;
import Model.Skill;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="CVCreateServlet", urlPatterns={"/cvcreate"})
public class CVCreateServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CVCreateServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CVCreateServlet at " + request.getContextPath () + "</h1>");
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
            List<Skill> skillList = cvd.getSkillList(id);
            request.setAttribute("skillList", skillList);
            Mentor mentor = cvd.getMentorByID(id);
            String email = cvd.getUserEmail(id);
            request.setAttribute("email", email);
            request.setAttribute("uFound", mentor);
            
            
            request.getRequestDispatcher("createCV.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("here");
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
        String[] addSkills = request.getParameterValues("addSkills");
        
        String userId_raw = request.getParameter("mentorId");
        
        String profession = request.getParameter("profession");
        String framework = request.getParameter("framework");
        String education = request.getParameter("education");
        String yearxp_raw = request.getParameter("yearxp");
        String activity = request.getParameter("activity");
        String professionIntroduction = request.getParameter("professionIntroduction");
        String serviceDescription = request.getParameter("serviceDescription");
        String experience = request.getParameter("experience");
        String avatar = request.getParameter("avatar");

        int userid,yearxp;
        try {
            userid=Integer.parseInt(userId_raw);
            yearxp=Integer.parseInt(yearxp_raw);
             CVDAO cvdao = new CVDAO();
              CV newCv = new CV(userid,education, experience, activity, 
                    professionIntroduction, profession, 
                    yearxp, serviceDescription, framework,avatar);
             cvdao.createCV(newCv);
            
             
             //add skills
             if (addSkills!=null) {
                cvdao.insertMentorSkills(userid, addSkills);
                //System.out.println("Add !null");
            }
             response.sendRedirect("cvupdate?id="+userid);
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
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
