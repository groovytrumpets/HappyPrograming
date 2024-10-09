
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

    public boolean updateMentee(Mentee mentee) throws SQLException {
        String sql = "UPDATE Mentee SET RoleID = ?, Avatar = ?, Username = ?, CreateDate = ?, "
                + "Phone = ?, Address = ?, DateOfBirth = ?, FullName = ?, Gender = ?, "
                + "Status = ? WHERE username = ?"; // Assuming MenteeID is the unique identifier

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, mentee.getRoleId());
            st.setBytes(2, mentee.getAvatar());
            st.setString(3, mentee.getUsername());
            st.setDate(4, new Date(mentee.getCreateDate().getTime()));
            st.setString(5, mentee.getPhone());
            //xoa email
            st.setString(6, mentee.getAddress());
            st.setDate(7, new Date(mentee.getDateOfBirth().getTime()));
            st.setString(8, mentee.getFullName());
            st.setString(9, mentee.getGender());
            st.setString(10, mentee.getStatus());
            st.setString(11, mentee.getUsername());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Mentee findMenteeByUsername(String username) {
        Mentee mentee = null;
        String sql = "SELECT [MenteeID]\n"
                + "      ,[RoleID]\n"
                + "      ,[Avatar]\n"
                + "      ,[Username]\n"
                + "      ,[CreateDate]\n"
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
                mentee.setMenteeId(rs.getInt("MenteeID"));
                mentee.setRoleId(rs.getInt("RoleID"));
                mentee.setUsername(rs.getString("Username"));
                byte[] avatar = rs.getBytes("Avatar");
                if (avatar != null) {
                    mentee.setAvatar(rs.getBytes("Avatar"));
                }
                mentee.setCreateDate(rs.getDate("CreateDate"));
                //xoa email
                mentee.setPhone(rs.getString("Phone"));
                mentee.setAddress(rs.getString("Address"));
                mentee.setDateOfBirth(rs.getDate("DateOfBirth"));
                mentee.setFullName(rs.getString("FullName"));
                mentee.setGender(rs.getString("Gender"));
                mentee.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return mentee; // Return the retrieved Mentor object or null if not found
    }

    public static void main(String[] args) {
        MenteeDAO u = new MenteeDAO();
        Mentee m = u.findMenteeByUsername("user3");
        System.out.println(m.getMenteeId());
    }
}
