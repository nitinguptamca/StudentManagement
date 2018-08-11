package com.intraedge.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@NamedQueries({
	@NamedQuery(
			name = "findAddressById", 
			query = "SELECT addresses FROm Student s where " +
					"s.id = :studentId"
	),
	@NamedQuery(
			name = "findPhoneNumberById", 
			query = "SELECT phonenumbers FROm Student s where " +
					"s.id = :studentId"
	),
	@NamedQuery(
			name = "findNamesById", 
			query = "SELECT names FROm Student s where " +
					"s.id = :studentId"
	)
})

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callStudentStoreProcedure",
	query = "CALL GetStudent(:studentId)",
	resultClass = Student.class
	)
})   

@Entity
@Table(name="student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dateOfBirth;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private List<Address> addresses = new ArrayList<Address>();

	//bi-directional many-to-one association to Name
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private List<Name> names = new ArrayList<Name>();

	//bi-directional many-to-one association to Phonenumber
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Phonenumber> phonenumbers = new ArrayList<Phonenumber>();

    public Student() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Name> getNames() {
		return this.names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}
	
	public List<Phonenumber> getPhonenumbers() {
		return this.phonenumbers;
	}

	public void setPhonenumbers(List<Phonenumber> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	
}