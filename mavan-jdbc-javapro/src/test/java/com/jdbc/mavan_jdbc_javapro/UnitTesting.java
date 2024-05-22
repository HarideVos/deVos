package com.jdbc.mavan_jdbc_javapro;

import org.junit.jupiter.api.Test;

import com.daos.StudentDaoImplementation;

public class UnitTesting {
	StudentDaoImplementation student = new StudentDaoImplementation();
	@Test
	public void getAllStudents() {
		System.out.println("Geting All Students");
	}
}
