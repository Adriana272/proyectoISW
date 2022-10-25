package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String name;
	
	public Customer() {
		this.setId(new String());
		this.setPw(new String());
		this.setName(new String());
	}
	
	public Customer(String id, String password, String name) {
		this.setName(name);
		this.setId(id);
		this.setPw(password);
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return password;
	}

	public void setId(String id) {
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
