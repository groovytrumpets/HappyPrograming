/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CVDAO;
import DAO.MentorDAO;
import DAO.RequestDAO;
import DAO.SlotDAO;
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
import java.util.List;

/**
 *
 * @author nhhag
 */
@WebServlet(name = "UpdateRequestSV", urlPatterns = {"/updateRequest"})
public class UpdateRequestSV extends HttpServlet {

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
            out.println("<title>Servlet UpdateRequestSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRequestSV at " + request.getContextPath() + "</h1>");
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
        CVDAO cvd = new CVDAO();
        SlotDAO slotDAO = new SlotDAO();
        MentorDAO mentorDAO = new MentorDAO();
        RequestDAO requestDAO = new RequestDAO();

        /*a = (User) sesion.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("signin");
        }*/
        PrintWriter out = response.getWriter();
        String id_raw = request.getParameter("id");
        String error = request.getParameter("error");
        String notify = request.getParameter("notify");
        int id;

        try {
            id = Integer.parseInt(id_raw);
            Request requests = requestDAO.getRequestByID(id);
            List<Skill> list1 = cvd.getMentorSkillListByMentorID(requests.getMentorId());
            List<Slot> slotList = slotDAO.getSlotsByMentorId(requests.getMentorId());
            List<RequestSlotItem> checkedSlot = requestDAO.getSlotByRequestID(id);
            request.setAttribute("cv", cvd.getCVbyMentorId(requests.getMentorId()));
            request.setAttribute("mid", id);
            request.setAttribute("request", requests);
            request.setAttribute("skillList", list1);
            request.setAttribute("error", error);
            request.setAttribute("notify", notify);
            request.setAttribute("slotList", slotList);
            request.setAttribute("checkedSlot", checkedSlot);
            request.setAttribute("mentor", mentorDAO.findMentorByID(requests.getMentorId()));
            request.getRequestDispatcher("updateRequest.jsp").forward(request, response);
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
