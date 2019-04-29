package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	private short stateid;
	public short getStateid() {
		return stateid;
	}

	public void setStateid(short stateId) {
		this.stateid = stateId;
	}

	private String statename;

	

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

}
