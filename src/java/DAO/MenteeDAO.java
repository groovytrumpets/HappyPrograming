package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import Model.Mentee;
import Model.User;

public class MenteeDAO extends DBContext {

    public void insertMentee(int roleId, byte[] avatar, String username, Date createDate, String email,
            String phone, String address, Date dateOfBirth, String fullName,
            String gender, String status) throws SQLException {
        String sql = "INSERT INTO Mentee (RoleID, Avatar, Username, CreateDate, Email, Phone, Address, "
                + "DateOfBirth, FullName, Gender, Status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roleId);
            st.setBytes(2, avatar);
            st.setString(3, username);
            st.setDate(4, new java.sql.Date(createDate.getTime()));
            st.setString(5, email);
            st.setString(6, phone);
            st.setString(7, address);
            st.setDate(8, new java.sql.Date(dateOfBirth.getTime()));
            st.setString(9, fullName);
            st.setString(10, gender);
            st.setString(11, status);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


