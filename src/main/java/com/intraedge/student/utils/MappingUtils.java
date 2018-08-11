package com.intraedge.student.utils;

import java.util.List;

import com.intraedge.entities.Address;
import com.intraedge.entities.Name;
import com.intraedge.entities.Phonenumber;
import com.intraedge.entities.Student;
import com.intraedge.student.jaxb2beans.PhoneNumber;
import com.intraedge.student.jaxb2beans.StudentName;
import com.intraedge.student.jaxb2beans.StudentType;

public class MappingUtils {
	
	public static Student convertStudentXMLToEntity(com.intraedge.student.jaxb2beans.Student studentXML){
		Student student = new Student();
		student.setDateOfBirth(studentXML.getDateOfBirth().toGregorianCalendar().getTime());
		List<com.intraedge.student.jaxb2beans.Address> addressListXML = studentXML.getAddress();
		if(addressListXML != null){
			for(com.intraedge.student.jaxb2beans.Address addressXML : addressListXML){
				Address address = convertAddressXMLToEntity(addressXML);
				address.setStudent(student);
				student.getAddresses().add(address);
			}
		}
		List<PhoneNumber> phoneNumberListXML = studentXML.getPhoneNumber();
		if(phoneNumberListXML != null){
			for(PhoneNumber phoneNumberXML : phoneNumberListXML){
				Phonenumber phonenumber = convertPhoneXMLToEntity(phoneNumberXML);
				phonenumber.setStudent(student);
				student.getPhonenumbers().add(phonenumber);
			}
		}
		List<StudentName> nameListXML = studentXML.getName();
		if(nameListXML != null){
			for(StudentName nameXML : nameListXML){
				Name name = convertNameXMLTOEntity(nameXML);
				name.setStudent(student);
				student.getNames().add(name);
			}
		}
		
		return student;
	}
	
	public static Phonenumber convertPhoneXMLToEntity(PhoneNumber phoneNumberXML){
		Phonenumber phonenumber = new Phonenumber();
		phonenumber.setAreaCode(phoneNumberXML.getAreaCode());
		phonenumber.setCountry(phoneNumberXML.getCountry());
		phonenumber.setPhoneNumber(phoneNumberXML.getPhoneNuber());
		phonenumber.setIsprimary(phoneNumberXML.isIsPrimary()?"T":"N");
		return phonenumber;
	}
	
	public static PhoneNumber convertPhoneEntityToXML(Phonenumber phonenumber){
		PhoneNumber phoneNumberXML = new PhoneNumber();
		phoneNumberXML.setAreaCode(phonenumber.getAreaCode());
		phoneNumberXML.setCountry(phonenumber.getCountry());
		phoneNumberXML.setPhoneNuber(phonenumber.getPhoneNumber());
		phoneNumberXML.setIsPrimary(phonenumber.getIsprimary().equals("T")?true:false);
		return phoneNumberXML;
	}
	
	public static Address convertAddressXMLToEntity(com.intraedge.student.jaxb2beans.Address addressXML){
		Address address = new Address();
		address.setAddressLine1(addressXML.getAddressLine1());
		address.setAddressLine2(addressXML.getAddressLine2());
		address.setAddresstype(AddressType.valueOf(addressXML.getType().value()));
		address.setCity(addressXML.getCity());
		address.setCountry(addressXML.getCountry());
		address.setState(addressXML.getState());
		address.setPostalcode(addressXML.getPostalCode());
		return address;
	}
	
	public static com.intraedge.student.jaxb2beans.Address convertAddressEntityToXML(Address address){
		com.intraedge.student.jaxb2beans.Address addressXML = new com.intraedge.student.jaxb2beans.Address();
		addressXML.setAddressLine1(address.getAddressLine1());
		addressXML.setAddressLine2(address.getAddressLine2());
		addressXML.setType(com.intraedge.student.jaxb2beans.AddressType.valueOf(address.getAddresstype().name()));
		addressXML.setCity(address.getCity());
		addressXML.setCountry(address.getCountry());
		addressXML.setState(address.getState());
		addressXML.setPostalCode(address.getPostalcode());
		return addressXML;
	}
	
	public static Name convertNameXMLTOEntity(StudentName nameXML){
		Name name = new Name();
		name.setFirstName(nameXML.getFirstName());
		name.setLastName(nameXML.getLastName());
		name.setMiddleName(nameXML.getMiddleName());
		name.setNametype(NameType.valueOf(nameXML.getType().name()));
		return name;
	}
	
	public static StudentName convertNameEntityToXML(Name name){
		StudentName nameXML = new StudentName();
		nameXML.setFirstName(name.getFirstName());
		nameXML.setLastName(name.getLastName());
		nameXML.setMiddleName(name.getMiddleName());
		nameXML.setType(StudentType.valueOf(name.getNametype().name()));
		return nameXML;
	}

}
