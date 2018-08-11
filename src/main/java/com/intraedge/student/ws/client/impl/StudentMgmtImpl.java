package com.intraedge.student.ws.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.intraedge.student.jaxb2beans.Address;
import com.intraedge.student.jaxb2beans.PhoneNumber;
import com.intraedge.student.jaxb2beans.RegisterStudentRequest;
import com.intraedge.student.jaxb2beans.RegisterStudentResponse;
import com.intraedge.student.jaxb2beans.Student;
import com.intraedge.student.jaxb2beans.StudentName;
import com.intraedge.student.ws.client.IStudentMgmt;

public class StudentMgmtImpl implements IStudentMgmt{
	
//	@Autowired
    private WebServiceTemplate studentWSTemplate;

	public WebServiceTemplate getStudentWSTemplate() {
		return studentWSTemplate;
	}

	public void setStudentWSTemplate(WebServiceTemplate studentWSTemplate) {
		this.studentWSTemplate = studentWSTemplate;
	}

	@Override
	public int registerStudent(Student student) {
		
		RegisterStudentRequest request = new RegisterStudentRequest();
		request.setStudent(student);		
		RegisterStudentResponse response = 
	            (RegisterStudentResponse) studentWSTemplate.marshalSendAndReceive(request);

	    return response.getStudentId();
	}

	@Override
	public List<StudentName> getStudentNames(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getStudentAddress(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneNumber> getStudentPhoneNumbers(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
