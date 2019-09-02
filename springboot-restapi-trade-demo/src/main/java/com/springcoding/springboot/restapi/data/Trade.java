package com.springcoding.springboot.restapi.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Data Model for Trade
 * 
 * @author Srikanth
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trade implements Serializable,Comparable<Trade> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private TradeType type;
	
	@OneToOne
	private User user;
	private String symbol;
	
	@Min(value = 10, message = "Shares Count can't be less than 10 or greater than 30")
	@Max(30)
	private Integer shares;
	
	@DecimalMin(value = "130.42", message = "Share Price can't be less than 130.42 or greater than 195.65")
	@DecimalMax("195.65")
	private BigDecimal price;
	private LocalDateTime timestamp = LocalDateTime.now(ZoneId.of("America/New_York"));

	
	public Trade() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TradeType getType() {
		return type;
	}

	public void setType(TradeType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", type=" + type + ", user=" + user + ", symbol=" + symbol
				+ ", shares=" + shares + ", price=" + price + ", timestamp=" + timestamp
				+ "]";
	}


	@Override
	public int compareTo(Trade o) {
		return (int) (this.id-o.id);
	}

}
