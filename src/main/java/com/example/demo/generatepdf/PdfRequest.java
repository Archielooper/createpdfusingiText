package com.example.demo.generatepdf;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PdfRequest {

	@NotNull
	@Size(min = 2, max = 30, message = "{validation.fullname.size}")
	@Pattern(regexp = "[-A-Za-z]*", message = "{validation.fullname.pattern}")
	private String firstname;

	
	@Pattern(regexp = "[-A-Za-z]*", message = "{validation.fullname.pattern}")
	private String middlename;

	@NotNull
	@Size(min = 2, max = 30, message = "{validation.fullname.size}")
	@Pattern(regexp = "[-A-Za-z]*", message = "{validation.fullname.pattern}")
	private String lastname;

	@NotNull
	@Size(min = 2, max = 30, message = "{validation.fullname.size}")
	@Pattern(regexp = "[-A-Za-z]*", message = "{validation.fullname.pattern}")
	private String fatherfirstname;

	@NotNull
	@Size(min = 2, max = 30, message = "{validation.fullname.size}")
	@Pattern(regexp = "[-A-Za-z]*", message = "{validation.fullname.pattern}")
	private String fathermiddlename;

	@NotNull
	@Size(min = 2, max = 30, message = "{validation.fullname.size}")
	@Pattern(regexp = "[-A-Za-z]*", message = "{validation.fullname.pattern}")
	private String fatherlastname;

	@NotNull
	@Pattern(regexp = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$", message = "{validation.dob.pattern}")
	private String dob;

	@NotNull
	@Pattern(regexp = "[A-Z]{3}[P][A-Z][0-9]{4}[A-Z]{1}", message = "{validation.pan.pattern}")
	private String pancard;

	@NotNull
	@Size(min = 5, max = 300, message = "{validation.address.size}")
	private String address;
	private Short addresscityid;
	private Short addressstateid;

	@NotNull
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "{validation.pin.pattern}")
	private String addresspincode;

	@NotNull(message = "{validation.email.notnull}")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "{validation.email.pattern}")
	private String email;

	@NotNull(message = "{validation.mobile.notnull}")
	@Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "{validation.mobile.pattern}")
	private String phone;
	private Short birthcityid;
	private Short birthstateid;

	public Short getAddresscityid() {
		return addresscityid;
	}

	public void setAddresscityid(Short addresscityid) {
		this.addresscityid = addresscityid;
	}

	public Short getAddressstateid() {
		return addressstateid;
	}

	public void setAddressstateid(Short aadresssatateid) {
		this.addressstateid = aadresssatateid;
	}

	public Short getBirthcityid() {
		return birthcityid;
	}

	public void setBirthcityid(Short cityid) {
		this.birthcityid = cityid;
	}

	public Short getBirthstateid() {
		return birthstateid;
	}

	public void setBirthstateid(Short stateid) {
		this.birthstateid = stateid;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFatherfirstname() {
		return fatherfirstname;
	}

	public void setFatherfirstname(String ffirstname) {
		this.fatherfirstname = ffirstname;
	}

	public String getFathermiddlename() {
		return fathermiddlename;
	}

	public void setFathermiddlename(String fmiddlename) {
		this.fathermiddlename = fmiddlename;
	}

	public String getFatherlastname() {
		return fatherlastname;
	}

	public void setFatherlastname(String flastname) {
		this.fatherlastname = flastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pan) {
		this.pancard = pan;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddresspincode() {
		return addresspincode;
	}

	public void setAddresspincode(String addressPin) {
		this.addresspincode = addressPin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
