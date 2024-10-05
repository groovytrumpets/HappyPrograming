/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CVDAO;
import DAO.MentorDAO;
import DAO.SlotDAO;
import Model.Mentor;
import Model.Skill;
import Model.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author nhhag
 */
@WebServlet(name = "CreateRequestSV", urlPatterns = {"/createrequest"})
public class CreateRequestSV extends HttpServlet {

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
            out.println("<title>Servlet CreateRequestSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateRequestSV at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String id_raw = request.getParameter("id");
        String error = request.getParameter("error");
        int id;
        CVDAO cvd = new CVDAO();
        SlotDAO slotDAO = new SlotDAO();
        MentorDAO mentorDAO = new MentorDAO();
        try {
            id = Integer.parseInt(id_raw);
            List<Skill> skillList = cvd.getMentorSkillListByMentorID(id);
            List<Slot> slotList = slotDAO.getSlotsByMentorId(id);
            request.setAttribute("mid", id);
            request.setAttribute("mentor", cvd.getCVbyMentorId(id));
            request.setAttribute("skillList", skillList);
            request.setAttribute("error", error);
            request.setAttribute("slotList", slotList);
            request.getRequestDispatcher("createRequest.jsp").forward(request, response);
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

        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String hour = request.getParameter("hour");
        String date = request.getParameter("date");
        String framework = request.getParameter("framework");
        String[] selectedSkills = request.getParameterValues("addSkills");
        String[] selectedSlot = request.getParameterValues("addSlot");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate selectedDate = LocalDate.parse(date, dateFormatter);
        LocalTime selectedTime = LocalTime.parse(hour, timeFormatter);

        LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate, selectedTime);

        LocalDateTime now = LocalDateTime.now();

        if (selectedDateTime.isAfter(now)) {
            java.sql.Date dates = java.sql.Date.valueOf(selectedDate);
            java.sql.Time hours = java.sql.Time.valueOf(selectedTime);
        } else {
            response.sendRedirect("createrequest?id=" + id + "&error=Deadline date or deadline not avaiable");
        }

        if (selectedSkills.length == 0 || selectedSkills.length > 3) {
            response.sendRedirect("createrequest?id=" + id + "&error=You must select 1 skill and max is 3");
        }
        
        if (selectedSlot.length == 0){
            response.sendRedirect("createrequest?id=" + id + "&error=You must select at least 1 slot");
        }
            
        
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
