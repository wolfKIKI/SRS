package model;


import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import model.Person;
import model.Student;
public class User {
	private String username;
	private String password;
	private Person person;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	
}
