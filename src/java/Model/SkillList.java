/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nhhag
 */
public class SkillList {

    private int id;
    private int skillId;
    private int userId;
    private int rating;

    // Constructors
    public SkillList() {}

    public SkillList(int id, int skillId, int userId, int rating) {
        this.id = id;
        this.skillId = skillId;
        this.userId = userId;
        this.rating = rating;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Optionally, override toString() method to represent the object as a string
    @Override
    public String toString() {
        return "SkillList{" +
                "id=" + id +
                ", skillId=" + skillId +
                ", userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}

