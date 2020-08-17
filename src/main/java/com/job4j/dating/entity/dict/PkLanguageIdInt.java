package com.job4j.dating.entity.dict;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PkLanguageIdInt implements Serializable {

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "language")
    private String language;


    // Standart geters and setters
    public PkLanguageIdInt() {
    }

    public PkLanguageIdInt(int cityId, String language) {
        this.cityId = cityId;
        this.language = language;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityId(), getLanguage());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PkLanguageIdInt)) return false;
        PkLanguageIdInt that = (PkLanguageIdInt) obj;
        return Objects.equals(getCityId(), that.getCityId()) &&
               Objects.equals(getLanguage(), that.getLanguage());
    }


}
