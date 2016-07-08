package daoImpl.mock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import dao.PersonDao;
import model.Person;
import model.Professor;
import model.Section;
import model.Student;
import model.User;
import util.DBUtil;

public class PersonDaoImpl implements PersonDao {

	@Override
	public HashMap<String, Professor> findAllProfessors() {
		
		HashMap<String, Professor> professors = new HashMap<String, Professor>();
		
		Professor p1, p2, p3;
		p1 = new Professor("Jacquie Barker", "123-45-6789", "Adjunct Professor", "Information Technology");
		professors.put(p1.getSsn(), p1);
		p2 = new Professor("John Smith", "567-81-2345", "Full Professor", "Chemistry");
		professors.put(p2.getSsn(), p2);
		p3 = new Professor("Snidely Whiplash", "987-65-4321", "Full Professor", "Physical Education");
		professors.put(p3.getSsn(), p3);	
		
		//此处应该读取教授所教的课程
		
		
		return professors;
	}

	//通过user，将user与person联系起来
	public Person getPeByUser(User u){
		String username=u.getUsername();
		Person p=new Student(null,null,null,null);
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from User inner join Person  where Username = '" + username + "'and User.RelatedPerson=Person.SSN";
		Statement stmt = DBUtil.getStatement(conn);
		ResultSet rs = DBUtil.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				p.setName(rs.getString("Name"));
				p.setSsn(rs.getString("SSN"));
			}
			
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(rs);
				DBUtil.close(stmt);
				DBUtil.close(conn);
			
		
		
		return p;
		
	
			}

	}
}
