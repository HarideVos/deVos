package com.inheritance;

public class Savings extends Checking{
	public Savings(int account, int routingNumber, String name, double apr, int minBalance, int maxLimit,
			int noOfTransactionLimit) {
		super(account, routingNumber, name, apr, minBalance, maxLimit);
		this.noOfTransactionLimit = noOfTransactionLimit;
	}

	int noOfTransactionLimit;


}
