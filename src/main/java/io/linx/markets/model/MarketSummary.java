package io.linx.markets.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MarketSummary {
	private BigDecimal tradeStockIndexAverage;
	private Long tradeStockIndexVolume;
	private BigDecimal tradeStockIndexOpenAverage;
	private Date summaryDate;
	private BigDecimal change;
	private BigDecimal percentageGain;
	private StockExchange stockExchange;	
	private List<DailyPriceData> topLosers;
	private List<DailyPriceData> topGainers;

	public BigDecimal getChange() {
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	public void setPercentageGain(BigDecimal percentageGain) {
		this.percentageGain = percentageGain;
	}

	public BigDecimal getPercentageGain() {
		return percentageGain;
	}

	public BigDecimal getTradeStockIndexAverage() {
		return tradeStockIndexAverage;
	}

	public void setTradeStockIndexAverage(BigDecimal tradeStockIndexAverage) {
		this.tradeStockIndexAverage = tradeStockIndexAverage;
	}

	public Long getTradeStockIndexVolume() {
		return tradeStockIndexVolume;
	}

	public void setTradeStockIndexVolume(Long tradeStockIndexVolume) {
		this.tradeStockIndexVolume = tradeStockIndexVolume;
	}

	public BigDecimal getTradeStockIndexOpenAverage() {
		return tradeStockIndexOpenAverage;
	}

	public void setTradeStockIndexOpenAverage(
			BigDecimal tradeStockIndexOpenAverage) {
		this.tradeStockIndexOpenAverage = tradeStockIndexOpenAverage;
	}

	public Date getSummaryDate() {
		return summaryDate;
	}

	public void setSummaryDate(Date summaryDate) {
		this.summaryDate = summaryDate;
	}

	public List<DailyPriceData> getTopLosers() {
		return topLosers;
	}

	public void setTopLosers(List<DailyPriceData> topLosers) {
		this.topLosers = topLosers;
	}

	public List<DailyPriceData> getTopGainers() {
		return topGainers;
	}

	public void setTopGainers(List<DailyPriceData> topGainers) {
		this.topGainers = topGainers;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

}
