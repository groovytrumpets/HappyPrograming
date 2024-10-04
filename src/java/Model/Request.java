/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author tuong
 */
public class Request {
//    [RequestID] [int] IDENTITY(1,1) NOT NULL,
//	[MentorID] [int] NULL,
//	[MenteeID] [int] NULL,
//	[Price] [float] NULL,
//	[Note] [varchar](max) NULL,
//	[CreateDate] [date] NULL,
//	[Status] [nvarchar](20) NULL,
//	[Title] [nvarchar](50) NULL,
//	[DeadlineHour] [time](7) NULL,
//	[DeadlineDate] [date] NULL,
//	[Framework] [nvarchar](30) NULL,
    private int reqId,mentorId, menteeId;
    private float price;
    private String note, status, title, framework;
    private Date createDate, deadLineDate;
    private LocalTime deadlineHour;  

    public Request() {
    }

    public Request(int reqId, int mentorId, int menteeId, float price, String note, String status, String title, String framework, Date createDate, Date deadLineDate, LocalTime deadlineHour) {
        this.reqId = reqId;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.price = price;
        this.note = note;
        this.status = status;
        this.title = title;
        this.framework = framework;
        this.createDate = createDate;
        this.deadLineDate = deadLineDate;
        this.deadlineHour = deadlineHour;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getMenteeId() {
        return menteeId;
    }

    public void setMenteeId(int menteeId) {
        this.menteeId = menteeId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public LocalTime getDeadlineHour() {
        return deadlineHour;
    }

    public void setDeadlineHour(LocalTime deadlineHour) {
        this.deadlineHour = deadlineHour;
    }
    
}
