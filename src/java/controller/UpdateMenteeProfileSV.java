/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.MenteeDAO;
import Model.Mentee;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
@WebServlet(name = "UpdateMenteeProfileSV", urlPatterns = {"/updatementeeprofile"})
@MultipartConfig
public class UpdateMenteeProfileSV extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "avatars"; // Directory to store avatar images

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
            out.println("<title>Servlet UpdateMenteeProfileSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateMenteeProfileSV at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("acc"); // Assuming "acc" is the logged-in user
            if (user != null) {
                String username = user.getUsername();
                MenteeDAO menteeDAO = new MenteeDAO();
                Mentee mentee = menteeDAO.getMenteeByUsername(username);

                if (mentee != null) {
                    request.setAttribute("mentee", mentee);
                    request.getRequestDispatcher("updateMenteeProfile.jsp").forward(request, response); // Forward to edit page
                    return;
                }
            }
        }
        response.sendRedirect("SignIn.jsp"); // Redirect if no user is logged in
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get the session
            HttpSession session = request.getSession();

            // Retrieve the mentee ID from the session
            Mentee curMentee = (Mentee) session.getAttribute("mentee");
            if (curMentee == null) {
                response.sendRedirect("home");
            }
            int menteeId = curMentee.getMenteeId();

            // Debugging output
            System.out.println("Mentee ID: " + menteeId);

            // Get form inputs
            String oldUsername = request.getParameter("oldUsername");
            String newUsername = request.getParameter("username");
            String fullName = request.getParameter("fullName");
            String dob_raw = request.getParameter("dateOfBirth");
            PrintWriter out = response.getWriter();
            out.print(dob_raw);
            Date dob;
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             
             
            dob=dateFormat.parse(dob_raw);
            
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");

            // Handle avatar upload
            Part avatarPart = request.getPart("avatar");
            String fileName = avatarPart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Create directory if it doesn't exist
            }
            String filePath = uploadPath + File.separator + fileName;
            avatarPart.write(filePath); // Save the uploaded file

            // Create Mentee object with updated information
            Mentee mentee = new Mentee();
            mentee.setMenteeId(menteeId);
            mentee.setUsername(newUsername);
            mentee.setFullName(fullName);
            mentee.setDateOfBirth(dob);
            mentee.setGender(gender);
            mentee.setAddress(address);
            mentee.setAvatar(fileName); // Save the file name to the database

            // Update Mentee in the database
            MenteeDAO menteeDAO = new MenteeDAO();
            menteeDAO.updateMenteeProfile(mentee, oldUsername); // Pass old username for updating User table
            // Update session and redirect
            session.setAttribute("mentee", mentee);
            response.sendRedirect("menteeprofile");
            return;
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions
            request.setAttribute("error", "Error updating profile.");
            request.getRequestDispatcher("updateMenteeProfile.jsp").forward(request, response);
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
