package com.qzw.bean;

public class Dict implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private DictType dictType;
	private String name;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DictType getDictType() {
		return this.dictType;
	}

	public void setDictType(DictType dictType) {
		this.dictType = dictType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}