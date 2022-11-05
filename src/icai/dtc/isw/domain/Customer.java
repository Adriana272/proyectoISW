package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String password;
	private String name;
	
	public Customer(int id, String password, String name) {
		this.setName(name);
		this.setId(id);
		this.setPw(password);
	}

	public int getId() {
		return id;
	}

	public String getPw() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPw(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
