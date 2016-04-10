package io.linx.markets.model;

import java.math.BigDecimal;
import java.util.Date;

public interface MarketSummary {	
	BigDecimal getTradeStockIndexAverage();	
	BigDecimal getTradeStockIndexOpenAverage();	
	BigDecimal getTradeStockIndexVolume();	
	BigDecimal getTradeStockChange();
	Date getMarketSummaryDate();	
}
