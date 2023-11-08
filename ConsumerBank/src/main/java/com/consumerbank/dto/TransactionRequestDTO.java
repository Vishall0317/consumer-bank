package com.consumerbank.dto;

import java.sql.Date;
import java.sql.Time;

public class TransactionRequestDTO {

	private String transactionNumber;
	private double amount;
	private String transactionType;
	private Integer accountId;
	private Date transactiondate;
	private Time transactiontime;
	
	public Time getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(Time transactiontime) {
		this.transactiontime = transactiontime;
	}
	
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
}
