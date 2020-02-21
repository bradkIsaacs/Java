package login.test;

import java.util.*;

public class Person {
	String name, password;
	ArrayList<String> arl = new ArrayList<String>();
	
	public Person(String name, String password, ArrayList<String> arl) {
		super();
		this.name = name;
		this.password = password;
		this.arl = arl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getArl() {
		return arl;
	}

	public void setArl(ArrayList<String> arl) {
		this.arl = arl;
	}
	
}
