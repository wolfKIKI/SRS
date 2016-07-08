package dao;

import java.util.HashMap;

import model.Person;
import model.Professor;
import model.User;;

public interface PersonDao {
	
	public HashMap<String, Professor> findAllProfessors();
	public Person getPeByUser(User u);
}
