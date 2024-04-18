package com.inheritance;

public class Checking extends Bank{
	double apr;
	int minBalance;
	int maxLimit;
	
	public Checking(int account, int routingNumber, String name, double apr, int minBalance, int maxLimit) {
		super(account, routingNumber, name);
		this.apr = apr;
		this.minBalance = minBalance;
		this.maxLimit = maxLimit;
	}
}
