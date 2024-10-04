package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import Model.Mentor;
import java.util.ArrayList;
import java.util.List;

public class MentorDAO extends DBContext {

    public void insertMentor(int roleId, String username, Date createDate, String email, String phone, String address,
            Date dateOfBirth, String fullName, String gender, String status) {
        String sql = "INSERT INTO Mentor (RoleID, Username, CreateDate, Email, Phone, Address, DateOfBirth, FullName, Gender, Status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roleId);
            st.setString(2, username);
            st.setDate(3, new java.sql.Date(createDate.getTime()));
            st.setString(4, email);
            st.setString(5, phone);
            st.setString(6, address);
            st.setDate(7, new java.sql.Date(dateOfBirth.getTime()));
            st.setString(8, fullName);
            st.setString(9, gender);
            st.setString(10, status);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateMentor(Mentor mentor) {
        String sql = "UPDATE Mentor SET RoleID = ?, Username = ?, CreateDate = ?, Email = ?, "
                + "Phone = ?, Address = ?, DateOfBirth = ?, FullName = ?, Gender = ?, "
                + "Status = ? WHERE Username = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, mentor.getRoleId());
            st.setString(2, mentor.getUsername());
            st.setDate(3, new java.sql.Date(mentor.getCreateDate().getTime()));
            st.setString(5, mentor.getPhone());
            st.setString(6, mentor.getPhone());
            st.setDate(7, new java.sql.Date(mentor.getDateOfBirth().getTime()));
            st.setString(8, mentor.getFullName());
            st.setString(9, mentor.getGender());
            st.setString(10, mentor.getStatus());
            st.setString(11, mentor.getUsername());

            st.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public Mentor findMentorByUsername(String username) {
        Mentor mentor = null;
        String sql = "SELECT [MentorID]\n"
                + "      ,[RoleID]\n"
                + "      ,[Username]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[DateOfBirth]\n"
                + "      ,[FullName]\n"
                + "      ,[Gender]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[Mentor] "
                + "where Username = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                mentor = new Mentor();
                mentor.setRoleId(rs.getInt("RoleID"));
                mentor.setUsername(rs.getString("Username"));
                mentor.setCreateDate(rs.getDate("CreateDate"));
                mentor.setPhone(rs.getString("Phone"));
                mentor.setAddress(rs.getString("Address"));
                mentor.setDateOfBirth(rs.getDate("DateOfBirth"));
                mentor.setFullName(rs.getString("FullName"));
                mentor.setGender(rs.getString("Gender"));
                mentor.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {

        }

        return mentor; // Return the retrieved Mentor object or null if not found
    }

    public List<Mentor> getAllMentor() {
        List<Mentor> listMentor = new ArrayList<>();
        String sql = "SELECT [MentorID]\n"
                + "      ,[RoleID]\n"
                + "      ,[Username]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[DateOfBirth]\n"
                + "      ,[FullName]\n"
                + "      ,[Gender]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[Mentor]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Mentor mentor = new Mentor();
                mentor.setMentorId(rs.getInt("MentorID"));
                mentor.setRoleId(rs.getInt("RoleID"));
                mentor.setUsername(rs.getString("Username"));
                mentor.setCreateDate(rs.getDate("CreateDate"));
                mentor.setPhone(rs.getString("Phone"));
                mentor.setAddress(rs.getString("Address"));
                mentor.setDateOfBirth(rs.getDate("DateOfBirth"));
                mentor.setFullName(rs.getString("FullName"));
                mentor.setGender(rs.getString("Gender"));
                mentor.setStatus(rs.getString("Status"));
                listMentor.add(mentor);
            }
        } catch (Exception e) {
        }

        return listMentor;
    }

    public static void main(String[] args) {
        MentorDAO act = new MentorDAO();
                List<Mentor> listMentor = act.getAllMentor();
                System.out.println(listMentor.get(0).getMentorId());


    }
}
