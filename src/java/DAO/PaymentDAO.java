/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Payment;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author nhhag
 */
public class PaymentDAO extends DBContext {

    public Payment getNewestPaymentByMenteeId(int menteeId) {
        Payment payment = null;
        String sql = "SELECT TOP 1 * FROM Payment WHERE MenteeID = ? ORDER BY PaymentDate DESC";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, menteeId);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                payment = new Payment();
                payment.setPaymentID(resultSet.getInt("PaymentID"));
                payment.setRequestID(resultSet.getInt("RequestID"));
                payment.setCreateDate(resultSet.getDate("CreateDate"));
                payment.setTotalAmount(resultSet.getDouble("TotalAmount"));
                payment.setPaymentDate(resultSet.getDate("PaymentDate"));
                payment.setStatus(resultSet.getString("Status"));
                payment.setBalance(resultSet.getDouble("Balance"));
                payment.setMentorID(resultSet.getInt("MentorID"));
                payment.setMenteeID(resultSet.getInt("MenteeID"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return payment;
    }
    public static void main(String[] args) {
        PaymentDAO p = new PaymentDAO();
        System.out.println(p.getNewestPaymentByMenteeId(4));
    }
}
