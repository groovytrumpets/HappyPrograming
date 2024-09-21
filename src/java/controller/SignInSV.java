/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author nhhag
 */
@WebServlet(name = "SignInSV", urlPatterns = {"/signin"})
public class SignInSV extends HttpServlet {

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
            out.println("<title>Servlet SignInSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignInSV at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("SignIn.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String rememberMe = request.getParameter("rememberMe");  // Ensure checkbox name matches form

        UserDAO u = new UserDAO();
        User a = u.findUserPass(username, pass);
        try {

            if (a == null && a.getStatus().equals("inactive")) {
                request.setAttribute("notify", "Wrong username or password");
                request.getRequestDispatcher("SignIn.jsp").forward(request, response);
            } else {
                if (a != null && a.getStatus().equals("active")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", a);

                    if (rememberMe != null) {  // Checkbox was checked
                        Cookie usernameCookie = new Cookie("username", username);
                        Cookie passwordCookie = new Cookie("pass", pass);

                        usernameCookie.setMaxAge(7 * 24 * 60 * 60);
                        passwordCookie.setMaxAge(7 * 24 * 60 * 60);

                        response.addCookie(usernameCookie);
                        response.addCookie(passwordCookie);
                    } else {

                        Cookie usernameCookie = new Cookie("username", null);
                        Cookie passwordCookie = new Cookie("pass", null);

                        // Invalidate the cookies by setting the max age to 0
                        usernameCookie.setMaxAge(0);
                        passwordCookie.setMaxAge(0);

                        response.addCookie(usernameCookie);
                        response.addCookie(passwordCookie);
                    }
                    response.sendRedirect("Home.jsp");
                } else if (a != null && a.getStatus().equals("inactive")) {
                    request.setAttribute("notify", "Your account is not active, please active by link in your email");
                    request.getRequestDispatcher("SignIn.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            request.setAttribute("notify", "Wrong username or password");
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
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
