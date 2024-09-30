package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import Model.Mentor;

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

    public void updateMentor(int mentorId, int roleId, String username, Date createDate, String email,
            String phone, String address, Date dateOfBirth, String fullName,
            String gender, String status) {
        String sql = "UPDATE Mentor SET RoleID = ?, Username = ?, CreateDate = ?, Email = ?, "
                + "Phone = ?, Address = ?, DateOfBirth = ?, FullName = ?, Gender = ?, "
                + "Status = ? WHERE Username = ?"; 

        try (PreparedStatement st = connection.prepareStatement(sql)) {
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
            st.setString(11, username); 

            st.executeUpdate();

        } catch (SQLException e) {
        }
    }

}
