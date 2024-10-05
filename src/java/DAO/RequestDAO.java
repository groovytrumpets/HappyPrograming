/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Request;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author tuong
 */
public class RequestDAO extends DBContext {

    public List<Request> getAllRequestByStatus(String status) {
        List<Request> listRequest = new ArrayList<>();
        String sql = "SELECT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Status]\n"
                + "      ,[Title]\n"
                + "      ,[DeadlineHour]\n"
                + "      ,[DeadlineDate]\n"
                + "      ,[Framework]\n"
                + "  FROM [dbo].[Request]\n"
                + "  Where Request.Status like ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + status + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setReqId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));
                curRequest.setCreateDate(rs.getDate("CreateDate"));
                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setDeadLineDate(rs.getDate("DeadlineDate"));
                Time time = rs.getTime("DeadlineHour");
                if (time != null) {
                    curRequest.setDeadlineHour(time.toLocalTime());
                }
                curRequest.setFramework(rs.getString("Framework"));
                listRequest.add(curRequest);
            }

        } catch (Exception e) {
        }
        return listRequest;

    }

    public List<Request> getAllRequest() {
        List<Request> listRequest = new ArrayList<>();
        String sql = "SELECT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Status]\n"
                + "      ,[Title]\n"
                + "      ,[DeadlineHour]\n"
                + "      ,[DeadlineDate]\n"
                + "      ,[Framework]\n"
                + "  FROM [dbo].[Request]\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setReqId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));
                curRequest.setCreateDate(rs.getDate("CreateDate"));
                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setDeadLineDate(rs.getDate("DeadlineDate"));
                Time time = rs.getTime("DeadlineHour");
                if (time != null) {
                    curRequest.setDeadlineHour(time.toLocalTime());
                }
                curRequest.setFramework(rs.getString("Framework"));
                listRequest.add(curRequest);
            }

        } catch (Exception e) {
        }
        return listRequest;

    }

    public static void main(String[] args) {
        RequestDAO act = new RequestDAO();
        List<Request> curList = act.getAllRequestByStatus("Accepted");
        System.out.println(curList.get(0).getMentorId());
    }
}
