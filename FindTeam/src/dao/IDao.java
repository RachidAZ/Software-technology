package dao;

import java.util.List;

import metier.Admin;
import metier.Like;
import metier.member;
import metier.project;

public interface IDao {

	
	

	
	// project
	public void addProject(project p);
	public List<project> getProjects(Admin admin);
	public List<project> getProjects(String descri);
	public void deleteProject (int id_project);
	public project getProjectById(int id_project);
	public void UpdateProject(project p);
	
	
	// Member
	public void addMember(member memberA);
	public List<member> getMembers();
	public member getMember ( int id_member);
	public void deleteMember (int id_member);
	public void UpdateMember ( member newMember);
		
	//Likes
	public void doMatch (Like like);
	public void addLike ( Like like);
	public List<Like> getLikes ();
	public void UpdateLike ( Like like);
	public void deleteLike (int id_like);
	
	
	//Admin 
	public List<Admin> getAdmins ();
	
	// in the matching interface, show the members we they have matches less then project.MaxInteam
	
		
	
	
	
}
