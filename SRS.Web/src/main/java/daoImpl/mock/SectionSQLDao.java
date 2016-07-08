package daoImpl.mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SectionDao;
import model.Course;
import model.Professor;
import model.Section;
import util.DBUtil;

public class SectionSQLDao implements SectionDao{

	@Override
	public List<Section> findAll() {
		Connection conn=DBUtil.getConnection();
		Statement stmt=DBUtil.getStatement(conn);
		String sql="select * from Section";
		ResultSet rs=DBUtil.getResultSet(stmt, sql);
		List<Section> sections= new ArrayList<Section>();
		try{
			while(rs.next()){
				Section s=getSectionFromRs(rs);
				sections.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(stmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		return sections;
	}

	private Section getSectionFromRs(ResultSet rs) {
		// TODO Auto-generated method stub
		Section s=null;
		Course c=null;
		Professor p=null;
		try{
			int SectionNo=rs.getInt("SectionNo");
			
			int semester=rs.getInt("Semester");
			String room=rs.getString("Room");
			int seatingCapacity=rs.getInt("SeatingCapacity");
			String representedCourse=rs.getString("RepresentedCourse");
			String instructor=rs.getString("Professor");
			
			c=new Course();
			c.setCourseName(representedCourse);
			p=new Professor(instructor,null,null,null);
			s=new Section(SectionNo,semester,c,room,seatingCapacity);
			s.setInstructor(p);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public HashMap<String, Section> findBySemester(String semester) {
		// 根据semester获取相应的section数据,此处直接手动给出section数据
		HashMap<String, Section> sections = new HashMap<String, Section>();
		Map<String, Course> allCourses = new CourseDaoImpl().findAll();
        
		Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;
		Course c;
		c = allCourses.get("CMP101");
		sec1 = new Section(1,2, c , "GOVT101", 30);
		sections.put(c.getCourseNo() + "-" + sec1.getSectionNo(), sec1);
		sec2 = new Section(2,3, c , "GOVT202", 30);
		sections.put(c.getCourseNo() + "-" + sec2.getSectionNo(), sec2);
		
		c = allCourses.get("OBJ101");
		sec3 = new Section(1,1, allCourses.get("OBJ101"), "GOVT105", 25);
		sections.put(c.getCourseNo() + "-" + sec3.getSectionNo(), sec3);
		sec4 = new Section(2,1, allCourses.get("OBJ101"), "SCI330", 25);
		sections.put(c.getCourseNo() + "-" + sec4.getSectionNo(), sec4);
		
		
		c = allCourses.get("CMP283");
		sec5 = new Section(1,2 ,allCourses.get("CMP283"), "GOVT101", 20);
		sections.put(c.getCourseNo() + "-" + sec5.getSectionNo(), sec5);
		
		c = allCourses.get("CMP999");
		sec6 = new Section(1, 2, allCourses.get("CMP999"), "SCI241", 15);
		sections.put(c.getCourseNo() + "-" + sec6.getSectionNo(), sec6);
		
		c = allCourses.get("ART101");
		sec7 = new Section(1, 4, allCourses.get("ART101"), "ARTS25", 40);
		sections.put(c.getCourseNo() + "-" + sec7.getSectionNo(), sec7);
		
		return sections;
	}

	@Override
	public void addSection(Section se) {
		// TODO Auto-generated method stub
		int semester=se.getSemester();
		String room=se.getRoom();
		int seatingCapacity=se.getSeatingCapacity();
		Course course=se.getRepresentedCourse();
		String courseName=course.getCourseName();
		Professor professor=se.getInstructor();
		String proName=professor.getName();
		
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt=null;
		try{
			
			String sql="insert into Section values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, semester);
			pstmt.setString(2, room);
			pstmt.setInt(3, seatingCapacity);
			pstmt.setString(4, courseName);
			pstmt.setString(5, proName);
			pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public void delete(int SectionNo) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		String sql;
		try{
			conn=DBUtil.getConnection();
			sql="delete from Section where SectionNo=" + SectionNo;
			stmt=DBUtil.getStatement(conn);
			DBUtil.executeUpdate(stmt, sql);
			
					
		}finally{
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public void update(Section se) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtil.getConnection();
			String sql = "update Section set Semester=?,Room=?,SeatingCapacity=?,RepresentedCourse=?,Professor=? where SectionNo=?";
			pstmt =DBUtil.prepare(conn, sql);
			pstmt.setInt(1, se.getSemester());
			pstmt.setString(2, se.getRoom());
			pstmt.setInt(3, se.getSeatingCapacity());
			pstmt.setString(4, se.getRepresentedCourse().getCourseName());
			pstmt.setString(5, se.getInstructor().getName());
			pstmt.setInt(6, se.getSectionNo());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
			
		
	}

	@Override
	public Section getSection(int SectionNo) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		Statement stmt=DBUtil.getStatement(conn);
		String sql="select * from Section";
		ResultSet rs=DBUtil.getResultSet(stmt, sql);
		Section s=null;
		try{
			while(rs.next()){
				 s=getSectionFromRs(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(stmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		
		return s;
	}

	@Override
	public List<Section> getSections(String instructor) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		Statement stmt=DBUtil.getStatement(conn);
		String sql="select * from Section where Professor="+instructor;
		ResultSet rs=DBUtil.getResultSet(stmt,sql);
		
		List<Section> sections= new ArrayList<Section>();
		try{
			while(rs.next()){
				Section s=getSectionFromRs(rs);
				sections.add(s);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(stmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		return sections;
	}
	
	

}
