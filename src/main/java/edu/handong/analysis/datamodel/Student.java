package edu.handong.analysis.datamodel;

import java.util.ArrayList;  
import java.util.HashMap;

public class Student {
	private String studentId;
	private ArrayList<Course> coursesTaken; 
	private HashMap<String,Integer> semestersByYearAndSemester; 
	                                                       
	public Student(String studentId) {
		this.setStudentId(studentId);
		coursesTaken = new ArrayList<Course>();
		semestersByYearAndSemester = new HashMap<String, Integer>();
	}

	public void addCourse(Course newRecord){
		coursesTaken.add(newRecord);
	}
	
	public HashMap<String,Integer> getSemestersByYearAndSemester(){
		int i = 1;
		
		for (Course course : coursesTaken){
			String tempString = new String();
			tempString += Integer.toString(course.getYearTaken());
			tempString += "-";
			tempString += Integer.toString(course.getSemesterCourseTaken());
			
			if (semestersByYearAndSemester.containsKey(tempString)){
				continue;
			}
			else{
				semestersByYearAndSemester.put(tempString, i++);
			}
		}
		
		return semestersByYearAndSemester;
	}
	
	public int getNumCourseInNthSementer(int semester){
		int count = 0;
		
		String yearSemester = new String();
		
		for (String key : semestersByYearAndSemester.keySet()) {			
            if (semestersByYearAndSemester.get(key).intValue() == semester){
            	yearSemester = key;
            	break;
            }
        }
		
		for (Course course : coursesTaken){
			
			String tempString = new String();
			tempString += Integer.toString(course.getYearTaken());
			tempString += "-";
			tempString += Integer.toString(course.getSemesterCourseTaken());
			
			if (tempString.equals(yearSemester)){
				count++;
			}
		}
		
		return count;
	}

	public String getStudentId(){
		return studentId;
	}

	public void setStudentId(String studentId){
		this.studentId = studentId;
	}

	public ArrayList<Course> getCoursesTaken(){
		return coursesTaken;
	}

	public void setCoursesTaken(ArrayList<Course> coursesTaken){
		this.coursesTaken = coursesTaken;
	}
}