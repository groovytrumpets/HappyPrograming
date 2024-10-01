/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Mentor {
    private int mentorId;
    private int roleId;
    private String username;
    private Date createDate;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private String fullName;
    private String gender;
    private String status;

    public Mentor() {
    }

    public Mentor(int mentorId, int roleId, String username, Date createDate, String email, String phone, String address, Date dateOfBirth, String fullName, String gender, String status) {
        this.mentorId = mentorId;
        this.roleId = roleId;
        this.username = username;
        this.createDate = createDate;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.gender = gender;
        this.status = status;
    }

    public Mentor(int mentorId, String username, String email, String phone, String address, Date dateOfBirth, String fullName, String gender) {
        this.mentorId = mentorId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.gender = gender;
    }
    
    

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }
    

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mentor{" + "mentorId=" + mentorId + ", roleId=" + roleId + ", username=" + username + ", createDate=" + createDate + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", fullName=" + fullName + ", gender=" + gender + ", status=" + status + '}';
    }
    
}
