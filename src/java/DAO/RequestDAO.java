/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Request;
import Model.RequestSlotItem;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author nhhag
 */
public class RequestDAO extends DBContext {

    public List<RequestSlotItem> getDuplicateSlot(int id) {
        List<RequestSlotItem> requests = new ArrayList<>();

        String sql = "select *\n"
                + "from RequestSlotItem rq\n"
                + "join Request r on rq.RequestID = r.RequestID\n"
                + "where r.MenteeID = ?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                int requestSlotItemID = rs.getInt("RequestSlotItem");
                int slotId = rs.getInt("SlotID");

                RequestSlotItem requestSlotItem = new RequestSlotItem(requestSlotItemID, id, slotId);

                requests.add(requestSlotItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }

    public void insertRequest(Request request) {
        String sql = "INSERT INTO Request (MentorID, MenteeID, Price, Note, CreateDate, Status, Title,Framework, StartDate, EndDate, SkillID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            // Set parameters for the query
            st.setInt(1, request.getMentorId());
            st.setInt(2, request.getMenteeId());
            st.setFloat(3, request.getPrice());
            st.setString(4, request.getNote());
            st.setDate(5, Date.valueOf(request.getCreateDate()));
            st.setString(6, request.getStatus());
            st.setString(7, request.getTitle());
            st.setString(8, request.getFramework());
            st.setDate(9, Date.valueOf(request.getStartDate()));
            st.setDate(10, Date.valueOf(request.getEndDate()));
            st.setInt(11, request.getSkillId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addItemByRequestID(String[] slots) {
        String sql1 = "SELECT TOP 1 RequestID FROM [dbo].[Request] ORDER BY RequestID DESC";
        String sql2 = "INSERT INTO [dbo].[RequestSlotItem] (RequestID, SlotID) VALUES (?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            int lastRequestId = 0;
            if (rs.next()) {
                lastRequestId = rs.getInt("RequestID");
            }

            st = connection.prepareStatement(sql2);
            for (String slotIdStr : slots) {
                int slotId = Integer.parseInt(slotIdStr);
                st.setInt(1, lastRequestId);
                st.setInt(2, slotId);
                st.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Request> getAllRequestByStatus(String status) {
        List<Request> listRequest = new ArrayList<>();
        String sql = "SELECT*"
                + "  FROM [dbo].[Request]\n"
                + "  Where Request.Status like ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + status + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));
                LocalDate curCreaDate = rs.getDate("CreateDate").toLocalDate();
                curRequest.setCreateDate(curCreaDate);
                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                LocalDate start = rs.getDate("StartDate").toLocalDate();
                LocalDate end = rs.getDate("EndDate").toLocalDate();
                curRequest.setStartDate(start);
                curRequest.setEndDate(end);
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));
                listRequest.add(curRequest);
            }

        } catch (Exception e) {
        }
        return listRequest;

    }

    public List<Request> getAllRequest() {
        List<Request> listRequest = new ArrayList<>();
        String sql = "SELECT *"
                + "  FROM [dbo].[Request]\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));
                LocalDate curCreaDate = rs.getDate("CreateDate").toLocalDate();
                curRequest.setCreateDate(curCreaDate);
                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                LocalDate start = rs.getDate("StartDate").toLocalDate();
                LocalDate end = rs.getDate("EndDate").toLocalDate();
                curRequest.setStartDate(start);
                curRequest.setEndDate(end);
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));
                listRequest.add(curRequest);
            }

        } catch (Exception e) {
        }
        return listRequest;

    }

    public static void main(String[] args) {
        RequestDAO act = new RequestDAO();
        List<RequestSlotItem> curList = act.getDuplicateSlot(4);
        for (int i = 0; i < curList.size(); i++) {
            System.out.println(curList.get(i));
        }
    }
}
