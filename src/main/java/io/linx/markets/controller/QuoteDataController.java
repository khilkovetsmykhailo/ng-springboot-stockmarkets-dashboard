package io.linx.markets.controller;

import java.util.List;

import io.linx.markets.model.DailyPriceData;
import io.linx.markets.model.FundamentalData;
import io.linx.markets.repository.FundamentalDataRepository;
import io.linx.markets.repository.PriceDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/{symbolId}")
public class QuoteDataController {
	
	private final PriceDataRepository priceDataRepository;
	
	private final FundamentalDataRepository fundamentalDataRepository;
	
	@RequestMapping(value = "/price/latest", method = RequestMethod.GET)
	public DailyPriceData readLatestPriceData(@PathVariable Integer symbolId){		
		DailyPriceData priceData = priceDataRepository.findTopBySymbolIdOrderByPriceDate(symbolId);		
		return priceData;		
	}
	
	@RequestMapping(value = "/price/historical", method = RequestMethod.GET)
	public List<DailyPriceData> readHistoricalPriceData(@PathVariable Integer symbolId){		
		List<DailyPriceData> priceDatas = priceDataRepository.findAllBySymbolId(symbolId);		
		return priceDatas;		
	}
	
	@RequestMapping(value = "/fundamental", method = RequestMethod.GET)
	public FundamentalData readFundamentalData(@PathVariable Integer symbolId){
		FundamentalData fundamentalData = fundamentalDataRepository.findBySymbolId(symbolId);
		return fundamentalData;		
	}

	
	@Autowired
	QuoteDataController(PriceDataRepository priceDataRepository, FundamentalDataRepository fundamentalDataRepository){
		this.priceDataRepository = priceDataRepository;
		this.fundamentalDataRepository = fundamentalDataRepository;
	}
}
