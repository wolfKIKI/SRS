package daoImpl.mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.TranscriptEntryDAO;
import model.Student;
import util.DBUtil;

public class TranscriptEntrySQLDAO implements TranscriptEntryDAO{

	@Override
	public void addTranscriptEntry(Student s,String grade,int SectionNo) {
		// TODO Auto-generated method stub
		String SSN=s.getSsn();
		
		Connection conn=DBUtil.getConnection();
		String sql="insert into Transcript values(?,?,?)";
		PreparedStatement pstmt=DBUtil.prepare(conn, sql);
		
		try{
			pstmt.setString(1, SSN);
			pstmt.setInt(2, SectionNo);
			pstmt.setString(3, grade);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}
	

}
