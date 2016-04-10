package io.linx.markets.model;


public interface SymbolPriceData {	
	String getTicker();
	String getName();
	DailyPriceData getDailyPriceData();
	}
