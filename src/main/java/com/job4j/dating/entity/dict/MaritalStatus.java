package com.job4j.dating.entity.dict;

import javax.persistence.*;

@Entity
@Table(name="marital_status")
public class MaritalStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="language")
    private String language;

    @Column(name="gender")
    private String gender;

    @Column(name="status_name")
    private String statusName;


    // Standart geters and setters
    public MaritalStatus() {
    }

    public MaritalStatus(int id, String language, String gender, String statusName) {
        this.id = id;
        this.language = language;
        this.gender = gender;
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}
