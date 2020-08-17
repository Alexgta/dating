package com.job4j.dating.entity.dict;

import javax.persistence.*;

@Entity
@NamedQuery(name = "MaxCityName.findByCityNameStart",
        query = "SELECT nm FROM MaxCityName nm, MaxCity ct WHERE nm.cityId = ct.id AND ct.countryId = :countryId " +
                "AND nm.cityName like :cityNameStart AND nm.language = :language")
@Table(name="max_city_name")
public class MaxCityName {

    @EmbeddedId
    private PkLanguageIdInt pkLanguageIdInt;

    @Column(name="city_id", insertable = false, updatable = false)
    private int cityId;

    @Column(name="language", insertable = false, updatable = false)
    private String language;

    @Column(name="city_name")
    private String cityName;

    // Standart constructors, getters and setters.
    public MaxCityName() {
    }

    public MaxCityName(PkLanguageIdInt pkLanguageIdInt, int cityId, String language, String cityName) {
        this.pkLanguageIdInt = pkLanguageIdInt;
        this.cityId = cityId;
        this.language = language;
        this.cityName = cityName;
    }

    public PkLanguageIdInt getPkIntLanguage() {
        return pkLanguageIdInt;
    }

    public void setPkIntLanguage(PkLanguageIdInt pkLanguageIdInt) {
        this.pkLanguageIdInt = pkLanguageIdInt;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public PkLanguageIdInt getPkLanguageIdInt() {
        return pkLanguageIdInt;
    }

    public void setPkLanguageIdInt(PkLanguageIdInt pkLanguageIdInt) {
        this.pkLanguageIdInt = pkLanguageIdInt;
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

}
