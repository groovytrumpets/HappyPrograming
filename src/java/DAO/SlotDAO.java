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

    public static void main(String[] args) {
        SlotDAO s = new SlotDAO();
        System.out.println(s.getSlotsById(1));
    }
}
