package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

	
	@Id
	private short cityid;
	private String cityname;

	public short getCityid() {
		return cityid;
	}

	public void setCityid(short cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

}
