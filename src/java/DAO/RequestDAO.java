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
import java.util.Date;
import java.util.List;

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
                + "where r.Status = 'Processing' and r.MenteeID = ?";

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
        String sql = "INSERT INTO Request (MentorID, MenteeID, Price, Note, CreateDate, Status, Title, DeadlineHour, DeadlineDate, Framework) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try    
        {
            PreparedStatement st = connection.prepareStatement(sql);

            // Set parameters for the query
            st.setObject(1, request.getMentorId(), java.sql.Types.INTEGER);
            st.setObject(2, request.getMenteeId(), java.sql.Types.INTEGER);
            st.setFloat(3, request.getPrice());
            st.setString(4, request.getNote());
            st.setDate(5, Date.valueOf(request.getCreateDate()));
            st.setString(6, request.getStatus());
            st.setString(7, request.getTitle());
            st.setTime(8, Time.valueOf(request.getDeadlineHour()));
            st.setDate(9, Date.valueOf(request.getDeadlineDate()));
            st.setString(10, request.getFramework());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*public List<Request> getAllRequestByStatus(String status) {
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
    }*/
}
