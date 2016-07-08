package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Section;

public interface SectionDao {

	public List<Section> findAll();
	public HashMap<String,Section> findBySemester(String semester);
	
	 public void addSection(Section se);
	 public void delete(int SectionNo);
	 public void update(Section se);
	 
	 public Section getSection(int SectionNo);
	 public List<Section > getSections(String instructor);
}
