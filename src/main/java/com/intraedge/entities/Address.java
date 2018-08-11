package com.intraedge.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.intraedge.student.utils.AddressType;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String addressLine1;

	@Column(length=100)
	private String addressLine2;

	@Column(nullable=false, length=30)
	private String city;

	@Column(nullable=false, length=30)
	private String country;

	@Column(nullable=false, length=6)
	private String postalcode;

	@Column(nullable=false, length=30)
	private String state;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="addresstype_Id",nullable=false)
	private AddressType addresstype;

	//bi-directional many-to-one association to Student
    @ManyToOne
	@JoinColumn(name="student_Id", nullable=false)
	private Student student;

    public Address() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressType getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(AddressType addresstype) {
		this.addresstype = addresstype;
	}
	
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}