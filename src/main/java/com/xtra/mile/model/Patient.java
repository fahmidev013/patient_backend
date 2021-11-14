
package com.xtra.mile.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {

	private int pid;
	private String firstname;
	private String lastname;
	private Date dob;
    private String gender;
    private String address;
    private String suburb;
    private String state;
    private int postcode;
    private String phone;
	
	public Patient() {
		
	}
	
	public Patient(String firstname, String lastname, Date dob, String gender, String address, String suburb, String state, int postcode, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
        this.dob = dob;
		this.gender = gender;
        this.address = address;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.phone = phone;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPID() {
		return pid;
	}
	public void setPID(int pid) {
		this.pid = pid;
	}
	
	@Column(name = "firstname", nullable = false)
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "lastname", nullable = false)
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

    @Column(name = "dob", nullable = false)
	public Date getDOB() {
		return dob;
	}
	public void setDOB(Date dob) {
		this.dob = dob;
	}
	
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

    @Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "suburb", nullable = false)
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

    @Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "postcode", nullable = false)
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

    @Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", firstname=" + firstname + 
        ", lastname=" + lastname + ", dob=" + dob + ", gender=" + gender +
        ", address=" + address + ", suburb=" + suburb + ", state=" + state +
        ", postcode=" + postcode + ", phone=" + phone
				+ "]";
	}
	
}