package com.intraedge.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.intraedge.student.utils.NameType;


/**
 * The persistent class for the names database table.
 * 
 */
@Entity
@Table(name="names")
public class Name implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String firstName;

	@Column(nullable=false, length=50)
	private String lastName;

	@Column(length=50)
	private String middleName;

	//bi-directional many-to-one association to Nametype
	@Enumerated(EnumType.ORDINAL)
	@Column(name="nametype_Id",nullable=false)
	private NameType nametype;

	//bi-directional many-to-one association to Student
    @ManyToOne
	@JoinColumn(name="student_Id", nullable=false)
	private Student student;

    public Name() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public NameType getNametype() {
		return this.nametype;
	}

	public void setNametype(NameType nametype) {
		this.nametype = nametype;
	}
	
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}