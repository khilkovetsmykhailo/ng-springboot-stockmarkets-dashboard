package io.linx.markets.repository;

import io.linx.markets.model.DailyPriceData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceDataRepository extends JpaRepository<DailyPriceData, Integer> {
	
	public static String latestPriceDataSQL = "select dp from DailyPriceData dp where dp.symbol.id = :symbol order by dp.priceDate";
	
	public static String historicalPriceDataSQL = "select dp from DailyPriceData dp where dp.symbol.id = :symbol order by dp.priceDate";
	
	DailyPriceData findTopBySymbolIdOrderByPriceDate(Integer symbol);	 
	
	List<DailyPriceData> findAllBySymbolId(Integer symbol);	

}
