package io.linx.markets.controller;

import io.linx.markets.model.StockExchange;
import io.linx.markets.repository.MarketSummaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/summary/{exchangeId}")
public class MarketSummaryController {
	
	@Autowired
	private MarketSummaryRepository marketSummaryRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public StockExchange readStockExchangeDetails(@PathVariable Integer exchangeId){
		StockExchange stockExchange = marketSummaryRepository.findOne(exchangeId);
		return stockExchange;
	}

}
