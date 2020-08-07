package com.job4j.dating.entity.dict;

import com.job4j.dating.entity.Ad;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="marital_status")
public class MaritalStatus { // implements Serializable {

    @EmbeddedId
    private GenderLangPk genderLangPk;

    @Column(name="language", insertable = false, updatable = false)
    private String language;

    @Column(name="gender", insertable = false, updatable = false)
    private String gender;

    @Column(name="status_name")
    private String statusName;

    // Standart geters and setters
    public MaritalStatus() {
    }

    public MaritalStatus(GenderLangPk genderLangPk, String language, String gender, String statusName) {
        this.genderLangPk = genderLangPk;
        this.language = language;
        this.gender = gender;
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "statusName='" + statusName;
    }

    public GenderLangPk getGenderLangPk() {
        return genderLangPk;
    }

    public void setGenderLangPk(GenderLangPk genderLangPk) {
        this.genderLangPk = genderLangPk;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
