package dao;

import java.util.ArrayList;
import java.util.List;

import model.TranscriptEntry;

public interface TranscriptDao {
	public ArrayList<TranscriptEntry> getTranscript();
	
	public void addTranscriptEntries(List selecteds,String ssn);
	
	public List<String> getStudentBySection(int SectionNo);
	
	public void addgrade(int grade, int SectionNo,String ssn);
	
	public List<TranscriptEntry> getGrades(String ssn);
}
