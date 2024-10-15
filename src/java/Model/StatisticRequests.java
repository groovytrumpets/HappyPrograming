/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author asus
 */
public class StatisticRequests {

    private String title;
    private int totalRequests;
    private int totalHours;
    private int totalMentors;

    public StatisticRequests(String title, int totalRequests, int totalHours, int totalMentors) {
        this.title = title;
        this.totalRequests = totalRequests;
        this.totalHours = totalHours;
        this.totalMentors = totalMentors;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public int getTotalMentors() {
        return totalMentors;
    }
}
