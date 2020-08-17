package com.job4j.dating.entity.dict;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PkLanguageIdString implements Serializable {

    @Column(name = "id")
    private String id;

    @Column(name = "language")
    private String language;


    // Standart geters and setters
    public PkLanguageIdString() {
    }

    public PkLanguageIdString(String id, String language) {
        this.id = id;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLanguage());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PkLanguageIdString)) return false;
        PkLanguageIdString that = (PkLanguageIdString) obj;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getLanguage(), that.getLanguage());
    }


}
