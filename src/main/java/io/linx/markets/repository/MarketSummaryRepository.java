package io.linx.markets.repository;

import io.linx.markets.model.MarketSummary;
import io.linx.markets.model.StockExchange;
import io.linx.markets.model.SymbolPriceData;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarketSummaryRepository extends JpaRepository<StockExchange, Integer>{
	
	public static String marketSummarySQL = "SELECT SUM(dp.closePrice) / COUNT(dp) as tradeStockIndexAverage, "
            + "SUM(dp.openPrice) / COUNT(dp) as tradeStockIndexOpenAverage, "
            + "SUM(dp.volume) as tradeStockIndexVolume, "
            + "SUM(dp.highPrice) - SUM(dp.lowPrice) as tradeStockChange, "
            + "MAX(dp.priceDate) as marketSummaryDate "            
            + "FROM DailyPriceData dp "
            + "WHERE dp.symbol.stockExchange.id = :exchangeId "
            + "AND dp.priceDate = (select MAX(dp.priceDate) from DailyPriceData as dp) ";

    public static String topLosersSQL = "select distinct dp.symbol.ticker as ticker, dp.symbol.name as name, dp as dailyPriceData " +
            "from DailyPriceData dp where dp.symbol.stockExchange.id = :exchangeId and dp.priceDate = (select max(dp.priceDate) from DailyPriceData as dp) " +
            "order by dp.percentageChange desc";

    public static String topGainersSQL = "select distinct dp.symbol.ticker as ticker, dp.symbol.name as name, dp as dailyPriceData " +
            "from DailyPriceData dp where dp.symbol.stockExchange.id = :exchangeId and dp.priceDate = (select max(dp.priceDate) from DailyPriceData as dp) " +
            "order by dp.percentageChange asc";
    
    Pageable topFive = new PageRequest(0, 5);
    
    @Query(marketSummarySQL)
    MarketSummary findMarketSummary(@Param("exchangeId") int exchangeId);	    
	
	@Query(topLosersSQL)
    List<SymbolPriceData> findTopLosers(@Param("exchangeId") Integer exchangeId, Pageable pageable);
	
	@Query(topGainersSQL)
	List<SymbolPriceData> findTopGainers(@Param("exchangeId") Integer exchangeId, Pageable pageable);
	
	default List<SymbolPriceData> findTop5Losers(Integer exchangeId){
    	return findTopLosers(exchangeId, new PageRequest(0, 5)); 
    }
	
	default List<SymbolPriceData> findTop5Gainers(Integer exchangeId){
    	return findTopGainers(exchangeId, new PageRequest(0, 5)); 
    }
	
}
