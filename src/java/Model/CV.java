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

public class CV {

    private int cvId;
    private int mentorId; // Assuming MentorID refers to a User
    private String education;
    private String experience;
    private String activity;
    private String professionIntroduction; // Renamed for clarity
    private String certificate;
    private Date createDate;
    private String jobProfession; // Renamed for clarity
    private int yearOfExperience; // Changed to INT for year representation
    private String serviceDescription;
    private String status;

    // Constructors
    public CV() {}

    public CV(int cvId, int mentorId, String education, String experience, String activity,
              String professionIntroduction, String certificate, Date createDate, String jobProfession,
              int yearOfExperience, String serviceDescription, String status) {
        this.cvId = cvId;
        this.mentorId = mentorId;
        this.education = education;
        this.experience = experience;
        this.activity = activity;
        this.professionIntroduction = professionIntroduction;
        this.certificate = certificate;
        this.createDate = createDate;
        this.jobProfession = jobProfession;
        this.yearOfExperience = yearOfExperience;
        this.serviceDescription = serviceDescription;
        this.status = status;
    }

    // Getters and Setters
    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getProfessionIntroduction() {
        return professionIntroduction;
    }

    public void setProfessionIntroduction(String professionIntroduction) {
        this.professionIntroduction = professionIntroduction;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getJobProfession() {
        return jobProfession;
    }

    public void setJobProfession(String jobProfession) {
        this.jobProfession = jobProfession;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Optionally, override toString() method to represent the object as a string
    @Override
    public String toString() {
        return "CV{" +
                "cvId=" + cvId +
                ", mentorId=" + mentorId +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", activity='" + activity + '\'' +
                ", professionIntroduction='" + professionIntroduction + '\'' +
                ", certificate='" + certificate + '\'' +
                ", createDate=" + createDate +
                ", jobProfession='" + jobProfession + '\'' +
                ", yearOfExperience=" + yearOfExperience +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

