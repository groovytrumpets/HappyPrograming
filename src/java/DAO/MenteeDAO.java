package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import Model.Mentee;
import Model.User;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

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

    public void updateMentee(Mentee mentee) throws SQLException {
        String sql = "UPDATE Mentee SET RoleID = ?, Avatar = ?, Username = ?, CreateDate = ?, "
                + "Email = ?, Phone = ?, Address = ?, DateOfBirth = ?, FullName = ?, Gender = ?, "
                + "Status = ? WHERE username = ?"; // Assuming MenteeID is the unique identifier

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, mentee.getRoleId());
            st.setString(2, mentee.getAvatar());
            st.setString(3, mentee.getUsername());
            st.setDate(4, new Date(mentee.getCreateDate().getTime()));
            st.setString(5, mentee.getEmail());
            st.setString(6, mentee.getPhone());
            st.setString(7, mentee.getAddress());
            st.setDate(8, new Date(mentee.getDateOfBirth().getTime()));
            st.setString(9, mentee.getFullName());
            st.setString(10, mentee.getGender());
            st.setString(11, mentee.getStatus());
            st.setString(12, mentee.getUsername());
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Mentee findMenteeByUsername(String username) {
        Mentee mentee = null;
        String sql = "SELECT [MenteeID]\n"
                + "      ,[RoleID]\n"
                + "      ,[Avatar]\n"
                + "      ,[Username]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[DateOfBirth]\n"
                + "      ,[FullName]\n"
                + "      ,[Gender]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[Mentee] "
                + "where Username = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                mentee = new Mentee();
                mentee.setRoleId(rs.getInt("RoleID"));
                mentee.setUsername(rs.getString("Username"));
                mentee.setAvatar(rs.getString("Avatar"));
                mentee.setCreateDate(rs.getDate("CreateDate"));
                mentee.setEmail(rs.getString("Email"));
                mentee.setPhone(rs.getString("Phone"));
                mentee.setAddress(rs.getString("Address"));
                mentee.setDateOfBirth(rs.getDate("DateOfBirth"));
                mentee.setFullName(rs.getString("FullName"));
                mentee.setGender(rs.getString("Gender"));
                mentee.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {

        }

        return mentee; // Return the retrieved Mentor object or null if not found
    }

    public Mentee getMenteeByUsername(String username) {
        Mentee mentee = null;
        try {
            String query = "SELECT * FROM Mentee WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mentee = new Mentee(
                        rs.getInt("MenteeID"),
                        rs.getInt("RoleID"),
                        rs.getString("Avatar"),
                        rs.getString("Username"),
                        rs.getDate("CreateDate"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getDate("DateOfBirth"),
                        rs.getString("FullName"),
                        rs.getString("Gender"),
                        rs.getString("Status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mentee;
    }

    public void updateMenteeProfile(Mentee mentee, String oldUsername) throws SQLException {
        String updateMenteeSQL = "UPDATE Mentee SET Username = ?, FullName = ?, DateOfBirth = ?, Gender = ?, Address = ?, Avatar = ? WHERE MenteeID = ?";
        String updateUserSQL = "UPDATE [User] SET Username = ? WHERE Username = ?";

        try (
            PreparedStatement menteeStmt = connection.prepareStatement(updateMenteeSQL); 
            PreparedStatement userStmt = connection.prepareStatement(updateUserSQL)) {

            // Update Mentee table
            menteeStmt.setString(1, mentee.getUsername());
            menteeStmt.setString(2, mentee.getFullName());
            menteeStmt.setDate(3, new Date(mentee.getDateOfBirth().getTime()));
            menteeStmt.setString(4, mentee.getGender());
            menteeStmt.setString(5, mentee.getAddress());
            menteeStmt.setString(6, mentee.getAvatar());
            menteeStmt.setInt(7, mentee.getMenteeId());
            menteeStmt.executeUpdate();

            // Update User table
            userStmt.setString(1, mentee.getUsername());
            userStmt.setString(2, oldUsername);
            userStmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        //Mentee m = u.getMenteeByUsername("user5");
        System.out.println(new MenteeDAO().getMenteeByUsername("user5"));
    }
}
