/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Mentor;

import DAO.CVDAO;
import Model.Slot;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SlotViewServlet", urlPatterns = {"/slotview"})
public class SlotViewServlet extends HttpServlet {

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
            out.println("<title>Servlet SlotViewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SlotViewServlet at " + request.getContextPath() + "</h1>");
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
        String mentorId_raw = request.getParameter("id");
        int mentorId;
        try {
            mentorId = Integer.parseInt(mentorId_raw);
            CVDAO cvd = new CVDAO();
            List<String> dateConverted = new ArrayList<>();
            List<Slot> mentorSlot = cvd.getSlotByMentorId(mentorId);
            //System.out.println(mentorSlot.get(0).getDayInWeek());
            for (int i = 0; i < mentorSlot.size(); i++) {
                String date = convertDayInWeekToCurrentDate(mentorSlot.get(i).getDayInWeek())+"T"+mentorSlot.get(i).getStartTime();
                //System.out.println(date+", "+mentorSlot.get(i).getStartTime());
                dateConverted.add(date);
            }

            request.setAttribute("key", new Gson().toJson("Good Doog"));
            request.setAttribute("values", new Gson().toJson(dateConverted));
            request.getRequestDispatcher("slotDemo.jsp").forward(request, response);
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

public static String convertDayInWeekToCurrentDate(String dayInWeek) {
    // Lấy ngày hiện tại
    LocalDate today = LocalDate.now();
    
    // Chuyển đổi chuỗi thành DayOfWeek (ví dụ: "Monday" -> DayOfWeek.MONDAY)
    DayOfWeek dayOfWeek = DayOfWeek.valueOf(dayInWeek.toUpperCase());
    
    // Tìm thứ trong tuần hiện tại
    LocalDate resultDate = today.with(DayOfWeek.MONDAY); // Mặc định là lấy ngày Monday trong tuần hiện tại

    // Nếu thứ bạn muốn không phải là Monday, hãy điều chỉnh lại
    while (resultDate.getDayOfWeek() != dayOfWeek) {
        resultDate = resultDate.plusDays(1);
    }

    // Chuyển đổi LocalDate thành chuỗi
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return resultDate.format(formatter);
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
