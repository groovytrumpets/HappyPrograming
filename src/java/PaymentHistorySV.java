/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import DAO.PaymentDAO;
import DAO.WalletDAO;
import Model.Payment;
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
@WebServlet(urlPatterns = {"/paymentHistory"})
public class PaymentHistorySV extends HttpServlet {

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
            out.println("<title>Servlet PaymentHistorySV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentHistorySV at " + request.getContextPath() + "</h1>");
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

    // Count total payments for the user
    int totalItems = paymentDAO.getAllPaymentsByUserName(user.getUsername()).size();
    int totalPages = totalItems / 9;
    if(totalItems % 9 != 0)
        totalPages++;


    // Retrieve the payments for the current page
    List<Payment> list = paymentDAO.getAllPaymentsByUserNamePagnition(user.getUsername(), currentPage, 9);

    // Set attributes to be used in the JSP
    request.setAttribute("list", list);
    request.setAttribute("currentPage", currentPage);
    request.setAttribute("totalPages", totalPages);

    // Forward to the JSP
    request.getRequestDispatcher("PaymentHistory.jsp").forward(request, response);
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
