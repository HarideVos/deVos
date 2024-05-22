package com.daos;

import java.util.List;

import com.entities.Student;

public interface StudentDao {
	
	public int insertStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public int updateStudent(int id, Student updateStudent);
	
	public int deleteStudent(int id);
}
