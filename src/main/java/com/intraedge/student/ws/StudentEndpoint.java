package com.intraedge.student.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.intraedge.student.jaxb2beans.Address;
import com.intraedge.student.jaxb2beans.GetStudentAddressRequest;
import com.intraedge.student.jaxb2beans.GetStudentAddressResponse;
import com.intraedge.student.jaxb2beans.GetStudentNamesRequest;
import com.intraedge.student.jaxb2beans.GetStudentNamesResponse;
import com.intraedge.student.jaxb2beans.GetStudentPhoneNumbersRequest;
import com.intraedge.student.jaxb2beans.GetStudentPhoneNumbersResponse;
import com.intraedge.student.jaxb2beans.ObjectFactory;
import com.intraedge.student.jaxb2beans.PhoneNumber;
import com.intraedge.student.jaxb2beans.RegisterStudentRequest;
import com.intraedge.student.jaxb2beans.RegisterStudentResponse;
import com.intraedge.student.jaxb2beans.StudentName;
import com.intraedge.student.service.StudentService;

@Component(value="studentEndpoint")
@Endpoint
public class StudentEndpoint {
	
	private StudentService studentService;
	
	private ObjectFactory objectFactory;
	
	@Autowired
	public StudentEndpoint(StudentService studentService){
		this.studentService = studentService;
		this.objectFactory = new ObjectFactory();
	}
	
	@PayloadRoot(localPart="RegisterStudentRequest" , namespace="http://www.intraedge.org/student/messages")
	@ResponsePayload
	public RegisterStudentResponse registerStudent(@RequestPayload RegisterStudentRequest request){
		int studentId = this.studentService.registerStudent(request.getStudent());
		RegisterStudentResponse response = objectFactory.createRegisterStudentResponse();
		
		//test stored procedure
		this.studentService.callStudentProcedure(studentId);
		
		response.setStudentId(studentId);
		return response;
	}
	
	@PayloadRoot(localPart="GetStudentNamesRequest", namespace="http://www.intraedge.org/student/messages")
	@ResponsePayload
	public GetStudentNamesResponse getStudentNames(@RequestPayload GetStudentNamesRequest request){
		int studentId = request.getStudentId();
		List<StudentName> nameList = this.studentService.getStudentNames(studentId);
		GetStudentNamesResponse response = objectFactory.createGetStudentNamesResponse();
		response.getStudentNames().addAll(nameList);
		return response;
	}
	
	@PayloadRoot(localPart="GetStudentAddressRequest", namespace="http://www.intraedge.org/student/messages")
	@ResponsePayload
	public GetStudentAddressResponse getStudentAddress(@RequestPayload GetStudentAddressRequest request){
		int studentId = request.getStudentId();
		List<Address> addressList = this.studentService.getStudentAddress(studentId);
		GetStudentAddressResponse response = objectFactory.createGetStudentAddressResponse();
		response.getAddress().addAll(addressList);
		return response;
	}
	
	@PayloadRoot(localPart="GetStudentPhoneNumbersRequest", namespace="http://www.intraedge.org/student/messages")
	@ResponsePayload
	public GetStudentPhoneNumbersResponse getStudentPhoneNumbers(@RequestPayload GetStudentPhoneNumbersRequest request){
		int studentId = request.getStudentId();
		List<PhoneNumber> phoneList = this.studentService.getStudentPhoneNumbers(studentId);
		GetStudentPhoneNumbersResponse response = objectFactory.createGetStudentPhoneNumbersResponse();
		response.getPhoneNumber().addAll(phoneList);
		return response;
	}
}
