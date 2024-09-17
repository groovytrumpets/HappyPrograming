/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nhhag
 */
import java.util.Date;

public class Skill {

    private int skillId;
    private String skillName;
    private Date createDate;
    private String description;
    private String status;
    private String img;

    // Constructors
    public Skill() {}

    public Skill(int skillId, String skillName, Date createDate, String description, String status, String img) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.createDate = createDate;
        this.description = description;
        this.status = status;
        this.img = img;
    }

    // Getters and Setters
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    // Optionally, override toString() method to represent the object as a string
    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

