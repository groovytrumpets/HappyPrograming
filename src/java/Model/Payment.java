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

public class Payment {

    private int paymentID;
    private int requestID;
    private Date createDate;
    private Double totalAmount;
    private Date paymentDate;
    private String status;
    private Double balance;
    private int mentorID;
    private int menteeID;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(int paymentID, int requestID, Date createDate, Double totalAmount,
            Date paymentDate, String status, Double balance, int mentorID, int menteeID) {
        this.paymentID = paymentID;
        this.requestID = requestID;
        this.createDate = createDate;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.balance = balance;
        this.mentorID = mentorID;
        this.menteeID = menteeID;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", requestID=" + requestID + ", createDate=" + createDate + ", totalAmount=" + totalAmount + ", paymentDate=" + paymentDate + ", status=" + status + ", balance=" + balance + ", mentorID=" + mentorID + ", menteeID=" + menteeID + '}';
    }

    // Getters and Setters
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getMentorID() {
        return mentorID;
    }

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public int getMenteeID() {
        return menteeID;
    }

    public void setMenteeID(int menteeID) {
        this.menteeID = menteeID;
    }
}
