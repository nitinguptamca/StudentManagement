package com.intraedge.student.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.intraedge.entities.Address;
import com.intraedge.entities.Name;
import com.intraedge.entities.Phonenumber;
import com.intraedge.entities.Student;

@Repository("studentDao")
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao{

	@Override
	public List<Address> findAddressByStudentId(Integer studentId) {
		Query query = getEntityManager().createNamedQuery("findAddressById");
		query.setParameter("studentId", studentId);
		return  query.getResultList();
	}

	@Override
	public List<Phonenumber> findPhoneNumbersByStudentId(Integer studentId) {
		Query query = getEntityManager().createNamedQuery("findPhoneNumberById");
		query.setParameter("studentId", studentId);
		return  query.getResultList();
	}

	@Override
	public List<Name> findNamesByStudentId(Integer studentId) {
		Query query = getEntityManager().createNamedQuery("findNamesById");
		query.setParameter("studentId", studentId);
		return  query.getResultList();
	}

	@Override
	public void callStudentProcedure(int studentId) {
		Query query = getEntityManager().createNamedQuery("callStudentStoreProcedure")
				.setParameter("studentId", studentId);
		List result = query.getResultList();
		for(int i=0; i<result.size(); i++){
			Student student = (Student)result.get(i);
			System.out.println("##########" + student.getDateOfBirth());
		}
	}

}
