/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Slot;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author nhhag
 */
public class SlotDAO extends DBContext {

    public List<Slot> getSlotsByMentorId(int mentorId) {
        List<Slot> slots = new ArrayList<>();
        String sql = "SELECT SlotID, MentorID, StartTime, EndTime, DayInWeek, Status FROM Slot WHERE MentorID = ? "
                + "ORDER BY CASE DayInWeek "
                + "WHEN 'Monday' THEN 1 "
                + "WHEN 'Tuesday' THEN 2 "
                + "WHEN 'Wednesday' THEN 3 "
                + "WHEN 'Thursday' THEN 4 "
                + "WHEN 'Friday' THEN 5 "
                + "WHEN 'Saturday' THEN 6 "
                + "WHEN 'Sunday' THEN 7 "
                + "ELSE 8 END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mentorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int slotId = resultSet.getInt("SlotID");
                LocalTime startTime = resultSet.getTime("StartTime").toLocalTime();
                LocalTime endTime = resultSet.getTime("EndTime").toLocalTime();
                String dayInWeek = resultSet.getString("DayInWeek");
                String status = resultSet.getString("Status");

                Slot slot = new Slot(slotId, mentorId, startTime, endTime, dayInWeek, status);
                slots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slots;
    }

    public Slot getSlotsById(int Id) {
        String sql = "SELECT SlotID, MentorID, StartTime, EndTime, DayInWeek, Status FROM Slot WHERE SlotID = ? ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int slotId = rs.getInt("SlotID");
                LocalTime startTime = rs.getTime("StartTime").toLocalTime();
                LocalTime endTime = rs.getTime("EndTime").toLocalTime();
                String dayInWeek = rs.getString("DayInWeek");
                String status = rs.getString("Status");
                int mentorId = rs.getInt("mentorID");

                Slot slot = new Slot(slotId, mentorId, startTime, endTime, dayInWeek, status);
                return slot;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Slot> getSlotByRequestId(int requestId) {
        List<Slot> listSlot = new ArrayList<>();
        String sql = "SELECT s.[SlotID]\n"
                + "      ,[MentorID]\n"
                + "      ,[StartTime]\n"
                + "      ,[EndTime]\n"
                + "      ,[DayInWeek]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[Slot]  s \n"
                + "right join RequestSlotItem rs \n"
                + "on s.SlotID = rs.SlotID\n"
                + "where rs.RequestID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, requestId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int slotId = resultSet.getInt("SlotID");
                LocalTime startTime = resultSet.getTime("StartTime").toLocalTime();
                LocalTime endTime = resultSet.getTime("EndTime").toLocalTime();
                String dayInWeek = resultSet.getString("DayInWeek");
                String status = resultSet.getString("Status");

                Slot slot = new Slot(slotId, requestId, startTime, endTime, dayInWeek, status);
                listSlot.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSlot;
    }

    public List<Slot> getSlotInDate(LocalDate start, LocalDate end, int requestID) {
        List<Slot> listSlot = new ArrayList<>();
        String sql = "SELECT \n"
                + "    s.[SlotID],\n"
                + "    s.[MentorID],\n"
                + "    [StartTime],\n"
                + "    [EndTime],\n"
                + "    [DayInWeek],\n"
                + "    s.[Status],\n"
                + "    r.StartDate,\n"
                + "    r.EndDate\n"
                + "FROM \n"
                + "    [dbo].[Slot] s \n"
                + "RIGHT JOIN \n"
                + "    RequestSlotItem rs ON s.SlotID = rs.SlotID \n"
                + "RIGHT JOIN \n"
                + "    Request r ON r.RequestID = rs.RequestID\n"
                + "WHERE \n"
                + "    rs.RequestID = ?\n"
                + "    AND (r.StartDate <= ? \n"
                + "    AND r.EndDate >= ?)\n"
                + "ORDER BY \n"
                + "    s.StartTime ASC;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, requestID);
            preparedStatement.setDate(2, java.sql.Date.valueOf(start));
            preparedStatement.setDate(3, java.sql.Date.valueOf(end));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int slotId = resultSet.getInt("SlotID");
                LocalTime startTime = resultSet.getTime("StartTime").toLocalTime();
                LocalTime endTime = resultSet.getTime("EndTime").toLocalTime();
                String dayInWeek = resultSet.getString("DayInWeek");
                String status = resultSet.getString("Status");

                Slot slot = new Slot(slotId, requestID, startTime, endTime, dayInWeek, status);
                listSlot.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework instead
        }
        return listSlot;
    }

    public static void main(String[] args) {
        SlotDAO slotDAO = new SlotDAO();

        // Correcting the date initialization using LocalDate.of()
        LocalDate start = LocalDate.of(2022, 1, 7); // Start date: January 7, 2022
        LocalDate end = LocalDate.of(2022, 1, 8);   // End date: January 8, 2022

        // Fetching slots in the given date range for request ID 1
        List<Slot> slots = slotDAO.getSlotInDate(start, end, 1);

        // Printing the fetched slots
        // Assuming getSlotsById is a method that retrieves slots by request ID
        System.out.println(slots.get(3).getDayInWeek());
    }
}
