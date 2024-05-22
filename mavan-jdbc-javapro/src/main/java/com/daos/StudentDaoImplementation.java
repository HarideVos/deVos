package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Student;
import com.utilities.SQLConnector;

public class StudentDaoImplementation implements StudentDao{

	public static Connection con = null;
	@Override
	public int insertStudent(Student student){
		int status = 0;
		Connection con = SQLConnector.createConnection();
		String sql = "insert into students(name, gpa, address, gradde) values(?, ?, ?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, student.getName());
			stm.setDouble(2, student.getGpa());
			stm.setString(3, student.getAddress());
			stm.setString(4, student.getGradde());
			status = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		String sql  = "select * from students";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeQuery();
			ResultSet resultData = stmt.executeQuery();
			while (resultData.next()){
				Student s = new Student();
				
				s.setId(resultData.getInt(1));
				s.setName(resultData.getString(2));
				s.setGpa(resultData.getDouble(3));
				s.setAddress(resultData.getString(4));
				s.setGrade(resultData.getString(5));
				
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public int updateStudent(int id, Student updateStudent) {
		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		return 0;
	}

}
