package io.linx.markets.repository;

import io.linx.markets.model.DailyPriceData;
import io.linx.markets.model.SymbolPriceData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceDataRepository extends JpaRepository<DailyPriceData, Integer> {

	public static String latestPriceDataSQL = "select dp.symbol.ticker as ticker, dp.symbol.name as name, dp as dailyPriceData "
			+ "from DailyPriceData dp where dp.symbol.stockExchange.id = :exchangeId and dp.priceDate = (select max(dp.priceDate) from DailyPriceData as dp) "
			+ "order by dp.symbol.sector.name, dp.symbol.ticker";	

	DailyPriceData findTopBySymbolIdOrderByPriceDate(Integer symbol);

	List<DailyPriceData> findAllBySymbolId(Integer symbol);

	@Query(latestPriceDataSQL)
	List<SymbolPriceData> findAllByExchangeId(@Param("exchangeId") Integer exchangeId);
}
