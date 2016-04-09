package io.lingani.model;

// default package
// Generated 16 Jun 2015 7:02:15 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Symbol created by Lingani
 */
@Entity
public class Symbol implements java.io.Serializable {

	private static final long serialVersionUID = -1853004533202036543L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_exchange_id")
	private StockExchange stockExchange;

	@Column(name = "ticker", nullable = false, length = 32)
	private String ticker;

	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
	private Sector sector;

	@Temporal(TemporalType.TIMESTAMP)
	// @Column(name = "created", nullable = false)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	// @Column(name = "updated", nullable = false)
	private Date updated;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "symbol")
	private Set<FundamentalData> fundamentalDatas = new HashSet<FundamentalData>(
			0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "symbol")
	private Set<DailyPriceData> dailyPrices = new HashSet<DailyPriceData>(0);

	public Symbol() {
	}	

	public Symbol(Integer id, StockExchange stockExchange, String ticker,
			String name, Sector sector, Date created, Date updated,
			Set<FundamentalData> fundamentalDatas,
			Set<DailyPriceData> dailyPrices) {
		super();
		this.id = id;
		this.stockExchange = stockExchange;
		this.ticker = ticker;
		this.name = name;
		this.sector = sector;
		this.created = created;
		this.updated = updated;
		this.fundamentalDatas = fundamentalDatas;
		this.dailyPrices = dailyPrices;
	}

	public Integer getId() {
		return id;
	}

	public StockExchange getStockExchange() {
		return this.stockExchange;
	}

	public String getTicker() {
		return this.ticker;
	}

	public String getName() {
		return this.name;
	}
	
	public Sector getSector() {
        return this.sector;
    }	

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public Set<FundamentalData> getFundamentalDatas() {
		return this.fundamentalDatas;
	}

	public void setFundamentalDatas(Set<FundamentalData> fundamentalDatas) {
		this.fundamentalDatas = fundamentalDatas;
	}

	public Set<DailyPriceData> getDailyPrices() {
		return this.dailyPrices;
	}

	public void setDailyPrices(Set<DailyPriceData> dailyPrices) {
		this.dailyPrices = dailyPrices;
	}
}
