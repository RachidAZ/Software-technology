package metier;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import dao.DaoImplementation;

public class MetierImplementation implements IMetier {

	
	DaoImplementation dao = new DaoImplementation();
	
	
	
	@Override
	public void addProject(project p) {
		dao.addProject(p);
		
	}

	@Override
	public List<project> getProjects(Admin admin) {
		
		return dao.getProjects(admin);
		
	}

	@Override
	public List<project> getProjects(String descri) {
		
		return dao.getProjects(descri);
	}

	@Override
	public void deleteProject(int id_project) {
		dao.deleteProject(id_project);
		
	}

	@Override
	public void addMember(member memberA) {
		dao.addMember(memberA);
		
	}

	@Override
	public List<member> getMembers() {
		
		return dao.getMembers();
	}

	@Override
	public List<member> getActiveMembers() {
	
		List<member> memnersActive =dao.getMembers();
		
		// keep just members where the passowrd is specified
		
		return null;
	}

	@Override
	public void deleteMember(int id_member) {
		dao.deleteMember(id_member);
		
	}

	@Override
	public void UpdateMember(int memberToUpdate, member newMember) {
			dao.UpdateMember(newMember);
		
	}

	@Override
	public void doMatch(Like like) {
		dao.doMatch(like);
		
	}

	@Override
	public void addLike(Like like) {
		dao.addLike(like);
		
	}

	@Override
	public List<Like> getMatches() {
		//
		return null;
	}

	@Override
	public member getMember(String email) {
		
		List<member> listM = dao.getMembers();
		
		for (member m : listM ){
			if(m.getEmail().equals(email)) 
			return m;
			
			
		}
		
		
		return null;
		
	}

	
	public String getMD5(String string) {
		String result=null;
		 
        MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(string.getBytes(),0,string.length());
		    
		    result="0" + new BigInteger(1,m.digest()).toString(16);
		    
		    System.out.println(string);
		    System.out.println(result);
		    
		        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
	
	
	return result;
	}

	
	
	

	public int getNombreMatchofMember(int idMember){
		
		List<Like> listM = dao.getLikes();
		int i=0;
		for (Like m : listM){
			
			if ( (m.getMemberA().getId_user()==idMember || m.getMemberB().getId_user()==idMember) && m.getIsMatch()=='Y') {
				
				i++;
				
				
			}
			
			
		}
		
		
		return i;
		
	}
	
	
	
	
	public Hashtable<Integer, List<Integer>>  getGroups () {
		
		Hashtable<Integer, List<Integer>> matches = new Hashtable<Integer, List<Integer>>();
		
		
		List<Like> AlllikesList = dao.getLikes();
		List<Like> MatchedlikesList = new ArrayList<Like>(); 
		
		for(Like l : AlllikesList) {
			if(l.getIsMatch()=='Y')  MatchedlikesList.add(l);
			
		}
		
		
		for(Like l : MatchedlikesList) {
			
			
			
			if (!matches.containsKey(l.getMemberA().getId_user())) {
				
				List<Integer> memberMatched = new ArrayList<Integer>();
				memberMatched.add(l.getMemberB().getId_user());
				matches.put(l.getMemberA().getId_user(), memberMatched );
				
				
				
			}
			
			for(Like e : MatchedlikesList) {
				
			
		//	matches.put(l.getMemberA().getId_user(), l.getMemberB().getId_user());
			
			}
			
		}
		
		
		return null;
		
		
		
	}
	
	
	
	
	//--------------------------
	

	public static ArrayList<Integer> getMatchs (int a,int b,ArrayList<member> a2) {
		ArrayList<Integer> nouveau = new ArrayList<Integer>();

		nouveau.add(a);
		nouveau.add(b);
		/*for(int i = 0 ; i < a2.size(); i++){
			if((a2.get(i).Member_A == a || a2.get(i).Member_A == b)  && a2.get(i).ISMATCH=='Y'&& !nouveau.contains(a2.get(i).Member_B)) {nouveau.add(a2.get(i).Member_B);a2.get(i).InGroup='Y';}
			else if((a2.get(i).Member_B== a || a2.get(i).Member_B== b) && a2.get(i).ISMATCH=='Y'&& !nouveau.contains(a2.get(i).Member_A)) {nouveau.add(a2.get(i).Member_A); a2.get(i).InGroup='Y'; }

		}*/
		return nouveau;
	}
	public static ArrayList<Integer> finalgetMatchs (int a,ArrayList<member> a2,ArrayList<Integer> a3) {
		/*for(int i = 0 ; i < a2.size(); i++){
			if((a2.get(i).Member_A == a)  && a2.get(i).ISMATCH=='Y') {if(!a3.contains(a2.get(i).Member_B)) a3.add(a2.get(i).Member_B);a2.get(i).InGroup='Y';}
			else if((a2.get(i).Member_B== a ) && a2.get(i).ISMATCH =='Y' ) {if(!a3.contains(a2.get(i).Member_A))a3.add(a2.get(i).Member_A); a2.get(i).InGroup='Y'; }

		}*/
		return a3;
	}
	public static ArrayList<ArrayList<Integer>> GetGroups (ArrayList<member> a2){

		ArrayList<ArrayList<Integer> > Groups = new ArrayList<ArrayList<Integer> >();

		for(int i=0 ; i < a2.size();i++){

			/*if(a2.get(i).InGroup=='N'&&a2.get(i).ISMATCH=='Y'){
				ArrayList<Integer> k = getMatchs(a2.get(i).Member_A,a2.get(i).Member_B,a2);a2.get(i).InGroup='Y'
						;
				for (int j = 0; j < k.size(); j++) {
					k=finalgetMatchs(k.get(j), a2, k);
				}
				Groups.add( k); 
			}*/
		}
		return Groups; 
	}
	public static ArrayList<Integer> GetMembersWithoutTeam(ArrayList<ArrayList<Integer>> j,ArrayList<member> a2){
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		System.out.println(j.size());
		for (int i = 0; i < a2.size(); i++) {
		/*
				if(ifingroup(j, a2.get(i).Member_A)&& !a.contains(a2.get(i).Member_A)) a.add(a2.get(i).Member_A);
				if(ifingroup(j, a2.get(i).Member_B)&& !a.contains(a2.get(i).Member_B)) a.add(a2.get(i).Member_B);
	*/

		}
		return a;
	}
	public static boolean ifingroup(ArrayList<ArrayList<Integer>> k , int b){
		for (int i = 0; i < k.size(); i++) {
			if(k.get(i).contains(b)) return false;
		}
		return true;
	}
	
	
	
	
	
	
	
}
