/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Rate;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tuong
 */
public class RateDAO extends DBContext {

    public List<Rate> getAllRate() {
        List<Rate> listRate = new ArrayList<>();
        String sql = "SELECT [MentorID]\n"
                + "      ,[MenteeID]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Status]\n"
                + "      ,[Comment]\n"
                + "      ,[Rate]\n"
                + "  FROM [dbo].[Rate]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Rate curRate = new Rate();
                curRate.setMentorId(rs.getInt("MentorID"));        
                curRate.setMenteeId(rs.getInt("MenteeID"));        
                curRate.setCreateDate(rs.getDate("CreateDate"));   
                curRate.setStatus(rs.getString("Status"));          
                curRate.setComment(rs.getString("Comment"));        
                curRate.setRate(rs.getInt("Rate"));                
                listRate.add(curRate);
            }
        } catch (Exception e) {
        }
        return listRate;
    }
    
    public void saveRating(int menteeId, int mentorId, int rate, String comment) {
        String sql = "INSERT INTO Rate (MentorID, MenteeID, CreateDate, Status, Comment, Rate) VALUES (?, ?, GETDATE(), ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, mentorId);
            st.setInt(2, menteeId);
            st.setString(3, "active"); // Assuming status is set to 'active' when a rating is made
            st.setString(4, comment);
            st.setInt(5, rate);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
