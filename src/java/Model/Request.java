/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nhhag
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Request {

    private int requestId;
    private Integer mentorId;
    private Integer menteeId;
    private Float price;
    private String note;
    private LocalDate createDate;
    private String status;
    private String title;
    private LocalTime deadlineHour;
    private LocalDate deadlineDate;
    private String framework;

    public Request() {
    }

    public Request(int requestId, Integer mentorId, Integer menteeId, Float price, String note, LocalDate createDate,
            String status, String title, LocalTime deadlineHour, LocalDate deadlineDate, String framework) {
        this.requestId = requestId;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.price = price;
        this.note = note;
        this.createDate = createDate;
        this.status = status;
        this.title = title;
        this.deadlineHour = deadlineHour;
        this.deadlineDate = deadlineDate;
        this.framework = framework;
    }

    @Override
    public String toString() {
        return "Request{" + "requestId=" + requestId + ", mentorId=" + mentorId + ", menteeId=" + menteeId + ", price=" + price + ", note=" + note + ", createDate=" + createDate + ", status=" + status + ", title=" + title + ", deadlineHour=" + deadlineHour + ", deadlineDate=" + deadlineDate + ", framework=" + framework + '}';
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public Integer getMenteeId() {
        return menteeId;
    }

    public void setMenteeId(Integer menteeId) {
        this.menteeId = menteeId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDeadlineHour() {
        return deadlineHour;
    }

    public void setDeadlineHour(LocalTime deadlineHour) {
        this.deadlineHour = deadlineHour;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
}


