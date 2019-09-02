package com.springcoding.springboot.restapi.service;

import java.util.List;

import com.springcoding.springboot.restapi.data.Trade;
/**
 * Interface for Trading Service
 * 
 * @author Srikanth
 *
 */
public interface TradeService {

	/**
	 * Deletes the trade based on trade id
	 * 
	 * @param id
	 */
	void deleteTradeById(Long id);

	/**
	 * Retrieves all trades
	 * @return List of Trade
	 */
	List<Trade> getAllTrades();

	/**
	 * Retrieves the trade by trade id
	 * 
	 * @param id
	 * @return Trade
	 */
	Trade getTradeById(Long id);

	/**
	 * Creates a new Trade
	 * 
	 * @param trade
	 * @return Trade
	 */
	Trade createTrade(Trade trade);

	/**
	 * Delete all the trades
	 * 
	 */
	void deleteAllTrades();

	/**
	 * Retrieves the trades filtered by user ID
	 * 
	 * @param userId
	 * @return
	 */
	List<Trade> getTradesByUserId(Long userId);

	/**
	 * Retrieves trades filtered by stock symbol
	 * 
	 * @param stockSymbol
	 * @return
	 */
	List<Trade> getTradesByStockSymbol(String stockSymbol);

	/**
	 * Retrieves trades filtered by the user ID and the stock symbol
	 * 
	 * @param userId
	 * @param stockSymbol
	 * @return List of Trade
	 */
	List<Trade> getTradesByUserAndStockSymbol(Long userId, String stockSymbol);


}
