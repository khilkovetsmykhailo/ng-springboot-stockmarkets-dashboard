package io.lingani.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StockExchange created by Lingani
 */
@Entity
public class StockExchange implements java.io.Serializable {

	private static final long serialVersionUID = 8290520863493666991L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "abbrev", nullable = false)
	private String abbrev;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "currency")
	private String currency;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false)
	private Date updated;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockExchange")
	private Set<Symbol> symbols = new HashSet<Symbol>(0);

	public StockExchange() {
	}	

	public StockExchange(Integer id, String abbrev, String name, String city,
			String country, String currency, Date created, Date updated,
			Set<Symbol> symbols) {
		super();
		this.id = id;
		this.abbrev = abbrev;
		this.name = name;
		this.city = city;
		this.country = country;
		this.currency = currency;
		this.created = created;
		this.updated = updated;
		this.symbols = symbols;
	}

	
	
	public Integer getId() {
		return this.id;
	}

	
	public String getAbbrev() {
		return this.abbrev;
	}

	
	public String getName() {
		return this.name;
	}

	
	public String getCity() {
		return this.city;
	}

	
	public String getCountry() {
		return this.country;
	}

	
	public String getCurrency() {
		return this.currency;
	}

	
	public Date getCreated() {
		return this.created;
	}

	
	public Date getUpdated() {
		return this.updated;
	}

	
	public Set<Symbol> getSymbols() {
		return this.symbols;
	}

	public void setSymbols(Set<Symbol> symbols) {
		this.symbols = symbols;
	}

	@PrePersist
	protected void onCreate() {
		updated = created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}
}
