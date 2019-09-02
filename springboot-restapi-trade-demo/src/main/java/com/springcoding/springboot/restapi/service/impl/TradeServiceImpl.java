package com.springcoding.springboot.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcoding.springboot.restapi.dao.TradeRepository;
import com.springcoding.springboot.restapi.data.Trade;
import com.springcoding.springboot.restapi.exception.TradeNotFoundException;
import com.springcoding.springboot.restapi.service.TradeService;
import com.springcoding.springboot.restapi.service.UserService;

@Service
public class TradeServiceImpl implements TradeService{

	@Autowired
	private TradeRepository tradeRepository;

	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteTradeById(Long id) {
		
		tradeRepository.deleteById(id);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Trade> getAllTrades() {

		return tradeRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Trade getTradeById(Long id){
		
		Optional<Trade> trade= tradeRepository.findById(id);
		if(!trade.isPresent()) {
			throw new TradeNotFoundException(id);
		}

		return trade.get();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Trade createTrade(Trade trade) {

		return tradeRepository.save(trade);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAllTrades() {
		 tradeRepository.deleteAll();		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Trade> getTradesByUserId(Long userId) {

		List<Trade> tradeList = new ArrayList<>();

		if(userService.getUserById(userId)!=null)
		{
			tradeList= tradeRepository.findTradesByUserId(userId);
		}
		
		if(tradeList.isEmpty())
		{
			throw new TradeNotFoundException("No Trades found for User Id"+userId);
		}
		return tradeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Trade> getTradesByStockSymbol(String stockSymbol) {
		
		List<Trade> tradeList = new ArrayList<>();

		if(stockSymbol!=null)
		{
			tradeList= tradeRepository.findTradesByByStockSymbol(stockSymbol);
		}
		
		if(tradeList.isEmpty())
		{
			throw new TradeNotFoundException("No Trades found for Stock Symbol"+stockSymbol);
		}
		return tradeList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Trade> getTradesByUserAndStockSymbol(Long userId, String stockSymbol) {
		
		
		List<Trade> tradeList = new ArrayList<>();

		if(userService.getUserById(userId)!=null && stockSymbol!=null )
		{
			tradeList= tradeRepository.findTradesByUserAndStockSymbol(userId, stockSymbol);
		}
		
		if(tradeList.isEmpty())
		{
			throw new TradeNotFoundException("No Trades found for User Id"+userId+" Stock Symbol"+stockSymbol);
		}
		return tradeList;
	}

	
	

}
