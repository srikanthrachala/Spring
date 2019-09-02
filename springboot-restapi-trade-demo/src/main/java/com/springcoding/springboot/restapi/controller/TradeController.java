package com.springcoding.springboot.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcoding.springboot.restapi.data.Trade;
import com.springcoding.springboot.restapi.service.TradeService;

/**
 * 
 * Controller Class for Trade API end point/operations
 * 
 * @author Srikanth
 *
 */
@RestController
public class TradeController {

	@Autowired
	private TradeService tradeService;

	/**
	 * Creates a new Trade
	 * 
	 * @param trade
	 * @return Trade
	 */
	@PostMapping("/trades")
	Trade createTrade(@Valid @RequestBody Trade trade) {
		return tradeService.createTrade(trade);
	}

	/**
	 * Retrieves all trades
	 * @return List of Trade
	 */
	@GetMapping("/trades")
	List<Trade> getAllTrades() {
		return tradeService.getAllTrades();
	}

	/**
	 * Retrieves the trade by trade id
	 * 
	 * @param id
	 * @return Trade
	 */
	@GetMapping("/trades/{id}")
	Trade getTradeById(@PathVariable Long id) {
		return tradeService.getTradeById(id);
	}

	/**
	 * Deletes the trade based on trade id
	 * 
	 * @param id
	 */
	@DeleteMapping("/trades/{id}")
	void deleteTradeById(@PathVariable Long id) {
		tradeService.deleteTradeById(id);
	}

	/**
	 * Erase all the trades
	 * 
	 */
	@DeleteMapping("/erase")
	void deleteAllTrades() {
		tradeService.deleteAllTrades();
	}

	/**
	 * Retrieves the trades filtered by user ID
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/trades/users/{userId}")
	List<Trade> getTradesByUserId(@PathVariable Long userId) {
		return tradeService.getTradesByUserId(userId);
	}

	/**
	 * Retrieves trades filtered by stock symbol
	 * 
	 * @param stockSymbol
	 * @return
	 */
	@GetMapping("/trades/stocks/{stockSymbol}")
	List<Trade> getTradesByStockSymbol(@PathVariable String stockSymbol) {
		return tradeService.getTradesByStockSymbol(stockSymbol);
	}

	/**
	 * Retrieves trades filtered by the user ID and the stock symbol
	 * 
	 * @param userId
	 * @param stockSymbol
	 * @return List of Trade
	 */
	@GetMapping("/trades/users/{userId}/stocks/{stockSymbol}")
	List<Trade> getTradesByUserAndStockSymbol(@PathVariable Long userId, @PathVariable String stockSymbol) {
		return tradeService.getTradesByUserAndStockSymbol(userId, stockSymbol);
	}

}
