package com.intraedge.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intraedge.entities.Name;
import com.intraedge.entities.Phonenumber;
import com.intraedge.student.dao.StudentDao;
import com.intraedge.student.jaxb2beans.Address;
import com.intraedge.student.jaxb2beans.PhoneNumber;
import com.intraedge.student.jaxb2beans.Student;
import com.intraedge.student.jaxb2beans.StudentName;
import com.intraedge.student.utils.MappingUtils;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Transactional
	public int registerStudent(Student student) {
		com.intraedge.entities.Student studentEntity = studentDao.persist(MappingUtils.convertStudentXMLToEntity(student));
		return studentEntity.getId();
	}

	public List<StudentName> getStudentNames(int studentId) {
		List<Name> names = studentDao.findNamesByStudentId(studentId);
		if(names == null || names.size() == 0){
			throw new StudentNotFoundException("Student Not Found");
		}
		List<StudentName> nameXMLList = new ArrayList<StudentName>();
		for(Name name : names){
			nameXMLList.add(MappingUtils.convertNameEntityToXML(name));
		}
		return nameXMLList ;
	}

	public List<Address> getStudentAddress(int studentId) {
		List<com.intraedge.entities.Address> addresses = studentDao.findAddressByStudentId(studentId);
		List<Address> addressXMLList = new ArrayList<Address>();
		for(com.intraedge.entities.Address address : addresses){
			addressXMLList.add(MappingUtils.convertAddressEntityToXML(address));
		}
		return addressXMLList;
	}

	public List<PhoneNumber> getStudentPhoneNumbers(int studentId) {
		List<Phonenumber> phoneList = studentDao.findPhoneNumbersByStudentId(studentId);
		List<PhoneNumber> phoneXMLList = new ArrayList<PhoneNumber>();
		for(Phonenumber phone : phoneList){
			phoneXMLList.add(MappingUtils.convertPhoneEntityToXML(phone));
		}
		return phoneXMLList;
	}

	@Override
	public void callStudentProcedure(int studentId) {
		studentDao.callStudentProcedure(studentId);
	}

}
