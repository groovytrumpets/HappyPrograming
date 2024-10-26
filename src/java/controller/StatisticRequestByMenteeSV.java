/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.MenteeDAO;
import DAO.RequestDAO;
import DAO.SlotDAO;
import Model.Mentee;
import Model.Request;
import Model.RequestSlotData;
import Model.Slot;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

        // Check if the user is a Mentee (roleID 2)
        if (curUser.getRoleId() == 2) {
            Mentee curMentee = menteeDAO.findMenteeByUsername(curUser.getUsername());
            int menteeId = curMentee.getMenteeId();

            // Get all requests for this mentee
            List<Request> listRequests = requestDAO.getRequestByMenteeID(menteeId);

            // Initialize list to store hours for each request
            List<Float> hoursPerRequestList = new ArrayList<>();

            // Calculate total hours for all requests and each individual request
            float totalHours = 0;
            for (Request req : listRequests) {
                float hoursForRequest = getTotalHourOfRequest(req); // Calculate hours for each request
                hoursPerRequestList.add(hoursForRequest);  // Add to list
                totalHours += hoursForRequest;  // Accumulate total hours
            }

            // Round the total hours to 2 decimal places
            totalHours = (float) Math.round(totalHours * 100) / 100;

            // Set attributes for JSP
            request.setAttribute("totalHours", totalHours);
            request.setAttribute("listRequests", listRequests);
            request.setAttribute("hoursPerRequestList", hoursPerRequestList); // Set hours for each request

            // Forward to JSP page for displaying the statistics
            request.getRequestDispatcher("statisticRequestByMentee.jsp").forward(request, response);
        } else {
            response.sendRedirect("home");
        }
    }

    //calculate total hours of a request
    public float getTotalHourOfRequest(Request request) {
        SlotDAO slotDAO = new SlotDAO();
        List<Slot> listSlots = slotDAO.getSlotByRequestId(request.getRequestId());
        float totalHours = 0;
        LocalDate startDate = request.getStartDate();
        LocalDate endDate = request.getEndDate();

        // Loop over all days between startDate and endDate
        while (!startDate.isAfter(endDate)) {
            String currentDayOfWeek = startDate.getDayOfWeek().toString();

            for (Slot slot : listSlots) {
                if (slot.getDayInWeek().equalsIgnoreCase(currentDayOfWeek)) {
                    LocalTime startTime = slot.getStartTime();
                    LocalTime endTime = slot.getEndTime();
                    float durationInHours = Duration.between(startTime, endTime).toMinutes() / 60.0f;
                    totalHours += durationInHours;
                }
            }

            startDate = startDate.plusDays(1);  // Move to the next day
        }

        return totalHours;
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
