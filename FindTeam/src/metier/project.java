package metier;

import java.io.Serializable;
import java.util.Date;

public class project implements Serializable {
	
	private int project_id;
	private String Description;
	private Date Deadline;
	private int Max_Inteam;
	private boolean ShowMatch;
	private Admin admin;
	
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getDeadline() {
		return Deadline;
	}
	public void setDeadline(Date deadline) {
		Deadline = deadline;
	}
	public int getMax_Inteam() {
		return Max_Inteam;
	}
	public void setMax_Inteam(int max_Inteam) {
		Max_Inteam = max_Inteam;
	}
	public boolean isShowMatch() {
		return ShowMatch;
	}
	public void setShowMatch(boolean showMatch) {
		ShowMatch = showMatch;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public project(String description, Date deadline, int max_Inteam,
			boolean showMatch, Admin admin) {
		super();
		Description = description;
		Deadline = deadline;
		Max_Inteam = max_Inteam;
		ShowMatch = showMatch;
		this.admin = admin;
	}
	public project() {
		super();
	}
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
