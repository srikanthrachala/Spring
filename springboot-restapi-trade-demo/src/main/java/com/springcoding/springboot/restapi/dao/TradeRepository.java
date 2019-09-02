package com.springcoding.springboot.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcoding.springboot.restapi.data.Trade;

/**
 * DAO Class for Trade Operations
 * 
 * @author Srikanth
 *
 */
public interface TradeRepository extends JpaRepository<Trade,Long>{

    @Query("SELECT t FROM Trade t join t.user u where u.id = :id") 
    List<Trade> findTradesByUserId(@Param("id") Long id);

    @Query("SELECT t FROM Trade t  where t.symbol = :stockSymbol") 
    List<Trade> findTradesByByStockSymbol(@Param("stockSymbol") String stockSymbol);

    @Query("SELECT t FROM Trade t join t.user u where u.id = :id and t.symbol = :stockSymbol") 
    List<Trade> findTradesByUserAndStockSymbol(@Param("id") Long id, @Param("stockSymbol") String stockSymbol);

}
