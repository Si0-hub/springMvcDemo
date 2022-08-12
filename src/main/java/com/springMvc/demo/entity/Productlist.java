package com.springMvc.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Productlist")
public class Productlist {
    @Column(name = "PKNO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkno;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASEDATE")
    private String releasedate;
    @Column(name = "DEADLINEDATE")
    private String deadlinedate;
    @Column(name = "ANNOUNCER")
    private String announcer;
    @Column(name = "ANNOUNCEMENT")
    private String announcement;

    public Productlist() {}
    public Productlist(String title, String releasedate, String deadlinedate, String announcer, String announcement) {
        this.title = title;
        this.releasedate = releasedate;
        this.deadlinedate = deadlinedate;
        this.announcer = announcer;
        this.announcement = announcement;
    }



    public Integer getPkno() {
        return pkno;
    }

    public void setPkno(Integer pkno) {
        this.pkno = pkno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getDeadlinedate() {
        return deadlinedate;
    }

    public void setDeadlinedate(String deadlinedate) {
        this.deadlinedate = deadlinedate;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    @Override
    public String toString() {
        return "Productlist{" +
                "pkno=" + pkno +
                ", title='" + title + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", deadlinedate='" + deadlinedate + '\'' +
                ", announcer='" + announcer + '\'' +
                ", announcement='" + announcement + '\'' +
                '}';
    }
}
