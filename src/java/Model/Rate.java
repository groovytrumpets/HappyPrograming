/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Rate {
    /*[MentorID] [int] NULL,
	[MenteeID] [int] NULL,
	[CreateDate] [date] NULL,
	[status] [nvarchar](20) NULL,
	[Comment] [varchar](max) NULL,
	[Rate] [int] NULL*/
    private int mentorId,menteeId;
    private Date createDate;
    private String status,comment;
    private int rate;

    public Rate() {
    }

    public Rate(int mentorId, int menteeId, Date createDate, String Status, String comment, int rate) {
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.createDate = createDate;
        this.status = Status;
        this.comment = comment;
        this.rate = rate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    
}
