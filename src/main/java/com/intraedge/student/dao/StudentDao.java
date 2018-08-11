package com.intraedge.student.dao;

import java.util.List;

import com.intraedge.entities.Address;
import com.intraedge.entities.Name;
import com.intraedge.entities.Phonenumber;
import com.intraedge.entities.Student;

public interface StudentDao extends GenericDao<Student> {
	
	List<Address> findAddressByStudentId(Integer studentId);
	
	List<Phonenumber> findPhoneNumbersByStudentId(Integer studentId);
	
	List<Name> findNamesByStudentId(Integer studentId);

	void callStudentProcedure(int studentId);

}
