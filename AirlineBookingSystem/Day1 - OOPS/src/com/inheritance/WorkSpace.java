package com.inheritance;

public class WorkSpace {

	public static void main(String[] args) {
		Checking checking1 = new Checking(11111, 0101011, "Ove", 0.12, 25, 5000);
		checking1.name = "Ove";
		Savings saving1 = new Savings(22222, 0101010, "Willem", 0.21, 50, 25000, 25);
		
		System.out.println(checking1);
		System.out.println(saving1);
		
		;

	}

}
