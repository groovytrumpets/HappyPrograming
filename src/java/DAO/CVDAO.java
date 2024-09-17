/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CV;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class CVDAO extends DBContext {

    //get all users
    public void delete(int id) {
        String sql = "delete from Users where UserID =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public User getUserByID(int id) {
        //lenh sql select * from categories cach 1:
        String sql = "select*from [dbo].[User] where UserID =?;";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User mentor = new User(rs.getInt("userId"), rs.getInt("roleId"),
                        rs.getString("avatar"), rs.getString("username"),
                        rs.getString("status"), rs.getDate("createDate"),
                        rs.getString("email"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("address"),
                        rs.getDate("dateOfBirth"), rs.getString("fullName"),
                        rs.getString("gender"));
                return mentor;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public CV getCVbyMentor(int id) {
        //lenh sql select * from categories cach 1:
        String sql = "select*from [dbo].[CV] where MentorID =?;";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CV cv = new CV(rs.getInt("cvId"), rs.getInt("mentorId"),
                        rs.getString("education"), rs.getString("experience"),
                        rs.getString("activity"), rs.getString("professionIntroduction"),
                        rs.getString("certificate"), rs.getDate("createDate"),
                        rs.getString("jobProfession"), rs.getInt("yearOfExperience"),
                        rs.getString("serviceDescription"), rs.getString("status"), rs.getString("framework"));
                return cv;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public void updateUser(User c) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [Username] =?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[DateOfBirth] = ?\n"
                + "      ,[FullName] = ?\n"
                + "      ,[Gender] = ?\n"
                + " WHERE UserID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setString(2, c.getEmail());
            st.setString(3, c.getPhone());
            st.setString(4, c.getAddress());
            java.sql.Date sqlDob = new java.sql.Date(c.getDateOfBirth().getTime());
            st.setDate(5, sqlDob);
            st.setString(6, c.getFullName());
            st.setString(7, c.getGender());
            st.setInt(8, c.getUserId());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void updateCV(CV c) {
        String sql = "UPDATE [dbo].[CV]\n"
                + "   SET [Education] = ?\n"
                + "      ,[Experience] = ?\n"
                + "      ,[Activity] = ?\n"
                + "      ,[ProfessionIntroduction] = ?\n"
                + "      ,[JobProfession] = ?\n"
                + "      ,[YearOfExperience] = ?\n"
                + "      ,[ServiceDescription] = ?\n"
                + "      ,[Framework] = ?\n"
                + " WHERE [MentorID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getEducation());
            st.setString(2, c.getExperience());
            st.setString(3, c.getActivity());
            st.setString(4, c.getProfessionIntroduction());
            st.setString(5, c.getJobProfession());
            st.setInt(6, c.getYearOfExperience());
            st.setString(7, c.getServiceDescription());
            st.setString(8, c.getFramework());
            st.setInt(9, c.getMentorId());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /*
    public void insertCompany(Company c) {
        String sql = "INSERT INTO [dbo].[Company]\n"
                + "           ([CompanyCode]\n"
                + "           ,[CompanyName])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCompanyCode());
            st.setString(2, c.getCompanyName());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Job c) {
        String sql = "UPDATE [dbo].[Job]\n"
                + "   SET [JobTitle] = ?\n"
                + "      ,[CompanyCode] = ?\n"
                + "      ,[YearExp] = ?\n"
                + "      ,[Description] = ?\n"
                + " WHERE ID=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getJobTitle());
            st.setString(2, c.getCompanyCode());
            st.setInt(3, c.getYearExp());
            st.setString(4, c.getDescription());
            st.setInt(5, c.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
     */
}
