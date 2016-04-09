package io.lingani.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DailyPrice created by Lingani
 */
@Entity
public class DailyPriceData implements java.io.Serializable {
    
	private static final long serialVersionUID = -7688309076096531228L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	private Integer id;  
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_vendor_id", nullable = false)
	private DataVendor dataVendor;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "symbol_id", nullable = false)
    private Symbol symbol;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "price_date", nullable = false, length = 19)
    private Date priceDate;
	
	@Column(name = "open_price", scale = 4)
    private BigDecimal openPrice;
	
	@Column(name = "high_price", scale = 4)
    private BigDecimal highPrice;
	
	@Column(name = "low_price", scale = 4)
    private BigDecimal lowPrice;
	
	@Column(name = "close_price", scale = 4)
    private BigDecimal closePrice;
	
	@Column(name = "adj_close_price", scale = 4)
    private BigDecimal adjClosePrice;
	
	@Column(name = "price_change", scale = 4)
    private BigDecimal priceChange;
	
	@Column(name = "percentage_change", scale = 4)
    private BigDecimal percentageChange;
	
	@Column(name = "volume")
    private Long volume;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, length = 19)
    private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false, length = 19)
    private Date updated;

    public DailyPriceData() {
    }   

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }  
    
    
    public DataVendor getDataVendor() {
        return this.dataVendor;
    }

    public void setDataVendor(DataVendor dataVendor) {
        this.dataVendor = dataVendor;
    }

    
    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    
    public Date getPriceDate() {
        return this.priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    
    public BigDecimal getOpenPrice() {
        return this.openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    
    public BigDecimal getHighPrice() {
        return this.highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    
    public BigDecimal getLowPrice() {
        return this.lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    
    public BigDecimal getClosePrice() {
        return this.closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    
    public BigDecimal getAdjClosePrice() {
        return this.adjClosePrice;
    }

    public void setAdjClosePrice(BigDecimal adjClosePrice) {
        this.adjClosePrice = adjClosePrice;
    }

    @Column(name = "price_change", scale = 4)
    public BigDecimal getPriceChange() {
        return priceChange;
    }

    public void setChange(BigDecimal change) {
        this.priceChange = change;
    }

    
    public BigDecimal getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(BigDecimal percentageChange) {
        this.percentageChange = percentageChange;
    }

    
    public Long getVolume() {
        return this.volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	public void setPriceChange(BigDecimal priceChange) {
		this.priceChange = priceChange;
	} 
    
}
