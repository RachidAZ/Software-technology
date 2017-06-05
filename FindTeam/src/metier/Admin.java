package metier;

import java.io.Serializable;

public class Admin implements Serializable {

	
	private int Admin_id;
	private String Name;
	private String Email;
	private String Password;
	private String Role;
	
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(int admin_id) {
		Admin_id = admin_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Admin(String name, String email) {
		super();
		Name = name;
		Email = email;
	}
	public Admin() {
		super();
	}
	
	
	
	
	
	
	
}
