/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Skill;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author tuong
 */
public class SkillDAO extends DBContext {

    public boolean insertNewSkill(Skill newSkill) {
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
            rs.setBytes(5, newSkill.getImg());
            rs.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Skill> getListOfAllSkill() {
        List<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT [SkillID]\n"
                + "      ,[SkillName]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Description]\n"
                + "      ,[Status]\n"
                + "      ,[img]\n"
                + "  FROM [dbo].[Skill]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                listSkill.add(curSkill);
            }
        } catch (Exception e) {
        }

        return listSkill;
    }

    public List<Skill> getListOfSkillPaging(int page, int numShow) {
        List<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT [SkillID]\n"
                + "      ,[SkillName]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Description]\n"
                + "      ,[Status]\n"
                + "      ,[Img]\n"
                + "  FROM [dbo].[Skill]\n"
                + "  order by Skill.SkillID asc\n"
                + "offset ? rows\n"
                + "fetch next ? row only";
        int start = (page - 1) * numShow;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, start);
            st.setInt(2, numShow);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                listSkill.add(curSkill);
            }
        } catch (Exception e) {
        }
        return listSkill;
    }

    public void deleteSkillById(int skillId) {
        String sql = "DELETE FROM [dbo].[Skill]\n"
                + "      WHERE SkillID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, skillId);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Skill getSkillById(int skillId) {
        String sql = "SELECT [SkillID]\n"
                + "      ,[SkillName]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Description]\n"
                + "      ,[Status]\n"
                + "      ,[Img]\n"
                + "  FROM [dbo].[Skill]\n"
                + "  where SkillID=?";
        Skill curSkill = new Skill();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, skillId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                curSkill.setSkillId(Integer.parseInt(id_raw));
                curSkill.setSkillName(rs.getString("SkillName"));
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                curSkill.setCreateDate(date);
                curSkill.setDescription(rs.getString("Description"));
                curSkill.setStatus(rs.getString("Status"));
                curSkill.setImg(rs.getBytes("Img"));
            }
        } catch (Exception e) {
        }
        return curSkill;
    }

    public boolean updateSkillInfo(Skill updateSkill) {
        String sql = "UPDATE [dbo].[Skill]\n"
                + "   SET [SkillName] =?\n"
                + "      ,[CreateDate] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[Status] =?\n"
                + "      ,[Img] = ?\n"
                + " WHERE SkillID=?";
        try {
            PreparedStatement rs = connection.prepareStatement(sql);
            rs.setString(1, updateSkill.getSkillName());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String curTime = dtf.format(now);
            rs.setString(2, curTime);
            rs.setString(3, updateSkill.getDescription());
            rs.setString(4, updateSkill.getStatus());
            rs.setBytes(5, updateSkill.getImg());
            rs.setInt(6, updateSkill.getSkillId());
            rs.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Skill> getListOfSkillByName(String skillName) {
        List<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT [SkillID], \n"
                + "       [SkillName], \n"
                + "       [CreateDate], \n"
                + "       [Description], \n"
                + "       [Status], \n"
                + "       [Img]\n"
                + "FROM [dbo].[Skill]\n"
                + "WHERE [SkillName] Like ?\n"
                + "ORDER BY [SkillID] ASC;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" +skillName + "%");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                listSkill.add(curSkill);
            }
        } catch (Exception e) {
        }
        return listSkill;
    }
    public List<Skill> getListOfSkillByDate() {
        List<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT Top 3 [SkillID], \n"
                + "       [SkillName], \n"
                + "       [CreateDate], \n"
                + "       [Description], \n"
                + "       [Status], \n"
                + "       [Img]\n"
                + "FROM [dbo].[Skill]\n"
                + "ORDER BY [CreateDate] Desc;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                listSkill.add(curSkill);
            }
        } catch (Exception e) {
        }
        return listSkill;
    }
    public List<Skill> getListOfSkillByNameDifID(String skillName, int skillID) {
        List<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT [SkillID]\n"
                + "      ,[SkillName]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Description]\n"
                + "      ,[Status]\n"
                + "      ,[Img]\n"
                + "  FROM [dbo].[Skill] where SkillName = ?  and SkillID !=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, skillName);
            st.setInt(2, skillID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                listSkill.add(curSkill);
            }
        } catch (Exception e) {
        }
        return listSkill;
    }
    public Skill getSkillByNameID(String skillName, int skillID) {
        String sql = "SELECT [SkillID]\n"
                + "      ,[SkillName]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Description]\n"
                + "      ,[Status]\n"
                + "      ,[Img]\n"
                + "  FROM [dbo].[Skill] where SkillName = ?  and SkillID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, skillName);
            st.setInt(2, skillID);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                return curSkill;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Skill> getListOfSkillByNamePagination(int page, int numShow, String skillName) {
        List<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT [SkillID]\n"
                + "      ,[SkillName]\n"
                + "      ,[CreateDate]\n"
                + "      ,[Description]\n"
                + "      ,[Status]\n"
                + "      ,[Img]\n"
                + "  FROM [dbo].[Skill]\n"
                + "  WHERE [SkillName] LIKE '%' + ? + '%' \n"
                + "  order by SkillID asc\n"
                + "  offset ? row \n"
                + "  fetch next ? row only";
        int start = (page - 1) * numShow;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, skillName);
            st.setInt(2, start);
            st.setInt(3, numShow);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id_raw = rs.getString("SkillID");
                int id = Integer.parseInt(id_raw);
                String name = rs.getString("SkillName");
                String date_raw = rs.getString("CreateDate");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formater.parse(date_raw);
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                byte[] img = rs.getBytes("img");
                Skill curSkill = new Skill(id, name, date, description, status, img);
                listSkill.add(curSkill);
            }
        } catch (Exception e) {
        }
        return listSkill;
    }

    public static void main(String[] args) {
        SkillDAO act = new SkillDAO();
        List<Skill> list = act.getListOfSkillByName("a");
        System.out.println(list.get(1).getSkillName());
        
    }
}
