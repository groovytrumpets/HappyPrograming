/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nhhag
 */
import java.util.Date;

public class User {

    private int roleId;
    private String username;
    private String status;
    private Date createDate;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private String fullName;
    private String gender;

    // Constructors
    public User() {}

    public User(int userId, int roleId, String avatar, String username, String status, Date createDate, 
                String email, String password, String phone, String address, Date dateOfBirth, 
                String fullName, String gender) {
        this.roleId = roleId;
        this.username = username;
        this.roleId = roleId;
        this.status = status;
        this.createDate = createDate;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.gender = gender;
    }

    // Getters and Setters
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" + "roleId=" + roleId  + ", username=" + username + ", status=" + status + ", createDate=" + createDate + ", email=" + email + ", password=" + password + ", phone=" + phone + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", fullName=" + fullName + ", gender=" + gender + '}';
    }
    
}

    // Optionally, override toString() method to represent the object as a string
    

