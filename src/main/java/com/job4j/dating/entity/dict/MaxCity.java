package com.job4j.dating.entity.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="max_city")
public class MaxCity {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="country_id")
    private String countryId;

    @Column(name="region")
    private String region;

    @Column(name="city_name_en")
    private String cityNameEn;

    /*@Column(name="postalCode")
    private String postalCode;

    @Column(name="latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @Column(name="metroCode")
    private int metroCode;

    @Column(name="areaCode")
    private int areaCode;*/


    // Standart constructors, getters and setters.
    public MaxCity() {
    }

    public MaxCity(int id, String countryId, String region, String cityNameEn) { //, String postalCode) {
        this.id = id;
        this.countryId = countryId;
        this.region = region;
        this.cityNameEn = cityNameEn;
        //this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    /*public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }*/

}
