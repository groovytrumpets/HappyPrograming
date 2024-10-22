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
     public List<Payment> getAllPaymentsByUserName(String username) {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment\n"
                + "Where sender = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
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




    public List<Payment> getAllPaymentsByUserNamePagnition(String username, int pageNumber, int pageSize) {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment WHERE sender = ? ORDER BY paymentDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            // Calculate the offset for pagination
            int offset = (pageNumber - 1) * pageSize;
            st.setInt(2, offset);
            st.setInt(3, pageSize);

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
        /*Payment samplePayments = new Payment();
         samplePayments.setPaymentDate(LocalDateTime.now());
         samplePayments.setSender("hoanganhgp23");
         samplePayments.setReceiver("admin");
         samplePayments.setStatus("0");
         samplePayments.setTotalAmount(10000);*/
        PaymentDAO a = new PaymentDAO();
        System.out.println(a.getAllPaymentsByUserName("hoanganhgp23").size());
       /* for (int i = 0; i < 8; i++) {
             System.out.println(a.getAllPaymentsByUserNamePagnition("hoanganhgp23", 1, 9).get(i));
        }*/
       
    }
}
