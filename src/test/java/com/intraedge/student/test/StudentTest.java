package com.intraedge.student.test;

/*import java.util.Calendar;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;*/

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.intraedge.entities.Name;
import com.intraedge.student.dao.StudentDao;
import com.intraedge.student.dao.StudentDaoImpl;
import com.intraedge.student.jaxb2beans.Address;
import com.intraedge.student.jaxb2beans.AddressType;
import com.intraedge.student.jaxb2beans.PhoneNumber;
import com.intraedge.student.jaxb2beans.Student;
import com.intraedge.student.jaxb2beans.StudentName;
import com.intraedge.student.jaxb2beans.StudentType;
import com.intraedge.student.utils.NameType;
import com.intraedge.student.ws.client.impl.StudentMgmtImpl;

public class StudentTest {

//	@Test
	public void testDao() {
		/*StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		student.setDateOfBirth(Calendar.getInstance().getTime());
		Name name = new Name();
		name.setFirstName("testFirstName1");
		name.setLastName("testLastName1");
		name.setMiddleName("testMiddleName");
		name.setNametype(NameType.REGULAR);
		name.setStudent(student);
		student.getNames().add(name);
		studentDao.persist(student);
		
		//Assert.assertEquals(2, student.getId());
		Assert.assertNotNull(student.getNames().get(0));
		
		Student student2 = studentDao.findById(3);
		System.out.println(student2.getNames().get(0).getFirstName());*/
	}
	
	public static void main(String[] args) throws DatatypeConfigurationException {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentService");
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		student.setDateOfBirth(Calendar.getInstance().getTime());
		Name name = new Name();
		name.setFirstName("testFirstName1");
		name.setLastName("testLastName1");
		name.setMiddleName("testMiddleName");
		name.setNametype(NameType.TYPE1);
		student.getNames().add(name);
		studentDao.persist(student);*/
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("testContext.xml");
		StudentMgmtImpl studentMgmt = (StudentMgmtImpl) ctx.getBean("studentMgmt");
		
		Student student = new Student();
		
		GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(Calendar.getInstance().getTimeInMillis());        
		
		student.setDateOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
		
		StudentName name = new StudentName();
		name.setFirstName("testFirstName1");
		name.setLastName("testLastName1");
		name.setMiddleName("testMiddleName");
		name.setType(StudentType.REGULAR);
		
		student.getName().add(name);
		
		Address address = new Address();
		address.setAddressLine1("107");
		address.setAddressLine2("McClintock Dr");
		address.setCity("Phoenix");
		address.setState("AZ");
		address.setPostalCode("12345");
		address.setCountry("USA");
		address.setType(AddressType.PERMANENT);
		
		student.getAddress().add(address);
		
		PhoneNumber phone = new PhoneNumber();
		phone.setCountry("1");
		phone.setAreaCode(4);
		phone.setPhoneNuber(13568);
		phone.setIsPrimary(true);
		student.getPhoneNumber().add(phone);
		
		System.out.println(studentMgmt.getStudentNames(1));
		
		studentMgmt.registerStudent(student);
		
	}

}
