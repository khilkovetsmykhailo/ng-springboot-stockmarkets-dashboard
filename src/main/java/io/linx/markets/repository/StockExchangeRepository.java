package io.linx.markets.repository;

import io.linx.markets.model.StockExchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer>{

}
