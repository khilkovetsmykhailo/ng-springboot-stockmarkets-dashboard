package io.linx.markets.model;

import io.linx.markets.util.FinancialSerializer;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface MarketSummary {
	@JsonProperty("tradeStockIndexAverage")
	@JsonSerialize(using = FinancialSerializer.class)
	BigDecimal getTradeStockIndexAverage();	
	
	@JsonProperty("tradeStockIndexOpenAverage")
	@JsonSerialize(using = FinancialSerializer.class)
	BigDecimal getTradeStockIndexOpenAverage();
	
	@JsonProperty("tradeStockIndexVolume")
	@JsonSerialize(using = FinancialSerializer.class)
	BigDecimal getTradeStockIndexVolume();
	
	@JsonProperty("tradeStockChange")
	@JsonSerialize(using = FinancialSerializer.class)
	BigDecimal getTradeStockChange();
	
	Date getMarketSummaryDate();	
}
