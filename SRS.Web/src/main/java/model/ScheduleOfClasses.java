package model;
// ScheduleOfClasses.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.HashMap;

public class ScheduleOfClasses {
	//------------
	// Attributes.
	//------------

	private int semester;

	// This HashMap stores Section object references, using
	// a String concatenation of course no. and section no. as the
	// key, e.g., "MATH101 - 1".

	private HashMap<String, String> sectionsOffered; 

	//----------------
	// Constructor(s).
	//----------------
	/**
	public ScheduleOfClasses(String semester) {
		setSemester(semester);
		
		// Note that we're instantiating empty support Collection(s).

		sectionsOffered = new HashMap<String, String>();
	}
*/
	public ScheduleOfClasses(int semester, HashMap<String, String> sectionsOffered ) {
		setSemester(semester);
		
		// Note that we're instantiating empty support Collection(s).

		this.sectionsOffered = sectionsOffered;
	}
	//------------------
	// Accessor methods.
	//------------------

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSemester() {
		return semester;
	}

	public HashMap<String, String> getSectionsOffered() {
		return sectionsOffered;
	}

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	

	

	// The full section number is a concatenation of the
	// course no. and section no., separated by a hyphen;
	// e.g., "ART101 - 1".

	public String  findSection(String fullSectionNo) {
		return sectionsOffered.get(fullSectionNo);
	}

	public boolean isEmpty() {
		if (sectionsOffered.size() == 0) return true;
		else return false;
	}
}
