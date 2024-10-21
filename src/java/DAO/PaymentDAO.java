/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Payment;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Calendar;

/**
 *
 * @author nhhag
 */
public class PaymentDAO extends DBContext {

    // Method to insert a new payment into the database
    public boolean addPayment(Payment payment) {
        String sql = "INSERT INTO payment (requestId, paymentDate, totalAmount, status, sender, receiver) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getRequestId());
            LocalDateTime paymentDate = payment.getPaymentDate();
            if (paymentDate != null) {
                pstmt.setTimestamp(2, java.sql.Timestamp.valueOf(paymentDate));
            } else {
                pstmt.setNull(2, java.sql.Types.TIMESTAMP);
            }
            pstmt.setDouble(3, payment.getTotalAmount());
            pstmt.setString(4, payment.getStatus());
            pstmt.setString(5, payment.getSender());
            pstmt.setString(6, payment.getReceiver());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0; // Returns true if the payment was added successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }

    // Method to retrieve a payment by its ID
    public Payment getPaymentById(int paymentId) {
        String sql = "SELECT * FROM payment WHERE paymentId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, paymentId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Payment(
                        rs.getInt("paymentId"),
                        rs.getInt("requestId"),
                        rs.getTimestamp("paymentDate").toLocalDateTime(),
                        rs.getDouble("totalAmount"),
                        rs.getString("status"),
                        rs.getString("sender"),
                        rs.getString("receiver")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no payment found
    }

    // Method to retrieve all payments
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("paymentId"),
                        rs.getInt("requestId"),
                        rs.getTimestamp("paymentDate").toLocalDateTime(),
                        rs.getDouble("totalAmount"),
                        rs.getString("status"),
                        rs.getString("sender"),
                        rs.getString("receiver")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    // Method to update payment status
    public boolean updatePaymentStatus(int paymentId, String newStatus) {
        String sql = "UPDATE payment SET status = ? WHERE paymentId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, paymentId);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0; // Returns true if the update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }
    
     public static void main(String[] args) {
         List<Payment> samplePayments = new ArrayList<>();
        
        // Create sample payments using the parameterized constructor
        samplePayments.add(new Payment(1, 30, LocalDateTime.now(), 150.00, "1", "hoanganhgp23", "hoanganhgp2"));
        samplePayments.add(new Payment(2, 33, LocalDateTime.now(), 200.00, "1", "hoanganhgp23", "hoanganhgp2"));
        samplePayments.add(new Payment(3, 36, LocalDateTime.now(), 300.00, "1", "hoanganhgp23", "hoanganhgp2"));

        // Assume we have an instance of the class containing the addPayment method, named `paymentService`
        PaymentDAO paymentService = new PaymentDAO(); // Replace with your actual instance creation

        // Add each payment to the database
        for (Payment payment : samplePayments) {
            boolean isAdded = paymentService.addPayment(payment);
            System.out.println("Payment with paymentId " + payment.getPaymentId() + " added: " + isAdded);
        
        
        }
}
}
