package daoImpl.mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import dao.TranscriptDao;
import model.Section;
import model.Student;
import model.TranscriptEntry;
import util.DBUtil;

public class TranscriptSQLDao implements TranscriptDao {

	@Override
	public ArrayList<TranscriptEntry> getTranscript() {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		Statement stmt=DBUtil.getStatement(conn);
		String sql="select * from Transcript";
		
		ResultSet rs=DBUtil.getResultSet(stmt,sql);
		
		ArrayList<TranscriptEntry> transcriptEntries=new ArrayList<TranscriptEntry>();
		try{ 
			while(rs.next()){
				TranscriptEntry te=getTranscriptEntryFromRs(rs);
				transcriptEntries.add(te);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(stmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		
		return transcriptEntries;
	}

	private TranscriptEntry getTranscriptEntryFromRs(ResultSet rs) {
		// TODO Auto-generated method stub
		
		TranscriptEntry te=null;
		try{
			String SSN=rs.getString("SSN");
			int SectionNo=rs.getInt("SectionNo");
			String grade=rs.getString("Grade");
			Student s=new Student(null,SSN,null,null);
			Section se=new Section(SectionNo,null,null,null,null);
			te=new TranscriptEntry(s,grade,se);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return te;
	}

	@Override
	public void addTranscriptEntries(List selecteds,String ssn) {
		// TODO Auto-generated method stub
		
		
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt=null;
		
		
		
		
		try{
			
			for(Iterator i=selecteds.iterator();i.hasNext();){
				int select=(int)i.next();
				
			String sql="insert into Transcript(SSN,SectionNo) values(?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ssn);
			pstmt.setInt(2, select);
			pstmt.executeQuery();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<String> getStudentBySection(int SectionNo) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		Statement stmt=DBUtil.getStatement(conn);
		String sql="select SSN from Transcript where SectionNo="+SectionNo;
		ResultSet rs=DBUtil.getResultSet(stmt, sql);
		List<String> ssns=new ArrayList<String>();
		
		try{
			while(rs.next()){
				String ssn=rs.getString("SSN");
				ssns.add(ssn);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBUtil.close(stmt);
				DBUtil.close(conn);
			}
			return ssns;
		}

	@Override
	public void addgrade(int grade,int SectionNo,String ssn) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtil.getConnection();
			String sql = "update Transcript set grade=? where SSN=? & SectionNo=?";
			pstmt =DBUtil.prepare(conn, sql);
			pstmt.setInt(1,grade);
			pstmt.setString(2, ssn);
			pstmt.setInt(3, SectionNo);
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<TranscriptEntry> getGrades(String ssn) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		Statement stmt=DBUtil.getStatement(conn);
		String sql="select * from Transcript where SSN="+ssn;
		
		ResultSet rs=DBUtil.getResultSet(stmt,sql);
		
		List<TranscriptEntry> TranscriptEntries=new ArrayList<TranscriptEntry>();
		try{ 
			while(rs.next()){
				TranscriptEntry te=getTranscriptEntryFromRs(rs);
				TranscriptEntries.add(te);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(stmt);
			DBUtil.close(rs);
			DBUtil.close(conn);
		}
		
		return TranscriptEntries;
	}
	
		
		
		
	

}
