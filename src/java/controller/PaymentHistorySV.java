package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<<< HEAD:src/java/controller/Admin/DeleteSkillServlet.java

package controller.Admin;

import DAO.SkillDAO;
import Model.Skill;
========
import DAO.PaymentDAO;
import DAO.WalletDAO;
import Model.Payment;
import Model.User;
>>>>>>>> d98d727e978c449005eea11b7c2ed8e3a383f121:src/java/controller/PaymentHistorySV.java
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<<< HEAD:src/java/controller/Admin/DeleteSkillServlet.java
========
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
>>>>>>>> d98d727e978c449005eea11b7c2ed8e3a383f121:src/java/controller/PaymentHistorySV.java
import java.util.List;

/**
 *
 * @author tuong
 */
@WebServlet(name="DeleteSkillServlet", urlPatterns={"/deleteSkillAdmin"})
public class DeleteSkillServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DeleteSkillServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteSkillServlet at " + request.getContextPath () + "</h1>");
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
<<<<<<<< HEAD:src/java/controller/Admin/DeleteSkillServlet.java
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SkillDAO act = new SkillDAO();
        List<Skill> listAllSkill = act.getListOfAllSkill();
        String page_raw = request.getParameter("page");
        String numDis_raw = request.getParameter("numDis");
        String deleteID_raw = request.getParameter("id");
        int deleteId = Integer.parseInt(deleteID_raw);
        act.deleteSkillById(deleteId);
        int page, numDis;
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
        } else {
            page = 1;
        }
        if (numDis_raw != null) {
            numDis = Integer.parseInt(numDis_raw);
        } else {
            numDis = 5;
        }
        int numSkill = listAllSkill.size();
        int numOfPage = (numSkill % numDis == 0 ? numSkill / numDis : (numSkill / numDis + 1));
        request.setAttribute("numOfPage", numOfPage);
        listAllSkill = act.getListOfSkillPaging(page, numDis);
        request.setAttribute("indexPage", page);
        request.setAttribute("numDis", numDis);

        request.setAttribute("list", listAllSkill);
        request.getRequestDispatcher("viewSkill.jsp").forward(request, response);
    }

    /** 
========
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        WalletDAO walletDAO = new WalletDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        User user = (User) session.getAttribute("acc");
        String page = request.getParameter("page");
        int currentPage = 1;
        if (page != null) {
            try {
                currentPage = Integer.parseInt(page);
            } catch (NumberFormatException e) {
                currentPage = 1;
            }
        }

        int totalItems, totalPages = 0;
        List<Payment> list = new ArrayList<>();
        if (user.getRoleId() == 2) {
            totalItems = paymentDAO.getAllPaymentsByMenteeUserName(user.getUsername()).size();
            totalPages = totalItems / 9;
            if (totalItems % 9 != 0) {
                totalPages++;
            }
            list = paymentDAO.getAllPaymentsByMenteeUserNamePagnition(user.getUsername(), currentPage, 9);
        } else {
            totalItems = paymentDAO.getAllPaymentsByMentorUserName(user.getUsername()).size();
            totalPages = totalItems / 9;
            if (totalItems % 9 != 0) {
                totalPages++;
            }
            list = paymentDAO.getAllPaymentsByMentorUserNamePagnition(user.getUsername(), currentPage, 9);
        }

        // Set attributes to be used in the JSP
        request.setAttribute("list", list);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        // Forward to the JSP
        request.getRequestDispatcher("PaymentHistory.jsp").forward(request, response);
    }

    /**
>>>>>>>> d98d727e978c449005eea11b7c2ed8e3a383f121:src/java/controller/PaymentHistorySV.java
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
