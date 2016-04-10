package io.linx.markets.repository;

import io.linx.markets.model.FundamentalData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FundamentalDataRepository extends JpaRepository<FundamentalData, Integer> {	
	FundamentalData findBySymbolId(Integer symbol);
}
