package com.intraedge.student.ws.client;

import java.util.List;

import com.intraedge.student.jaxb2beans.Address;
import com.intraedge.student.jaxb2beans.PhoneNumber;
import com.intraedge.student.jaxb2beans.Student;
import com.intraedge.student.jaxb2beans.StudentName;

public interface IStudentMgmt {
	
int registerStudent(Student student);
	
	List<StudentName> getStudentNames(int studentId);
	
	List<Address> getStudentAddress(int studentId);
	
	List<PhoneNumber> getStudentPhoneNumbers(int studentId);

}
