package com.qzw.bean;

public class DictType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}