package com.skv.www.dao;

import java.sql.SQLException;

import com.skv.www.model.Student;

public interface StudentDaoInterface {

	public boolean insertStudent(Student s);
	public void showAllStudents();
	public boolean showStudentById(int roll);
	public boolean delete(int roll);
	public boolean update(int roll, String update, int ch, Student s);
	
	
	
}
