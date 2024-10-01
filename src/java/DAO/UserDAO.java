package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import Model.User;

public class UserDAO extends DBContext {

    // Method to find a user by username and password
    public User findUserByUsername(String a) {
        String sql = "SELECT [RoleID], [Username], [Status], [CreateDate], "
                + "[Email], [Password] "
                + "FROM [dbo].[User] WHERE Username = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, a);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setRoleId(rs.getInt("RoleID"));
                user.setUsername(rs.getString("Username"));
                user.setStatus(rs.getString("Status"));
                user.setCreateDate(rs.getDate("CreateDate"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findUserPass(String username, String password) {
        String sql = "SELECT [RoleID], [Username], [Status], [CreateDate], "
                + "[Email], [Password] "
                + "FROM [dbo].[User] WHERE Username = ? AND Password = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setRoleId(rs.getInt("RoleID"));
                user.setUsername(rs.getString("Username"));
                user.setStatus(rs.getString("Status"));
                user.setCreateDate(rs.getDate("CreateDate"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to insert a new user into the database
    public void insertUser(User user) {
        String sql = "INSERT INTO [dbo].[User] ([RoleID], [Username], [Status], [CreateDate], "
                + "[Email], [Password]) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try  {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user.getRoleId());
            st.setString(2, user.getUsername());
            st.setString(3, user.getStatus());
            st.setDate(4, new java.sql.Date(user.getCreateDate().getTime())); // Convert java.util.Date to java.sql.Date
            st.setString(5, user.getEmail());
            st.setString(6, user.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE [dbo].[User] SET [RoleID] = ?, [Status] = ?, [CreateDate] = ?, "
                + "[Email] = ?, [Password] = ? WHERE [Username] = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, user.getRoleId());
            st.setString(2, user.getStatus());
            st.setDate(3, new java.sql.Date(user.getCreateDate().getTime())); 
            st.setString(4, user.getEmail());
            st.setString(5, user.getPassword());
            st.setString(6, user.getUsername()); 
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUserByEmail(String mail) {
        String sql = "SELECT [RoleID], [Username], [Status], [CreateDate], "
                + "[Email], [Password] "
                + "FROM [dbo].[User] WHERE  Email = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, mail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setRoleId(rs.getInt("RoleID"));
                user.setUsername(rs.getString("Username"));
                user.setStatus(rs.getString("Status"));
                user.setCreateDate(rs.getDate("CreateDate"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //change password
    public boolean validateUser(String email, String password) throws SQLException {
        String sql = "SELECT * FROM [User] WHERE [Email] = ? AND [Password] = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // returns true if user exists
        }
    }

    public boolean updatePassword(String email, String newPassword) throws SQLException {
        String sql = "UPDATE [User] SET [Password] = ? WHERE [Email] = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newPassword);  // Update to the new password
            stmt.setString(2, email);        // Where the email matches
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;          // Return true if at least one row was updated
        }
    }

    //forgot password and send reset link
    public String getUserEmailByEmail(String email) {
        String userEmail = null;
        String query = "SELECT Email FROM [User] WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userEmail = rs.getString("Email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEmail;
    }

    public boolean updateUserPassword(String email, String newPassword) {
        String query = "UPDATE [User] SET [Password] = ? WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) throws SQLException {
        UserDAO u = new UserDAO();
        /*User newUser = new User();
        newUser.setRoleId(1);
        newUser.setUsername("hoanganhgp2");
        newUser.setStatus("active");
        LocalDate localDob = LocalDate.parse("2024-09-24");
        java.sql.Date dob = java.sql.Date.valueOf(localDob);
        newUser.setCreateDate(dob);  // current date
        newUser.setEmail("john.doe@example.com");
        newUser.setPassword("securepassword");
        System.out.println(newUser);
        u.updateUser(newUser);*/
        System.out.println(u.findUserByEmail("anhnhhhe187162@fpt.edu.vn"));
    }

}
