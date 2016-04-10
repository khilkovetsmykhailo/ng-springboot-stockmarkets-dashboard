package io.linx.markets.controller;

import java.util.List;

import io.linx.markets.model.DailyPriceData;
import io.linx.markets.model.FundamentalData;
import io.linx.markets.model.SymbolPriceData;
import io.linx.markets.repository.FundamentalDataRepository;
import io.linx.markets.repository.PriceDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote/{exchangeId}")
public class QuoteDataController {
	
	private final PriceDataRepository priceDataRepository;
	
	private final FundamentalDataRepository fundamentalDataRepository;
	
	@RequestMapping(value = "/{symbolId}/price/latest", method = RequestMethod.GET)
	public DailyPriceData readLatestPriceData(@PathVariable Integer symbolId){		
		DailyPriceData priceData = priceDataRepository.findTopBySymbolIdOrderByPriceDate(symbolId);		
		return priceData;		
	}
	
	@RequestMapping(value = "/{symbolId}/price/historical", method = RequestMethod.GET)
	public List<DailyPriceData> readHistoricalPriceData(@PathVariable Integer symbolId){		
		List<DailyPriceData> priceDatas = priceDataRepository.findAllBySymbolId(symbolId);		
		return priceDatas;		
	}
	
	@RequestMapping(value = "/{symbolId}/fundamental", method = RequestMethod.GET)
	public FundamentalData readFundamentalData(@PathVariable Integer symbolId){
		FundamentalData fundamentalData = fundamentalDataRepository.findBySymbolId(symbolId);
		return fundamentalData;		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SymbolPriceData> readLatestExchangePriceData(@PathVariable Integer exchangeId){
		List<SymbolPriceData> symbolPriceData = priceDataRepository.findAllByExchangeId(exchangeId);
		return symbolPriceData;		
	}
	
	@Autowired
	QuoteDataController(PriceDataRepository priceDataRepository, FundamentalDataRepository fundamentalDataRepository){
		this.priceDataRepository = priceDataRepository;
		this.fundamentalDataRepository = fundamentalDataRepository;
	}
}
