package com.job4j.dating.entity.dict;

import javax.persistence.*;

@Entity
@Table(name="max_country")
public class MaxCountry {

    @EmbeddedId
    private PkLanguageIdString pkLanguageIdString;

    @Column(name="country_name")
    private String countryName;

    @Column(name="id", insertable = false, updatable = false)
    private String id;

    @Column(name="language", insertable = false, updatable = false)
    private String language;


    // Standart geters and setters
    public MaxCountry() {
    }

    public MaxCountry(PkLanguageIdString pkLanguageIdString, String countryName, String id, String language) {
        this.pkLanguageIdString = pkLanguageIdString;
        this.countryName = countryName;
        this.id = id;
        this.language = language;
    }

    public PkLanguageIdString getPkLanguageIdString() {
        return pkLanguageIdString;
    }

    public void setPkLanguageIdString(PkLanguageIdString pkLanguageIdString) {
        this.pkLanguageIdString = pkLanguageIdString;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

}
