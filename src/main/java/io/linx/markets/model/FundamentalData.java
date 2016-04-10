package io.linx.markets.model;

// default package
// Generated 16 Jun 2015 7:02:15 PM by Hibernate Tools 4.3.1

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * FundamentalData created by Lingani
 */
@Entity
public class FundamentalData implements java.io.Serializable {

    private static final long serialVersionUID = 6360960346977211501L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symbol_id", nullable = false)
    @JsonIgnore
    private Symbol symbol;
    
    @Column(name = "description", length = 1000)
    private String description;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "website_url")
    private String websiteUrl;
    
    @Column(name = "phone_number")
    private String phoneNumer;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "market_cap")
    private Long marketCap;
    
    @Column(name = "number_of_employees")
    private Long numberOfEmployees;
    
    @Column(name = "founding_year")
    private Long foundingYear;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, length = 19)    
    private Date created;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false, length = 19)
    private Date updated;

    public FundamentalData() {
    }
    
	
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

   
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    public String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    
    public Long getMarketCap() {
        return this.marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }    

    
    public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Long getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Long numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	
	public Long getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(Long foundingYear) {
		this.foundingYear = foundingYear;
	}

	
    public Date getCreatedDate() {
        return this.created;
    }

    public void setCreatedDate(Date createdDate) {
        this.created = createdDate;
    }

    
    public Date getUpdated() {
        return this.updated;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.updated = lastUpdatedDate;
    }

}
