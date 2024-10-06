/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CVDAO;
import DAO.MenteeDAO;
import DAO.MentorDAO;
import DAO.RequestDAO;
import DAO.SlotDAO;
import Model.CV;
import Model.Mentor;
import Model.Request;
import Model.RequestSlotItem;
import Model.Skill;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

        HttpSession sesion = request.getSession();
        User a = new User();
        a = (User) sesion.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("signin");
        }
        PrintWriter out = response.getWriter();
        String id_raw = request.getParameter("id");
        String error = request.getParameter("error");
        String notify = request.getParameter("notify");
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
            request.setAttribute("notify", notify);
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
        RequestDAO requestDAO = new RequestDAO();
        MenteeDAO menteeDAO = new MenteeDAO();
        CVDAO cvDAO = new CVDAO();
        SlotDAO slotDAO = new SlotDAO();

        HttpSession sesion = request.getSession();
        User a = new User();
        a = (User) sesion.getAttribute("acc");
        int menteeid = menteeDAO.findMenteeByUsername(a.getUsername()).getMenteeId();

        String id_raw = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String hour = request.getParameter("hour");
        String date = request.getParameter("date");
        String framework = request.getParameter("framework");
        String[] selectedSkills = request.getParameterValues("addSkills");
        String[] selectedSlot = request.getParameterValues("addSlot");
        try {
            int id = Integer.parseInt(id_raw);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDate selectedDate = LocalDate.parse(date, dateFormatter);
            LocalTime selectedTime = LocalTime.parse(hour, timeFormatter);

            LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate, selectedTime);

            LocalDateTime now = LocalDateTime.now();
            LocalDate creaDate = LocalDate.now();

            if (selectedDateTime.isBefore(now)) {
                response.sendRedirect("createrequest?id=" + id + "&error=Deadline date or deadline not avaiable");
                return;
            }

            if (selectedSkills == null || selectedSkills.length > 3) {
                response.sendRedirect("createrequest?id=" + id + "&error=You must select 1 skill and max is 3");
                return;
            }

            if (selectedSlot == null) {
                response.sendRedirect("createrequest?id=" + id + "&error=You must select at least 1 slot");
                return;
            }

            List<RequestSlotItem> listSlot = requestDAO.getDuplicateSlot(menteeid);
            if (listSlot != null) {
                for (int i = 0; i < listSlot.size(); i++) {
                    for (String slot : selectedSlot) {
                        int slotid = Integer.parseInt(slot);
                        if (slotid == listSlot.get(i).getSlotId()) {
                            response.sendRedirect("createrequest?id=" + id + "&error=You must choose slot that you haven't been study");
                            return;
                        }
                    }
                }

            }

            CV cv = cvDAO.getCVbyMentorId(id);

            Request newRequest = new Request(0, id, menteeid, cv.getPrice() * selectedSlot.length,
                    "Nothing", creaDate, "Open", title,
                    selectedTime, selectedDate, framework);
            out.print(newRequest);
            /*requestDAO.insertRequest(newRequest);
            requestDAO.addItemByRequestID(selectedSkills, selectedSlot);
            response.sendRedirect("createrequest?id=" + id + "&notify=Create request succesfully");*/

        } catch (Exception e) {
            response.sendRedirect("createrequest?id=" + id_raw + "&error=An error occured during create request");
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
