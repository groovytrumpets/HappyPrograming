/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CVDAO;
import DAO.MenteeDAO;
import DAO.MentorDAO;
import DAO.RequestDAO;
import DAO.SkillDAO;
import DAO.SlotDAO;
import Model.CV;
import Model.Mentee;
import Model.Mentor;
import Model.Request;
import Model.Skill;
import Model.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
@WebServlet(name = "RequestDetailMentorMenteeSV", urlPatterns = {"/requestdetailmentormentee"})
public class RequestDetailMentorMenteeSV extends HttpServlet {

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
            out.println("<title>Servlet RequestDetailMentorMenteeSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequestDetailMentorMenteeSV at " + request.getContextPath() + "</h1>");
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
        RequestDAO actRequest = new RequestDAO();
        MentorDAO actMentor = new MentorDAO();
        MenteeDAO actMentee = new MenteeDAO();
        SkillDAO actSkill = new SkillDAO();
        CVDAO actCV = new CVDAO();
        SlotDAO actSlot = new SlotDAO();
        PrintWriter out = response.getWriter();
        String requestId_raw = request.getParameter("requestID");
        int requestId;
        try {
            requestId = Integer.parseInt(requestId_raw);
        } catch (NumberFormatException e) {
            response.sendRedirect("home");
            return;
        }
        Request curRequest = actRequest.getRequestByID(requestId);
        request.setAttribute("request", curRequest);
        Mentor curMentor = actMentor.getMentorById(curRequest.getMentorId());
        request.setAttribute("mentor", curMentor);
        Mentee curMentee = actMentee.getMenteeByID(curRequest.getMenteeId());
        request.setAttribute("mentee", curMentee);
        Skill curSkill = actSkill.getSkillByID(curRequest.getSkillId());
        request.setAttribute("skill", curSkill);
        CV curCV = actCV.getCVbyMentorId(curMentor.getMentorId());
        request.setAttribute("cv", curCV);
        String date_raw = request.getParameter("start");
        LocalDate date = curRequest.getCreateDate();
        if (date_raw != null && !date_raw.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {

                date = LocalDate.parse(date_raw, formatter);
            } catch (DateTimeParseException ex) {
                ex.printStackTrace();
            }
        }

        // Add 7 days to the date
        LocalDate newDate = date.plusDays(7);
        request.setAttribute("start", date);
        String dayInWeek = date.getDayOfWeek().toString();
        List<Slot> listSlot = actSlot.getSlotInDate(newDate, date, requestId);
        Map<String, List<Slot>> slotsByDay = getSlotInDayOfWeek(listSlot, dayInWeek);
        request.setAttribute("slotsByDay", slotsByDay);
        List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        request.setAttribute("daysOfWeek", daysOfWeek);
        Map<String, LocalDate> dateOfStartDay = new LinkedHashMap<>();
        for (int i = 0; i < daysOfWeek.size(); i++) {
            if (daysOfWeek.get(i).equalsIgnoreCase(dayInWeek)) {
                dateOfStartDay.put(daysOfWeek.get(i), date);
            }
        }
        request.setAttribute("dateStartDay", dateOfStartDay);

        //Get list of slot by request and and start date
        request.getRequestDispatcher("requestDetailMentorMentee.jsp").forward(request, response);
    }

    public Map<String, List<Slot>> getSlotInDayOfWeek(List<Slot> slots, String dayInweek) {
        Map<String, List<Slot>> slotsByDay = new LinkedHashMap<>();
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Find the index of the specified day
        int indexDay = -1; // Default to -1 to signify not found
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equalsIgnoreCase(dayInweek)) {
                indexDay = i;
                break;
            }
        }

        // If the day is found, populate the map with days from that index to Sunday
        if (indexDay != -1) {
            // Initialize lists for each day of the week
            for (String day : daysOfWeek) {
                slotsByDay.put(day, new ArrayList<>());
            }

            // Populate slots from the specified day to Sunday
            for (int i = indexDay; i < daysOfWeek.length; i++) {
                for (Slot slot : slots) {
                    if (slot.getDayInWeek().equalsIgnoreCase(daysOfWeek[i])) {
                        slotsByDay.get(daysOfWeek[i]).add(slot);
                    }
                }
            }
        }

        return slotsByDay;
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
