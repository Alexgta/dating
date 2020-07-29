package com.job4j.dating.entity;

import javax.persistence.*;
import com.job4j.dating.entity.dict.MaritalStatus;

@Entity
@Table(name="ad")
public class Ad {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="ad_nickname")
    private String adNickname;

    @Column(name="marital_status_id")
    private int  maritalStatusId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marital_status_id", insertable = false, updatable = false)
    private MaritalStatus maritalStatus;


    // Standart constructors, geters and seters
    public Ad() {
    }

    public Ad(int customerId, String adNickname, int maritalStatusId, MaritalStatus maritalStatus) {
        this.customerId = customerId;
        this.adNickname = adNickname;
        this.maritalStatusId = maritalStatusId;
        this.maritalStatus = maritalStatus;
    }

    public Ad(String adNickname, int maritalStatusId, MaritalStatus maritalStatus) {
        this.adNickname = adNickname;
        this.maritalStatusId = maritalStatusId;
        this.maritalStatus = maritalStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAdNickname() {
        return adNickname;
    }

    public void setAdNickname(String adNickname) {
        this.adNickname = adNickname;
    }

    public int getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(int maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

}
