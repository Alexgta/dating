package com.job4j.dating.entity;



import com.job4j.dating.entity.dict.MaritalStatus;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="ad")
public class Ad {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="language")
    private String language;

    @Column(name="gender")
    private String gender;

    @Column(name="ad_nickname")
    private String adNickname;

    @Column(name="marital_status_id")
    private int maritalStatusId;


    /*@JoinColumn(name = "marital_status_id", referencedColumnName="id",  insertable = false, updatable = false)
    @AttributeOverrides({
            @AttributeOverride( name = "id", column = @Column(name = "marital_status_id"))
    })*/

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "marital_status_id",
                    referencedColumnName = "marital_status_id",
                    insertable = false, updatable = false),
            @JoinColumn(
                    name = "gender",
                    referencedColumnName = "gender",
                    insertable = false, updatable = false),
            @JoinColumn(
                    name = "language",
                    referencedColumnName = "language",
                    insertable = false, updatable = false)
    })
    private MaritalStatus maritalStatus;

    /*@ManyToMany
    @JoinColumn(
            name = "gender", referencedColumnName = "gender",
            nullable = false,
            insertable = false, updatable = false
    )*/
    /*@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "marital_status",
            joinColumns = @JoinColumn(name = "gender", referencedColumnName = "gender")
            //inverseJoinColumns = @JoinColumn(name = "gender", referencedColumnName = "gender")
    )
    private List<MaritalStatus> MaritalStatusList;*/


    // Standart constructors, geters and seters
    public Ad() {
    }

    public Ad(int customerId, String language, String gender, String adNickname, int maritalStatusId, MaritalStatus maritalStatus) {
        this.customerId = customerId;
        this.language = language;
        this.gender = gender;
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
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

}
