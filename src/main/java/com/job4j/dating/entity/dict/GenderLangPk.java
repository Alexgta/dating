package com.job4j.dating.entity.dict;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GenderLangPk implements Serializable {

    @Column(name = "marital_status_id")
    private int maritalStatusId;

    @Column(name = "language")
    private String language;

    @Column(name = "gender")
    private String gender;


    // Standart constructors, getters and setters.
    public GenderLangPk() {
    }

    public GenderLangPk(int marital_status_id, String language, String gender) {
        this.maritalStatusId = marital_status_id;
        this.language = language;
        this.gender = gender;
    }

    public int getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(int maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
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

    @Override
    public int hashCode() {
        return Objects.hash(getMaritalStatusId(), getLanguage(), getGender());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GenderLangPk)) return false;
        GenderLangPk that = (GenderLangPk) obj;
        return Objects.equals(getMaritalStatusId(), that.getMaritalStatusId()) &&
               Objects.equals(getGender(), that.getGender())  &&
               Objects.equals(getLanguage(), that.getLanguage());
    }

}
