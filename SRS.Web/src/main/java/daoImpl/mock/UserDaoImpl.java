package daoImpl.mock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDao;
import model.User;
import util.DBUtil;

public class UserDaoImpl implements UserDao{
	
	//check方法核对用户登录信息
	public  User check(String username, String password)
	{
				User u = null;
				Connection conn = DBUtil.getConnection();
				String sql = "select * from User  where Username = '" + username + "'";
				Statement stmt = DBUtil.getStatement(conn);
				ResultSet rs = DBUtil.getResultSet(stmt, sql);
				try {
					
						if(password.equals(rs.getString("Password"))) {
							
						
						u = new User();
						u.setUsername(rs.getString("UserName"));
						
						u.setPassword(rs.getString("Password"));
				
						}
						
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.close(rs);
					DBUtil.close(stmt);
					DBUtil.close(conn);
				}
				return u;
					
					}
}
