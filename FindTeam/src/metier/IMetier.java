package metier;

import java.util.Hashtable;
import java.util.List;

public interface IMetier {

	
	
	// project
	public void addProject(project p);
	public List<project> getProjects(Admin admin);
	public List<project> getProjects(String descri);
	public void deleteProject (int id_project);
	
	// Member
	public void addMember(member memberA);
	public List<member> getMembers();
	public List<member> getActiveMembers(); // who complete their profile
	public member getMember(String email);
	public void deleteMember (int id_member);
	public void UpdateMember (int memberToUpdate, member newMember);
		
	//Likes
	public void doMatch (Like like);
	public void addLike ( Like like);
	public List<Like> getMatches ();
	
	
	// in the matching interface, show the members we they have matches less then project.MaxInteam
	
	
	// utilities 
	
	public String getMD5(String string);
	public int getNombreMatchofMember(int idMember);
	public Hashtable<Integer, List<Integer>>  getGroups ();
	
	
	
	
	
	
	
	
	
}
