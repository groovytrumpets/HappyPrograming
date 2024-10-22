/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.MenteeDAO;
import DAO.MentorDAO;
import DAO.RequestDAO;
import DAO.SlotDAO;
import Model.Request;
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
@WebServlet(name = "UpdateStatusByMentorSV", urlPatterns = {"/updatestatusbymentor"})
public class UpdateStatusByMentorSV extends HttpServlet {

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
            out.println("<title>Servlet UpdateStatusByMentorSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStatusByMentorSV at " + request.getContextPath() + "</h1>");
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

        int roleID = curUser.getRoleId();
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        RequestDAO requestDAO = new RequestDAO();
        SlotDAO slotDAO = new SlotDAO();

        try {
            if (roleID == 1) { // Mentor actions
                String action = request.getParameter("action");
                int slotId = requestDAO.getSlotIdByRequestId(requestId);

                switch (action) {
                    case "accept":
                        //Buoc 1: Cap nhat trang thai accept
                        requestDAO.updateStatusByMentor(requestId, "Processing");
                        //Buoc 2: Tu choi tat ca Mentee requests cung slot
                        requestDAO.rejectOtherMenteesForSameSlots(requestId);
                        //Buoc 3: Cap nhat trang thai co lien quan toi request sang Unavailable
                        slotDAO.updateSlotStatusToUnavailable(slotId);
                        break;
                    case "reject":
                        requestDAO.updateStatusByMentor(requestId, "Reject");
                        break;
                    case "complete":
                        requestDAO.updateStatusByMentor(requestId, "Completed");
                        slotDAO.updateSlotStatusToAvailable(slotId);
                        break;
                    default:
                        break;
                }
                response.sendRedirect("listrequestofmentor");
            } else if (roleID == 2) {
                response.sendRedirect("home");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
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
