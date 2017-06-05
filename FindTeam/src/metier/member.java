package metier;

import java.io.Serializable;


public class member implements Serializable {

	private int Id_user;
	private String Name;
	private String Last_name;
	private int Age;
	private String Languages;
	private String Neptun;
	private String Email;
	private String Skills;
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
	public int getId_user() {
		return Id_user;
	}
	public void setId_user(int id_user) {
		Id_user = id_user;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getLanguages() {
		return Languages;
	}
	public void setLanguages(String languages) {
		Languages = languages;
	}
	public String getNeptun() {
		return Neptun;
	}
	public void setNeptun(String neptun) {
		Neptun = neptun;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	public member(String name, String last_name, int age, String languages,
			String neptun, String email, String skills) {
		super();
		Name = name;
		Last_name = last_name;
		Age = age;
		Languages = languages;
		Neptun = neptun;
		Email = email;
		Skills = skills;
	}
	public member() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
