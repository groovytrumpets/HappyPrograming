/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Skill;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author tuong
 */
public class DaoSkill extends DBContext {

    public void insertSkill(Skill newSkill) {
        String sql = "INSERT INTO [dbo].[Skill]\n"
                + "           ([SkillName]\n"
                + "           ,[CreateDate]\n"
                + "           ,[Description]\n"
                + "           ,[Status]\n"
                + "           ,[img])\n"
                + "     VALUES(?,?,?,?,?)";
        try {
            PreparedStatement rs = connection.prepareStatement(sql);
            rs.setString(1, newSkill.getSkillName());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String curTime = dtf.format(now);
            rs.setString(2, curTime);
            rs.setString(3, newSkill.getDescription());
            rs.setString(4, newSkill.getStatus());
            rs.setString(5, newSkill.getImg());
            rs.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DaoSkill act = new DaoSkill();
        Date now = new Date();
        Skill curSkill = new Skill(0, "skillName", now, "description", "status", "img");
        act.insertSkill(curSkill);
    }
}
