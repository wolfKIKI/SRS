package dao;

import model.User;

public interface UserDao {
	public  User check(String username,String password);
}
