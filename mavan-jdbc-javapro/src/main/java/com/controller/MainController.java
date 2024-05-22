package com.controller;

import java.sql.Connection;

import com.daos.StudentDaoImplementation;
import com.utilities.SQLConnector;

public class MainController {

	public static void main(String[] args) {

		System.out.println("This is our project main class");
		Connection connectionVar = SQLConnector.createConnection();
		System.out.println(connectionVar);
		
		StudentDaoImplementation studentImplObj = new StudentDaoImplementation();
		studentImplObj.insertStudent(null);
	}

}
