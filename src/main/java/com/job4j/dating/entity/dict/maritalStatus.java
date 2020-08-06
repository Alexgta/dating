package com.job4j.dating.entity.dict;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="marital_status")
public class MaritalStatus implements Serializable {

    @EmbeddedId
    private GenderLangPk genderLangPk;

    @Column(name="status_name")
    private String statusName;

    // Standart geters and setters
    public MaritalStatus() {
    }

    public MaritalStatus(GenderLangPk genderLangPk, String statusName) {
        this.genderLangPk = genderLangPk;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
