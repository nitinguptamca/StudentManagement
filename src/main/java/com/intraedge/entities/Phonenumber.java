package com.intraedge.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phonenumber database table.
 * 
 */
@Entity
@Table(name="phonenumber")
public class Phonenumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="area_code", nullable=false)
	private int areaCode;

	@Column(nullable=false, length=30)
	private String country;

	@Column(name="phone_number", nullable=false)
	private int phoneNumber;

	@Column(nullable=false, length=1)
	private String isprimary;

	//bi-directional many-to-one association to Student
    @ManyToOne
	@JoinColumn(name="student_id", nullable=false)
	private Student student;

    public Phonenumber() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIsprimary() {
		return this.isprimary;
	}

	public void setIsprimary(String isprimary) {
		this.isprimary = isprimary;
	}


	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}