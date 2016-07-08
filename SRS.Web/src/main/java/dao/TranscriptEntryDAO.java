package dao;

import model.Student;

public interface TranscriptEntryDAO {
	public void addTranscriptEntry(Student s, String grade, int SectionNo);

	
}
