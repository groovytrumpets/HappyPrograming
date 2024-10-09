/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CV;
import Model.Mentor;
import Model.Rate;
import Model.Skill;
import Model.SkillList;
import Model.StatisticSkills;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class CVDAO extends DBContext {

    public Mentor getMentorByID(int id) {
        //lenh sql select * from categories cach 1:
        String sql = "select*from [dbo].[Mentor] where MentorID =?;";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Mentor mentor = new Mentor(rs.getInt("mentorId"), rs.getInt("roleId"),
                        rs.getString("username"),
                        rs.getDate("createDate"),
                        rs.getString("phone"), rs.getString("address"),
                        rs.getDate("dateOfBirth"), rs.getString("fullName"),
                        rs.getString("gender"), rs.getString("status"));
                return mentor;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public CV getCVbyMentorId(int id) {
        //lenh sql select * from categories cach 1:
        String sql = "select*from [dbo].[CV] where MentorID =? and Status='active';";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CV cv = new CV(rs.getInt("cvId"), rs.getInt("mentorId"),
                        rs.getString("education"), rs.getString("experience"),
                        rs.getString("activity"), rs.getString("professionIntroduction"),
                        rs.getString("certificate"), rs.getDate("createDate"),
                        rs.getString("jobProfession"), rs.getInt("yearOfExperience"),
                        rs.getString("serviceDescription"), rs.getString("status"),
                        rs.getString("framework"), rs.getBytes("avatar"),rs.getFloat("price"));
                return cv;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    public CV getCVbyCVId(int id) {
        //lenh sql select * from categories cach 1:
        String sql = "select*from [dbo].[CV] where CVID =?;";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CV cv = new CV(rs.getInt("cvId"), rs.getInt("mentorId"),
                        rs.getString("education"), rs.getString("experience"),
                        rs.getString("activity"), rs.getString("professionIntroduction"),
                        rs.getString("certificate"), rs.getDate("createDate"),
                        rs.getString("jobProfession"), rs.getInt("yearOfExperience"),
                        rs.getString("serviceDescription"), rs.getString("status"),
                        rs.getString("framework"), rs.getBytes("avatar"),rs.getFloat("price"));
                return cv;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    public List<CV> getListofCVbyMentorId(int id) {
        List<CV> cvList = new ArrayList<>();
        //lenh sql select * from categories cach 1:
        String sql = "select*from CV where MentorID=?;";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CV cv = new CV(rs.getInt("cvId"), rs.getInt("mentorId"),
                        rs.getString("education"), rs.getString("experience"),
                        rs.getString("activity"), rs.getString("professionIntroduction"),
                        rs.getString("certificate"), rs.getDate("createDate"),
                        rs.getString("jobProfession"), rs.getInt("yearOfExperience"),
                        rs.getString("serviceDescription"), rs.getString("status"),
                        rs.getString("framework"), rs.getBytes("avatar"),rs.getFloat("price"));
                cvList.add(cv);

            }
                return cvList;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    

    public void updateMentor(Mentor c) {
        String sql = "UPDATE [dbo].[Mentor]\n"
                + "   SET [Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[DateOfBirth] = ?\n"
                + "      ,[FullName] = ?\n"
                + "      ,[Gender] = ?\n"
                + " WHERE MentorID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getPhone());
            st.setString(2, c.getAddress());
            java.sql.Date sqlDob = new java.sql.Date(c.getDateOfBirth().getTime());
            st.setDate(3, sqlDob);
            st.setString(4, c.getFullName());
            st.setString(5, c.getGender());
            st.setInt(6, c.getMentorId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCV(CV c,int cvid) {
        String sql = "UPDATE [dbo].[CV]\n"
                + "   SET [Education] = ?\n"
                + "      ,[Experience] = ?\n"
                + "      ,[Activity] = ?\n"
                + "      ,[ProfessionIntroduction] = ?,[CreateDate] = GETDATE()\n"
                + "      ,[JobProfession] = ?\n"
                + "      ,[ServiceDescription] = ?\n"
                + "      ,[Framework] = ?,[Avatar] =?, [Price] =?\n"
                + " WHERE [CVID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getEducation());
            st.setString(2, c.getExperience());
            st.setString(3, c.getActivity());
            st.setString(4, c.getProfessionIntroduction());
            st.setString(5, c.getJobProfession());
            st.setString(6, c.getServiceDescription());
            st.setString(7, c.getFramework());
            st.setBytes(8, c.getAvatar());
            st.setFloat(9, c.getPrice());
            st.setInt(10, cvid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void updateUser(String userid, String username, String email) {
        String sql = "update [User] set Username=?,Email=? where Username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, email);
            st.setString(3, userid);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<StatisticSkills> getMentorSkillList(int id) {
        List<StatisticSkills> list = new ArrayList<>();
        String sql = "select s.SkillID,s.SkillName,sl.Rating from Skill s join SkillList sl on s.SkillID=sl.SkillID where MentorID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                StatisticSkills skillStats = new StatisticSkills(rs.getInt("skillId"),
                        rs.getString("skillName"), rs.getInt("rating"));
                list.add(skillStats);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging
        }
        return list;
    }
    
    
    public List<Skill> getMentorSkillListByMentorID(int id) {
        List<Skill> list = new ArrayList<>();
        String sql = "select s.SkillID,s.SkillName from Skill s join SkillList sl on s.SkillID=sl.SkillID where MentorID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Skill skill = new Skill(rs.getInt("skillId"),
                        rs.getString("skillName"));
                list.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging
        }
        return list;
    }

    public List<Skill> getSkillList(int id) {
        List<Skill> list = new ArrayList<>();
        String sql = "select s.SkillID,s.SkillName from Skill s left join SkillList sl on s.SkillID=sl.SkillID and sl.MentorID = ?\n"
                + "where sl.SkillID is null;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Skill skillName = new Skill(rs.getInt("skillId"), rs.getString("skillName"));
                list.add(skillName);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging
        }
        return list;
    }

    public void deleteMentorSkills(int MentorId, String[] deleteSkills) {
        String sql = "delete from SkillList where MentorID =? and SkillID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            for (String i : deleteSkills) {
                st.setInt(1, MentorId);
                st.setInt(2, Integer.parseInt(i));
                st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertMentorSkills(int MentorId, String[] addSkills) {
        String sql = "INSERT INTO [dbo].[SkillList]\n"
                + "           ([SkillID]\n"
                + "           ,[MentorID]\n"
                + "           ,[Rating])\n"
                + "     VALUES\n"
                + "           (?,?,null)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            for (String addSkill : addSkills) {

                st.setInt(1, Integer.parseInt(addSkill));
                st.setInt(2, MentorId);
                st.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public String getUserEmail(int MentorId) {
        String sql = "select * from [User] u join Mentor m on u.Username=m.Username where MentorID = ?";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, MentorId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("Email");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public boolean checkDuplicateEmail(String email, String username) {
        String sql = "select Status,Username,Email from [User] where Email = ?";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if ((!username.equalsIgnoreCase(rs.getString("Username"))
                        && !email.isEmpty() || rs.getString("Status").equalsIgnoreCase("inactive"))) {
                    return true; // email exsist
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public void createCV(CV cv) {
        String sql = "INSERT INTO [dbo].[CV]\n"
                + "           ([MentorID]\n"
                + "           ,[Education]\n"
                + "           ,[Experience]\n"
                + "           ,[Activity]\n"
                + "           ,[ProfessionIntroduction]\n"
                + "           ,[Certificate]\n"
                + "           ,[CreateDate]\n"
                + "           ,[JobProfession]\n"
                + "           ,[ServiceDescription]\n"
                + "           ,[Status]\n"
                + "           ,[Framework]\n"
                + "           ,[Avatar],[Price])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,GETDATE(),?,?,'inactive',?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cv.getMentorId());
            st.setString(2, cv.getEducation());
            st.setString(3, cv.getExperience());
            st.setString(4, cv.getActivity());
            st.setString(5, cv.getProfessionIntroduction());
            st.setString(6, cv.getCertificate());
            st.setString(7, cv.getJobProfession());
            st.setString(8, cv.getServiceDescription());
            st.setString(9, cv.getFramework());
            st.setBytes(10, cv.getAvatar());
            st.setFloat(11, cv.getPrice());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    

    public List<Rate> getMentorRateList(int id) {
        List<Rate> list = new ArrayList<>();
        String sql = "select * from Rate where MentorID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Rate rate = new Rate(rs.getInt("mentorId"), rs.getInt("menteeId"),
                        rs.getDate("createDate"), rs.getString("status"),
                        rs.getString("comment"), rs.getInt("rate"));
                list.add(rate);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging

        }
        return list;
    }

    public List<CV> getMostEficientCV() {
        List<CV> listCV = new ArrayList<>();
        String sql = "WITH RankedCVs AS (\n"
                + "    SELECT CV.[CVID],\n"
                + "           CV.[MentorID],\n"
                + "           CV.[Education],\n"
                + "           CV.[Experience],\n"
                + "           CV.[Activity],\n"
                + "           CV.[ProfessionIntroduction],\n"
                + "           CV.[Certificate],\n"
                + "           CV.[CreateDate],\n"
                + "           CV.[JobProfession],\n"
                + "           CV.[YearOfExperience],\n"
                + "           CV.[ServiceDescription],\n"
                + "           CV.[Status],\n"
                + "           CV.[Framework],\n"
                + "           CV.[Avatar],\n"
                + "           ROW_NUMBER() OVER (PARTITION BY CV.[MentorID] \n"
                + "                              ORDER BY \n"
                + "                                CASE WHEN CV.[Status] = 'Active' THEN 1 ELSE 2 END,  -- prioritize active CVs\n"
                + "                                CV.[CreateDate] DESC  -- then by newest date\n"
                + "                             ) AS rn\n"
                + "    FROM [dbo].[CV]\n"
                + ")\n"
                + "SELECT m.[MentorID],\n"
                + "       r.[CVID],\n"
                + "       r.[Education],\n"
                + "       r.[Experience],\n"
                + "       r.[Activity],\n"
                + "       r.[ProfessionIntroduction],\n"
                + "       r.[Certificate],\n"
                + "       r.[CreateDate],\n"
                + "       r.[JobProfession],\n"
                + "       r.[YearOfExperience],\n"
                + "       r.[ServiceDescription],\n"
                + "       r.[Status],\n"
                + "       r.[Framework],\n"
                + "       r.[Avatar]\n"
                + "FROM [dbo].[Mentor] m\n"
                + "LEFT JOIN RankedCVs r\n"
                + "  ON m.[MentorID] = r.[MentorID] AND r.rn = 1;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CV curCV = new CV();
                curCV.setMentorId(rs.getInt("MentorID"));
                curCV.setCvId(rs.getInt("CVID"));
                curCV.setEducation(rs.getString("Education"));
                curCV.setExperience(rs.getString("Experience"));
                curCV.setActivity(rs.getString("Activity"));
                curCV.setProfessionIntroduction(rs.getString("ProfessionIntroduction"));
                curCV.setCertificate(rs.getString("Certificate"));
                
                curCV.setCreateDate(rs.getString("CreateDate"));
                curCV.setJobProfession(rs.getString("JobProfession"));
                curCV.setYearOfExperience(rs.getInt("YearOfExperience"));
                curCV.setServiceDescription(rs.getString("ServiceDescription"));
                curCV.setStatus(rs.getString("Status"));
                curCV.setFramework(rs.getString("Framework"));
                byte[] avatar = rs.getBytes("Avatar");
                if (avatar != null) {
                    curCV.setAvatar(rs.getBytes("Avatar"));
                }
                listCV.add(curCV);

            }
        } catch (SQLException e) {
        }
        return listCV;
    }

    public List<Rate> getRateList() {
        List<Rate> list = new ArrayList<>();
        String sql = "select * from Rate";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Rate rate = new Rate(rs.getInt("mentorId"), rs.getInt("menteeId"),
                        rs.getDate("createDate"), rs.getString("status"),
                        rs.getString("comment"), rs.getInt("rate"));
                list.add(rate);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging

        }
        return null;
    }

    public int getAveRatebyId(int id) {
        String sql = "select Avg(Rate) from Rate where MentorID =?;";
        //cach 2: vao sql phai chuot vao bang chon scriptable as
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }
   public static void main(String[] args) {
        CVDAO c = new CVDAO();
        System.out.println(c.getCVbyMentorId(7));
    }

    public void deleteCV(int id) {

        String sql = "delete from CV where CVID =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    
    }
}
