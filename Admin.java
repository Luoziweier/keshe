package com;

/**
 * @author 沉睡的芭芭拉
 */
public class Admin {
	private String id;
	private String name;
	private String password;
	void setId(String id) {
	    this.id=id;
	}
	void setName(String name) {
	    this.name=name;
	}
	void setPassword(String password) {
	    this.password=password;
	}
	
	String getId() {
	    return this.id;
	}
	String getName() {
	    return this.name;
	}
	String getPassword() {
	    return this.password;
	}

}
