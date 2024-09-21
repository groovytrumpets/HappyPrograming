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
                + "[Email], [Password], [Phone], [Address], [DateOfBirth], [FullName], [Gender] "
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
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setDateOfBirth(rs.getDate("DateOfBirth"));
                user.setFullName(rs.getString("FullName"));
                user.setGender(rs.getString("Gender"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findUserPass(String a, String b) {
        String sql = "SELECT * FROM [dbo].[User] WHERE [Username] = ? and [Password] = ?";
        User user = null;

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, a);
            st.setString(2, b);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setRoleId(rs.getInt("RoleID"));
                user.setUsername(rs.getString("Username"));
                user.setStatus(rs.getString("Status"));
                user.setCreateDate(rs.getDate("CreateDate"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setDateOfBirth(rs.getDate("DateOfBirth"));
                user.setFullName(rs.getString("FullName"));
                user.setGender(rs.getString("Gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;  // Return the user object or null if not found
    }

    // Method to insert a new user into the database
    public void insertUser(User user) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([Username]\n"
                + "           ,[RoleID]\n"
                + "           ,[Status]\n"
                + "           ,[CreateDate]\n"
                + "           ,[Email]\n"
                + "           ,[Password]\n"
                + "           ,[Phone]\n"
                + "           ,[Address]\n"
                + "           ,[DateOfBirth]\n"
                + "           ,[FullName]\n"
                + "           ,[Gender])\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, user.getUsername());
            st.setInt(2, user.getRoleId());
            st.setString(3, user.getStatus());
            st.setDate(4, new java.sql.Date(user.getCreateDate().getTime())); // java.util.Date to java.sql.Date
            st.setString(5, user.getEmail());
            st.setString(6, user.getPassword());
            st.setString(7, user.getPhone());
            st.setString(8, user.getAddress());
            st.setDate(9, new java.sql.Date(user.getDateOfBirth().getTime())); // java.util.Date to java.sql.Date
            st.setString(10, user.getFullName());
            st.setString(11, user.getGender());

            st.executeUpdate();  // Execute the insert statement

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE [dbo].[User] SET "
                + "[RoleID] = ?, [Status] = ?, [CreateDate] = ?, [Email] = ?, "
                + "[Password] = ?, [Phone] = ?, [Address] = ?, [DateOfBirth] = ?, [FullName] = ?, [Gender] = ? "
                + "WHERE [Username] = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, user.getRoleId());
            st.setString(2, user.getStatus());
            st.setDate(3, new java.sql.Date(user.getCreateDate().getTime())); // java.util.Date to java.sql.Date
            st.setString(4, user.getEmail());
            st.setString(5, user.getPassword());
            st.setString(6, user.getPhone());
            st.setString(7, user.getAddress());
            st.setDate(8, new java.sql.Date(user.getDateOfBirth().getTime())); // java.util.Date to java.sql.Date
            st.setString(9, user.getFullName());
            st.setString(10, user.getGender());
            st.setString(11, user.getUsername());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUserByEmail(String email) {
        String sql = "SELECT * FROM [dbo].[User] WHERE [Email] = ?";
        User user = null;

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setRoleId(rs.getInt("RoleID"));
                user.setUsername(rs.getString("Username"));
                user.setStatus(rs.getString("Status"));
                user.setCreateDate(rs.getDate("CreateDate"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setDateOfBirth(rs.getDate("DateOfBirth"));
                user.setFullName(rs.getString("FullName"));
                user.setGender(rs.getString("Gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;  // Return the user object or null if not found
    }

    // Main method for testing
    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        /*String username = "johndoe";
        String password = "securepassword123"; // Ensure this is hashed in practice
        String email = "johndoe@example.com";
        String fullName = "John Doe";
        String phone = "123-456-7890";
        String dob_raw = "1990-01-15";
        String gender = "Male";
        String address = "123 Elm Street, Springfield, IL";
        int role = 1;

        // Parse the date of birth
        LocalDate localDob = LocalDate.parse(dob_raw);
        Date dob = Date.valueOf(localDob);

        // Create and set up the new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // Remember to hash the password
        newUser.setEmail(email);
        newUser.setFullName(fullName);
        newUser.setPhone(phone);
        newUser.setDateOfBirth(dob);
        newUser.setGender(gender);
        newUser.setAddress(address);
        newUser.setRoleId(role);
        newUser.setCreateDate(new java.util.Date()); // Current date
        newUser.setStatus("inactive"); // Status set to inactive until confirmation
        u.insertUser(newUser);*/
        System.out.println(u.findUserPass("tuonghuymai","Hoanganhgp2"));
    }

}
