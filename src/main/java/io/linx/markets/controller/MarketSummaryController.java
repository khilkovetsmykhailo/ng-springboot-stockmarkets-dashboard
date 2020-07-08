package io.linx.markets.controller;

import io.linx.markets.model.MarketSummary;
import io.linx.markets.model.StockExchange;
import io.linx.markets.model.SymbolPriceData;
import io.linx.markets.repository.MarketSummaryRepository;
import io.linx.markets.repository.StockExchangeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exchange/{exchangeId}")
public class MarketSummaryController {
	
	private final MarketSummaryRepository marketSummaryRepository;
	
	private final StockExchangeRepository stockExchangeRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public StockExchange readStockExchangeDetails(@PathVariable Integer exchangeId){
		Optional<StockExchange> stockExchange = stockExchangeRepository.findById(exchangeId);
		StockExchange exchange = stockExchange.get();
		return exchange;
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public MarketSummary readMarketSummary(@PathVariable Integer exchangeId){
		MarketSummary marketSummary = marketSummaryRepository.findMarketSummary(exchangeId);
		return marketSummary;
	}
	
	@RequestMapping(value = "/losers", method = RequestMethod.GET)
	public List<SymbolPriceData> readTopLosers(@PathVariable Integer exchangeId, Pageable pageable){
		List<SymbolPriceData> topLosers = marketSummaryRepository.findTop5Losers(exchangeId);
		return topLosers;
	}
	
	@RequestMapping(value = "/gainers", method = RequestMethod.GET)
	public List<SymbolPriceData> readTopGainers(@PathVariable Integer exchangeId, Pageable pageable){
		List<SymbolPriceData> topGainers = marketSummaryRepository.findTop5Gainers(exchangeId);
		return topGainers;
	}
	
	@Autowired
	public MarketSummaryController(MarketSummaryRepository marketSummaryRepository, StockExchangeRepository stockExchangeRepository){
		this.marketSummaryRepository = marketSummaryRepository;
		this.stockExchangeRepository = stockExchangeRepository;
		
	}

}
