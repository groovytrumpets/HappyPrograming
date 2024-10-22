/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import DAO.CVDAO;
import DAO.MentorDAO;
import DAO.RateDAO;
import DAO.RequestDAO;
import Model.CV;
import Model.Mentor;
import Model.Rate;
import Model.Request;
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
 * @author tuong
 */
@WebServlet(name = "adminSearchMentorServlet", urlPatterns = {"/adminSearchMentor"})
public class adminSearchMentorServlet extends HttpServlet {

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
            out.println("<title>Servlet adminSearchMentorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminSearchMentorServlet at " + request.getContextPath() + "</h1>");
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
        MentorDAO actMent = new MentorDAO();
        CVDAO actCV = new CVDAO();
        RateDAO actRate = new RateDAO();
        RequestDAO actRequest = new RequestDAO();
        String search = request.getParameter("search");
        if (search == null) {
            response.sendRedirect("mentorListAdmin");
        }
        List<Mentor> mentorList = actMent.searchAllMentor(search);
        String page_raw = request.getParameter("page");
        String numDis_raw = request.getParameter("numDis");

        int page, numDis;
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
        } else {
            page = 1;
        }
        if (numDis_raw != null) {
            numDis = Integer.parseInt(numDis_raw);
        } else {
            numDis = 10;
        }
        int stt = (page - 1) * numDis;
        request.setAttribute("stt", stt);
        int numMent = mentorList.size();
        int numOfPage = (numMent % numDis == 0 ? numMent / numDis : (numMent / numDis + 1));
        request.setAttribute("numOfPage", numOfPage);
        mentorList = actMent.searchListMentorPagiantion(search, page, numDis);
        request.setAttribute("search", search);
        request.setAttribute("indexPage", page);
        request.setAttribute("numDis", numDis);
        request.setAttribute("listMent", mentorList);
        List<CV> listCV = actCV.getMostEficientCV();
        request.setAttribute("listCV", listCV);
        //Manage request Accepted
        List<Request> curAcceptRequestt = actRequest.getAllRequestByStatus("Accepted");
        request.setAttribute("requestAccList", curAcceptRequestt);
        List<Request> allRequest = actRequest.getAllRequest();
        request.setAttribute("requestList", allRequest);
        List<Request> curFinishRequest = actRequest.getAllRequestByStatus("Completed");
        request.setAttribute("requestComList", curFinishRequest);
        PrintWriter out = response.getWriter();
        //Handle rate
        List<Rate> listRate = actRate.getAllRate();
        request.setAttribute("listRate", listRate);
        request.getRequestDispatcher("adminSearchMentor.jsp").forward(request, response);
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
        RequestDAO actRequest = new RequestDAO();
        RateDAO actRate = new RateDAO();
        MentorDAO actMent = new MentorDAO();
        CVDAO actCV = new CVDAO();
        String search = request.getParameter("search");
        if (search == null) {
            response.sendRedirect("mentorListAdmin");
        }
        List<Mentor> mentorList = actMent.searchAllMentor(search);
        String id_raw = request.getParameter("mentorId");
        int id = Integer.parseInt(id_raw);
        String status = request.getParameter("status");
        if (status != null) {
            if (status.equalsIgnoreCase("inactive")) {
                boolean checkUpdateStatus = actMent.changeStatusMentorById(id, "Active");
            } else {
                boolean checkUpdateStatus = actMent.changeStatusMentorById(id, "Inactive");
            }
        } else {
            boolean checkUpdateStatus = actMent.changeStatusMentorById(id, "Inactive");
        }
        String page_raw = request.getParameter("page");
        String numDis_raw = request.getParameter("numDis");
        int page, numDis;
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
        } else {
            page = 1;
        }
        if (numDis_raw != null) {
            numDis = Integer.parseInt(numDis_raw);
        } else {
            numDis = 10;
        }

        int stt = (page - 1) * numDis;
        request.setAttribute("stt", stt);
        int numMent = mentorList.size();
        int numOfPage = (numMent % numDis == 0 ? numMent / numDis : (numMent / numDis + 1));
        request.setAttribute("numOfPage", numOfPage);
        mentorList = actMent.searchListMentorPagiantion(search, page, numDis);
        request.setAttribute("search", search);
        request.setAttribute("indexPage", page);
        request.setAttribute("numDis", numDis);
        request.setAttribute("listMent", mentorList);
        List<CV> listCV = actCV.getMostEficientCV();
        request.setAttribute("listCV", listCV);
        //Manage request Accepted
        List<Request> curAcceptRequestt = actRequest.getAllRequestByStatus("Accepted");
        request.setAttribute("requestAccList", curAcceptRequestt);
        List<Request> allRequest = actRequest.getAllRequest();
        request.setAttribute("requestList", allRequest);
        List<Request> curFinishRequest = actRequest.getAllRequestByStatus("Completed");
        request.setAttribute("requestComList", curFinishRequest);
        PrintWriter out = response.getWriter();
        //Handle rate
        List<Rate> listRate = actRate.getAllRate();
        request.setAttribute("listRate", listRate);
        request.getRequestDispatcher("adminSearchMentor.jsp").forward(request, response);
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
