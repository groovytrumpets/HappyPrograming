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

                RequestSlotItem s = new RequestSlotItem();
                s.setRequestId(rs.getInt("RequestID"));
                s.setRequestSlotItemId(rs.getInt("RequestSlotItem"));
                s.setSlotId(rs.getInt("SlotID"));
                requests.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }

    public List<RequestSlotItem> getSlotByRequestID(int id) {
        List<RequestSlotItem> requests = new ArrayList<>();

        String sql = "select *\n"
                + "from RequestSlotItem rq\n"
                + "where rq.Requestid = ?";

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
        String sql = "INSERT INTO [dbo].[Request]\n"
                + "           ([MentorID]\n"
                + "           ,[MenteeID]\n"
                + "           ,[Price]\n"
                + "           ,[Note]\n"
                + "           ,[CreateDate]\n"
                + "           ,[Status]\n"
                + "           ,[Title]\n"
                + "           ,[Framework]\n"
                + "           ,[StartDate]\n"
                + "           ,[EndDate]\n"
                + "           ,[SkillID])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

    public void updateRequest(Request request) {
        String sql = "UPDATE [dbo].[Request]\n"
                + "SET [MentorID] = ?,\n"
                + "    [MenteeID] = ?,\n"
                + "    [Price] = ?,\n"
                + "    [Note] = ?,\n"
                + "    [CreateDate] = ?,\n"
                + "    [Status] = ?,\n"
                + "    [Title] = ?,\n"
                + "    [Framework] = ?,\n"
                + "    [StartDate] = ?,\n"
                + "    [EndDate] = ?,\n"
                + "    [SkillID] = ?\n"
                + "WHERE [RequestID] = ?";

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
            st.setInt(12, request.getRequestId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateItemsByRequestID(int requestId, String[] newSlots) {
        String deleteSql = "DELETE FROM [dbo].[RequestSlotItem] WHERE RequestID = ?";
        String insertSql = "INSERT INTO [dbo].[RequestSlotItem] (RequestID, SlotID) VALUES (?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(deleteSql);
            st.setInt(1, requestId);
            st.executeUpdate();

            st = connection.prepareStatement(insertSql);
            for (String slotIdStr : newSlots) {
                int slotId = Integer.parseInt(slotIdStr);
                st.setInt(1, requestId);
                st.setInt(2, slotId);
                st.executeUpdate();
            }

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

    public int getNumOfMentorEachMentee(int menteeId) {
        int count = 0;
        String sql = "select COUNT(DISTINCT MentorID) from Request \n"
                + "where [Status] != 'Cancel' and [Status] != 'Pending'\n"
                + "and MenteeID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, menteeId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getNumOfSkillEachMentee(int menteeId) {
        int count = 0;
        String sql = "select COUNT(DISTINCT SkillID) from Request \n"
                + "where [Status] != 'Cancel' and [Status] != 'Pending'\n"
                + "and MenteeID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, menteeId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Request> getRequestByMenteeID(int menteeId) {
        List<Request> listReq = new ArrayList<>();
        String sql = "SELECT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request]\n"
                + "where [Status] != 'Cancel' and [Status] != 'Pending'\n"
                + "and MenteeID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, menteeId);
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

                listReq.add(curRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listReq;
    }

    public List<Request> getAllRequestPagination(int page, int disNum) {
        List<Request> listReq = new ArrayList<>();
        String sql = "SELECT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request]\n"
                + "  order by RequestID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            int offset = (page - 1) * disNum;
            st.setInt(1, offset);
            st.setInt(2, disNum);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));

                Date createDateSql = rs.getDate("CreateDate");
                if (createDateSql != null) {
                    curRequest.setCreateDate(createDateSql.toLocalDate());
                }

                Date startDateSql = rs.getDate("StartDate");
                if (startDateSql != null) {
                    curRequest.setStartDate(startDateSql.toLocalDate());
                }

                Date endDateSql = rs.getDate("EndDate");
                if (endDateSql != null) {
                    curRequest.setEndDate(endDateSql.toLocalDate());
                }

                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));

                listReq.add(curRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listReq;
    }

    public Request getRequestByID(int id) {
        String sql = "SELECT *"
                + "  FROM [dbo].[Request]"
                + "Where RequestID = ?\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
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
                return curRequest;
            }

        } catch (Exception e) {
        }
        return null;

    }

    public String[] getAllStatusInRequest() {
        String sql = "SELECT DISTINCT [Status] FROM Request";
        List<String> statuses = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                // Retrieve the status and add it to the list
                String status = rs.getString("Status");
                statuses.add(status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert the list to a String array
        return statuses.toArray(new String[0]);
    }

    public List<Request> getAllRequestPaginationByStatus(int page, int disNum, String status) {
        List<Request> listReq = new ArrayList<>();
        String sql = "SELECT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request]\n"
                + "  where [Status] = ?\n"
                + "  order by RequestID\n"
                + "offset ? rows\n"
                + "fetch next ? rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            int offset = (page - 1) * disNum;
            st.setString(1, status);
            st.setInt(2, offset);
            st.setInt(3, disNum);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));

                Date createDateSql = rs.getDate("CreateDate");
                if (createDateSql != null) {
                    curRequest.setCreateDate(createDateSql.toLocalDate());
                }

                Date startDateSql = rs.getDate("StartDate");
                if (startDateSql != null) {
                    curRequest.setStartDate(startDateSql.toLocalDate());
                }

                Date endDateSql = rs.getDate("EndDate");
                if (endDateSql != null) {
                    curRequest.setEndDate(endDateSql.toLocalDate());
                }

                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));

                listReq.add(curRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listReq;
    }

    public List<Request> getAllRequestBySearch(String search) {
        List<Request> listReq = new ArrayList<>();
        String sql = " SELECT DISTINCT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,r.[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,r.[CreateDate]\n"
                + "      ,r.[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request] r LEFT JOIN Mentee m \n"
                + "  on r.MenteeID = m.MenteeID\n"
                + "  Where RequestID like ? \n"
                + "  OR Title like ?\n"
                + "  OR m.Username like ?\n"
                + "  ORDER BY RequestID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 0);
            if (converSearch(search)) {
                st.setInt(1, Integer.parseInt(search));
            }
            String searchPattern = "%" + search + "%";
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));

                Date createDateSql = rs.getDate("CreateDate");
                if (createDateSql != null) {
                    curRequest.setCreateDate(createDateSql.toLocalDate());
                }

                Date startDateSql = rs.getDate("StartDate");
                if (startDateSql != null) {
                    curRequest.setStartDate(startDateSql.toLocalDate());
                }

                Date endDateSql = rs.getDate("EndDate");
                if (endDateSql != null) {
                    curRequest.setEndDate(endDateSql.toLocalDate());
                }

                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));

                listReq.add(curRequest);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }

        return listReq;
    }

    public List<Request> getAllRequestBySearchPagination(String search, int page, int disNum) {
        List<Request> listReq = new ArrayList<>();
        String sql = "  SELECT DISTINCT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,r.[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,r.[CreateDate]\n"
                + "      ,r.[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request] r LEFT JOIN Mentee m \n"
                + "  on r.MenteeID = m.MenteeID\n"
                + "  Where RequestID like ? \n"
                + "  OR Title like ?\n"
                + "  OR m.Username like ?\n"
                + "  ORDER BY RequestID\n"
                + "  OFFSET ? ROWS\n"
                + "  FETCH NEXT ? ROW ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 0);
            if (converSearch(search)) {
                st.setInt(1, Integer.parseInt(search));
            }
            String searchPattern = "%" + search + "%";
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);
            int numOffSet = (page - 1) * disNum;
            st.setInt(4, numOffSet);
            st.setInt(5, disNum);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));

                Date createDateSql = rs.getDate("CreateDate");
                if (createDateSql != null) {
                    curRequest.setCreateDate(createDateSql.toLocalDate());
                }

                Date startDateSql = rs.getDate("StartDate");
                if (startDateSql != null) {
                    curRequest.setStartDate(startDateSql.toLocalDate());
                }

                Date endDateSql = rs.getDate("EndDate");
                if (endDateSql != null) {
                    curRequest.setEndDate(endDateSql.toLocalDate());
                }

                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));

                listReq.add(curRequest);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }

        return listReq;
    }

    public boolean converSearch(String search) {
        try {
            int id = Integer.parseInt(search);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Request> getRequestByStatusAndSearch(String search, String status) {
        List<Request> listReq = new ArrayList<>();
        String sql = " SELECT DISTINCT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,r.[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,r.[CreateDate]\n"
                + "      ,r.[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request] r LEFT JOIN Mentee m \n"
                + "  on r.MenteeID = m.MenteeID\n"
                + "  Where (RequestID like ? \n"
                + "  OR Title like ?\n"
                + "  OR m.Username like ?)\n"
                + "  and r.Status like ? \n"
                + "  ORDER BY RequestID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 0);
            if (converSearch(search)) {
                st.setInt(1, Integer.parseInt(search));
            }
            String searchPattern = "%" + search + "%";
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);
            String statusPattern = "%" + status + "%";
            st.setString(4, statusPattern);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));

                Date createDateSql = rs.getDate("CreateDate");
                if (createDateSql != null) {
                    curRequest.setCreateDate(createDateSql.toLocalDate());
                }

                Date startDateSql = rs.getDate("StartDate");
                if (startDateSql != null) {
                    curRequest.setStartDate(startDateSql.toLocalDate());
                }

                Date endDateSql = rs.getDate("EndDate");
                if (endDateSql != null) {
                    curRequest.setEndDate(endDateSql.toLocalDate());
                }

                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));

                listReq.add(curRequest);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }

        return listReq;
    }

    public List<Request> getRequestByStatusAndSearchPagination(String search, int page, int disNum, String status) {
        List<Request> listReq = new ArrayList<>();
        String sql = "  SELECT DISTINCT [RequestID]\n"
                + "      ,[MentorID]\n"
                + "      ,r.[MenteeID]\n"
                + "      ,[Price]\n"
                + "      ,[Note]\n"
                + "      ,r.[CreateDate]\n"
                + "      ,r.[Status]\n"
                + "      ,[Title]\n"
                + "      ,[Framework]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[SkillID]\n"
                + "  FROM [dbo].[Request] r LEFT JOIN Mentee m \n"
                + "  on r.MenteeID = m.MenteeID\n"
                + "  Where (RequestID like ? \n"
                + "  OR Title like ?\n"
                + "  OR m.Username like ?)\n"
                + "  and r.Status like ? \n"
                + "  ORDER BY RequestID\n"
                + "  OFFSET ? ROWS\n"
                + "  FETCH NEXT ? ROW ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 0);
            if (converSearch(search)) {
                st.setInt(1, Integer.parseInt(search));
            }
            String searchPattern = "%" + search + "%";
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);
             String statusPattern = "%" + status + "%";
            st.setString(4, statusPattern);
            int numOffSet = (page - 1) * disNum;
            st.setInt(5, numOffSet);
            st.setInt(6, disNum);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request curRequest = new Request();
                curRequest.setRequestId(rs.getInt("RequestID"));
                curRequest.setMentorId(rs.getInt("MentorID"));
                curRequest.setMenteeId(rs.getInt("MenteeID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setNote(rs.getString("Note"));

                Date createDateSql = rs.getDate("CreateDate");
                if (createDateSql != null) {
                    curRequest.setCreateDate(createDateSql.toLocalDate());
                }

                Date startDateSql = rs.getDate("StartDate");
                if (startDateSql != null) {
                    curRequest.setStartDate(startDateSql.toLocalDate());
                }

                Date endDateSql = rs.getDate("EndDate");
                if (endDateSql != null) {
                    curRequest.setEndDate(endDateSql.toLocalDate());
                }

                curRequest.setStatus(rs.getString("Status"));
                curRequest.setTitle(rs.getString("Title"));
                curRequest.setSkillId(rs.getInt("SkillID"));
                curRequest.setPrice(rs.getFloat("Price"));
                curRequest.setFramework(rs.getString("Framework"));

                listReq.add(curRequest);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }

        return listReq;
    }

    public static void main(String[] args) {
        RequestDAO act = new RequestDAO();
        List<Request> list = act.getRequestByStatusAndSearch("frobakt", "cancel");
        System.out.println(list.size());
    }
}
