/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Attendance;
import Model.Slot;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;

/**
 *
 * @author tuong
 */
public class AttendanceDAO extends DBContext {

    public List<Attendance> getSchduleByMentorID(int mentorID, LocalDate start, LocalDate end) {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT a.[AttendID]\n"
                + "      ,r.[RequestID]\n"
                + "      ,a.[slotDate]\n"
                + "      ,a.[Status]\n"
                + "      ,r.[MenteeID]\n"
                + "      ,s.[StartTime]\n"
                + "      ,s.[EndTime]\n"
                + "      ,r.[Title]\n"
                + "      ,s.[DayInWeek]\n"
                + "  FROM [dbo].[Attendance] a\n"
                + "  LEFT JOIN [RequestSlotItem] rs ON a.[RequestSlotItem] = rs.[RequestSlotItem]\n"
                + "  LEFT JOIN [Slot] s ON s.[SlotID] = rs.[SlotID]\n"
                + "  LEFT JOIN [Request] r ON r.[RequestID] = rs.[RequestID]\n"
                + "  WHERE r.[MentorID] = ? \n"
                + "    AND a.[slotDate] BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mentorID);
            preparedStatement.setDate(2, java.sql.Date.valueOf(start));
            preparedStatement.setDate(3, java.sql.Date.valueOf(end));
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Attendance curAttend = new Attendance();
                curAttend.setAttendID(rs.getInt("AttendID"));
                curAttend.setRequestID(rs.getInt("RequestID"));
                curAttend.setDate(rs.getDate("slotDate").toLocalDate());
                LocalTime startTime = rs.getTime("StartTime").toLocalTime();
                LocalTime endTime = rs.getTime("EndTime").toLocalTime();
                curAttend.setStartTime(startTime);
                curAttend.setEndTime(endTime);
                curAttend.setStatus(rs.getString("Status"));
                curAttend.setTitle(rs.getString("Title"));
                curAttend.setDayInWeek(rs.getString("DayInWeek"));
                curAttend.setMenteeID(rs.getInt("MenteeID"));
                list.add(curAttend);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean updateStatusAttendance(int attendID, String status) {
        boolean updateSuccess = true;
        String sql = "UPDATE [dbo].[Attendance]\n"
                + "   SET [Status] = ?\n"
                + " WHERE AttendID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(2, attendID);
            st.setString(1, status);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Attendance> getAllSlotOfRequest(int requestID) {
        List<Attendance> list = new ArrayList<>();
        String sql = "select rs.RequestSlotItem,s.DayInWeek \n"
                + "from Slot s \n"
                + "left join RequestSlotItem rs on s.SlotID = rs.SlotID\n"
                + "left join Request r on rs.RequestID = r.RequestID\n"
                + "WHERE r.RequestID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, requestID);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Attendance curAttend = new Attendance();
                curAttend.setRequestSlotItem(rs.getInt("RequestSlotItem"));
                curAttend.setDayInWeek(rs.getString("DayInWeek"));
                list.add(curAttend);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean addAttendance(Attendance curAttendance) {
        String sql = "INSERT INTO [dbo].[Attendance]\n"
                + "           ([RequestSlotItem]\n"
                + "           ,[slotDate]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1 , curAttendance.getRequestSlotItem());
            st.setDate(2, Date.valueOf(curAttendance.getDate()));
            st.setString(3, curAttendance.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        AttendanceDAO act = new AttendanceDAO();
        LocalDate start = LocalDate.parse("2024-10-21");
        LocalDate end = LocalDate.parse("2024-10-27");
        List<Attendance> list = act.getSchduleByMentorID(2, start, end);
        System.out.println(list.get(0).getMenteeID());
    }
}
