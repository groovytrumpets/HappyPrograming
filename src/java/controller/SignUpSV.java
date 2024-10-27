/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.MenteeDAO;
import DAO.MentorDAO;
import DAO.UserDAO;
import DAO.WalletDAO;
import Model.Mentee;
import Model.Mentor;
import util.Email;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author nhhag
 */
@WebServlet(name = "SignUpSV", urlPatterns = {"/signup"})
public class SignUpSV extends HttpServlet {

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
            out.println("<title>Servlet SignUpSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpSV at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Signup.jsp").forward(request, response);

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
        String repass = request.getParameter("repass");
        String mail = request.getParameter("email");
        String fname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String dob_raw = request.getParameter("dob");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String role_raw = request.getParameter("role");
        UserDAO userDAO = new UserDAO();
        MentorDAO mentorDAO = new MentorDAO();
        MenteeDAO menteeDAO = new MenteeDAO();
        WalletDAO walletDAO = new WalletDAO();
        try {

            LocalDate localDob = LocalDate.parse(dob_raw);
            java.sql.Date dob = java.sql.Date.valueOf(localDob);

            int role = Integer.parseInt(role_raw);

            if (!pass.equals(repass)) {
                request.setAttribute("perror1", "Passwords do not match.");
                request.getRequestDispatcher("Signup.jsp").forward(request, response);
                return;
            }

            if (!checkValidPass(pass, repass)) {
                request.setAttribute("perror1", "Password do not meet requirement");
                request.getRequestDispatcher("Signup.jsp").forward(request, response);
                return;
            }

            if (userDAO.findUserByUsername(username) == null && userDAO.findUserByEmail(mail) == null) {
                User newUser = new User();
                newUser.setUsername(username);
                String enpass = encrypt(pass);
                newUser.setPassword(enpass);
                newUser.setEmail(mail);
                newUser.setRoleId(role);
                newUser.setCreateDate(new Date());
                newUser.setStatus("inactive");
                userDAO.insertUser(newUser);

                if (role == 1) {
                    mentorDAO.insertMentor(role, username,  dob, phone, address, dob, fname, sex, "inactive");
                    walletDAO.addNewWallet(username);
                } else {
                    menteeDAO.insertMentee(role, null, username, dob, mail, phone, address, dob, fname, sex, "inactive");
                    walletDAO.addNewWallet(username);
                }

                String subject = "Confirm Your Signup";
                String content = "Dear " + fname + ",\n\n"
                        + "Thank you for signing up with us! We're excited to have you on board. Please review your information below and click the link to confirm your email address.\n\n"
                        + "------------------------\n"
                        + "Full Name: " + fname + "\n"
                        + "Email: " + mail + "\n"
                        + "Phone: " + phone + "\n"
                        + "Date of Birth: " + dob_raw + "\n"
                        + "Gender: " + sex + "\n"
                        + "Address: " + address + "\n"
                        + "------------------------\n\n"
                        + "Please click the link below to confirm your email address:\n"
                        + "http://14.177.86.215:9999/happy_programming/confirm?email=" + mail + "\n\n"
                        + "If you did not sign up for this account, please disregard this email.\n\n"
                        + "Best regards,\n"
                        + "The Happy Programming Team";

                Email.sendEmail(mail, subject, content);

                request.getRequestDispatcher("success.jsp").forward(request, response);

            } else {
                if (userDAO.findUserByUsername(username) != null) {
                    request.setAttribute("uerror", "User already exists.");
                }
                if (userDAO.findUserByEmail(mail) != null) {
                    request.setAttribute("eerror", "Email already exists.");
                }
                request.getRequestDispatcher("Signup.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("notify", e);
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
        }

    }

    private boolean checkValidPass(String pass, String repass) {
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        if (pass.length() < 6 || pass.length() > 18) {
            return false;
        }
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                hasNumber = true;
            }
            if (Character.isUpperCase(pass.charAt(i))) {
                hasUpperCase = true;
            }
        }
        if (hasNumber == true && hasUpperCase == true) {
            return true;
        }

        return false;
    }

    private String encrypt(String password) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            encrypted.append((char) (c + 5)); // Shift character by key
        }

        return encrypted.toString();
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
