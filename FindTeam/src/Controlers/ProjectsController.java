package Controlers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import metier.Admin;
import metier.Like;
import metier.member;
import metier.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import dao.DaoImplementation;


// //---------  The User   --------------
// 	  This Controller contains the methodes for the User and The Admin 
//    In this controller we have the methodes to manage the operations below : 
// -- project displaying
// -- display to the user a page to Complete his profile after first access
//--  add like  --> convert it to a Match if the like is mutual 
//--
//---------  The Admin   --------------
// 
// -- add a member   
//-- project creation
//-- project displaying
//-- 
//
//
//
//





@Controller
public class ProjectsController {

	DaoImplementation dao = new DaoImplementation();
	
	@RequestMapping(value="/projects")
public String listProjects(Model m, HttpServletRequest req){
		
		// redirect to authentication page if the user is not connected  
				if (req.getSession().getAttribute("UserID")==null )  
					return "redirect:/authen";
		
		List<project> listP = dao.getProjects((Admin)null);
	//	m.addAttribute("titre","Liste projects");
		m.addAttribute("listP",listP);
		
		
		return "listProjects";
		
	}
	
	
	
	@RequestMapping(value="/addLike")
	public void addLike(Model m, HttpServletRequest req){
			
		
		
		
	}
	
	
	
	@RequestMapping(value="/getProject/{idProject}")
	public String getProject(Model m, HttpServletRequest req,@PathVariable("idProject") String idProject){
			
		// redirect to authentication page if the user is not connected  
		if (req.getSession().getAttribute("UserID")==null )  
			return "redirect:/authen";

		
			
			List<member> listM = dao.getMembers();
			
			// remove the current user from the list
			member memtoDelete=null;
//			for(member mem : listM){
//				if (mem.getId_user()==Integer.parseInt( req.getSession().getAttribute("UserID").toString()) )
//					memtoDelete=mem; break;
//					
//			}
			
			memtoDelete=dao.getMember(Integer.parseInt( req.getSession().getAttribute("UserID").toString()));
			
			listM.remove(memtoDelete);
			
			// delete members who didnot compete their profile ( password=null)
			List<member> listtoDelete =new ArrayList<member>();
			
			for(member mem : listM){

				if (mem.getPassword()== null )
					listtoDelete.add(mem);
					
			}
			
			for(member mem : listtoDelete){

				listM.remove(mem);	
					
			}
					
			
			
			m.addAttribute("titre","Liste members");
			m.addAttribute("listM",listM);
			
			
			return "getProject";
			
		}
	
	
	// page for completing the member profile for the first acess , then call control UpdateMember for saving data
	@RequestMapping(value="/CompletMemberProfil")
	public String CompletMemberProfil(Model m, HttpServletRequest req){
			
		// redirect to authentication page if the user is not connected  
		if (req.getSession().getAttribute("UserID")==null )  
			return "redirect:/authen";
			
		
			return "MemberCompleteProfile";
			
		}
	
	
	

	public String getMD5 (String string) {
		
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
	

	
	
	
	@RequestMapping(value="/UpdateMember")
	public String UpdateMember(member memForm, HttpServletRequest req){
			
		// redirect to authentication page if the user is not connected  
		if (req.getSession().getAttribute("UserID")==null )  
			return "redirect:/authen";
			
			
			member dbMember = dao.getMember(Integer.parseInt(req.getSession().getAttribute("UserID").toString()));
//	//		newMember.setId_user(Integer.parseInt(req.getSession().getAttribute("UserID").toString()));
//			newMember.setAge(memForm.getAge());
			
			//memForm.setId_user(Integer.parseInt(req.getSession().getAttribute("UserID").toString()));
			//memForm.setEmail(dbMember.getEmail());
			dbMember.setAge(memForm.getAge());
			dbMember.setName(memForm.getName());
			dbMember.setLast_name(memForm.getLast_name());
			dbMember.setLanguages(memForm.getLanguages());
			dbMember.setSkills(memForm.getSkills());
			
			
			
			
			
			 String MD5Password=memForm.getPassword();
	
				dbMember.setPassword(this.getMD5(MD5Password));
			
				dao.UpdateMember(dbMember);
			
			
			return "redirect:/projects";
			
		}
	
	
	
	int getNombreMatchofMember(int idMember){
		
		List<Like> listM = dao.getLikes();
		int i=0;
		for (Like m : listM){
			
			if ( (m.getMemberA().getId_user()==idMember || m.getMemberB().getId_user()==idMember) && m.getIsMatch()=='Y') {
				
				i++;
				
				
			}
			
			
		}
		
		
		return i;
		
	}
	
	
	
	
	void getGroups () {
		
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
		
		
		
		
		
		
	}
	
	
	
	void addMatch(int idMemberA, int idMemberB, project proj){
		
		List<Like> listM = dao.getLikes();
	
		
		if (getNombreMatchofMember(idMemberA)+getNombreMatchofMember(idMemberB)+1>=proj.getMax_Inteam())
		return;
		
		// A has already liked B --> set a match 
		for (Like m : listM){
		if (m.getMemberA().getId_user()==idMemberB && m.getMemberB().getId_user()==idMemberA ){
			
		//	m.setIsMatch(true);
		//	dao.UpdateLike(m);
			
			Like like = new Like(m.getMemberA(), m.getMemberB(), m.getProject(), m.getDate_like(), 'Y');
			dao.deleteLike(m.getLikeID());			
			dao.addLike(like);
			
			
			
			return;
		}
		else if (m.getMemberA().getId_user()==idMemberA  && m.getMemberB().getId_user()==idMemberB ){
			
			
			return;
		}
			
		}
		
		// otherwise : add like 
		
		
		
		dao.addLike(new Like(dao.getMember(idMemberA), dao.getMember(idMemberB), proj, new Date(), 'N'));
		
			
		
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/ajaxtest", method = RequestMethod.POST)     
	public String addLike(@RequestParam("IdUser") String IdUser, HttpServletRequest req) {
 
		 System.out.println("AAAAAA");
		 System.out.println("IdUser : "+IdUser);
		 System.out.println("request : "+req.getSession().getAttribute("UserID").toString());
//        
		 int  M1=Integer.parseInt(	req.getSession().getAttribute("UserID").toString());
		 int  M2=Integer.parseInt(IdUser);
//		 
		 project currentProject = new project();
			currentProject.setProject_id(2);
			currentProject.setMax_Inteam(2);
			
//			Like like = new Like(M1, M2, currentProject, new Date(), false);
//			dao.addLike(like);
//		 
//			
			
		 
		 
		 addMatch(M1, M2, currentProject);
		 
		 
		 
			
			
        String result = "done";      
        return result;
    }
	
	
	
	
	//---------------------                 -----------------------------//
	// < -----------------  Admin methodes  ------------------  >
	// --------------------                 ----------------------//
	
	
	@RequestMapping(value="/AdminPage")
	public String getProjects(Model m, HttpServletRequest req){
		
		// redirect to authentication page if the user is not connected or if is not an Admin 
		if (req.getSession().getAttribute("UserID")==null || !req.getSession().getAttribute("Role").equals("admin") )  
			return "redirect:/authen";
		
		
	List<project> listProjects=	dao.getProjects((Admin)null);
		
		 m.addAttribute("ProjectsCount",listProjects.size());
	 	 m.addAttribute("listP",listProjects);  
		 m.addAttribute("added","none");  // show msg project has been added 

		 
//		 req.getSession().invalidate();
//		 System.out.println(	 "from the Admin page :  " +  req.getSession().getAttribute("sessionAttr"));
//			
			return "AdminViews/AdminAddProject";
			
		}
	
	
	@RequestMapping(value="/addproject")
	public String addProject(project proj, Model m){
		
		dao.addProject(proj);
		
		List<project> listProjects=	dao.getProjects((Admin)null);
		
		 m.addAttribute("ProjectsCount",listProjects.size());
	 	 m.addAttribute("listP",listProjects);  
		 m.addAttribute("added","block");
		
			
		return "AdminViews/AdminAddProject";
			
			
		}
	
	
	
	@RequestMapping(value="/AdminMembers")
	public String Members(Model m, HttpServletRequest req){
		
		// redirect to authentication page if the user is not connected or if is not an Admin 
		if (req.getSession().getAttribute("UserID")==null || !req.getSession().getAttribute("Role").equals("admin") )  
			return "redirect:/authen";
		
		
	List<member> listMembers=	dao.getMembers();
		
		 m.addAttribute("MembersCount",listMembers.size());
	 	 m.addAttribute("listM",listMembers);  
		 m.addAttribute("added","none");  // show msg project has been added 

		 
//		 req.getSession().invalidate();
//		 System.out.println(	 "from the Admin page :  " +  req.getSession().getAttribute("sessionAttr"));
//			
			return "AdminViews/MembersPanel";
			
		}
	
	
	
	@RequestMapping(value="/EditProject/{IdProject}")
	public String EditProject(Model m, HttpServletRequest req, @PathVariable("IdProject") String idProject){
		
		// redirect to authentication page if the user is not connected or if is not an Admin 
		if (req.getSession().getAttribute("UserID")==null || !req.getSession().getAttribute("Role").equals("admin") )  
			return "redirect:/authen";
		
		
	 project proj=	dao.getProjectById(Integer.parseInt(idProject));
		
		
	 	m.addAttribute("proj",proj);  
		  


			return "AdminViews/EditProject";
			
		}
	
	
	@RequestMapping(value="/deleteProject/{IdProject}")
	public String deleteProject(Model m, HttpServletRequest req, @PathVariable("IdProject") String idProject){
		
		// redirect to authentication page if the user is not connected or if is not an Admin 
		if (req.getSession().getAttribute("UserID")==null || !req.getSession().getAttribute("Role").equals("admin") )  
			return "redirect:/authen";
		
					
				
		
		dao.deleteProject(Integer.parseInt(idProject));
	 	  
		  


			return "redirect:/AdminPage";
			
		}
	
	
	@RequestMapping(value="/SaveProject")
	public String SaveProjectAfterEdit(project p , HttpServletRequest req){
		
		// redirect to authentication page if the user is not connected or if is not an Admin 
		if (req.getSession().getAttribute("UserID")==null || !req.getSession().getAttribute("Role").equals("admin") )  
			return "redirect:/authen";
		
			dao.UpdateProject(p);

			
			return "redirect:/AdminPage";
			
		}
	
	
	
	@RequestMapping(value="/addMember")
	public String addMember(member Member, Model m){
		
		Member.setRole("member");
		
		dao.addMember(Member);
								
		List<member> listMembers=	dao.getMembers();		
		 m.addAttribute("MembersCount",listMembers.size());
	 	 m.addAttribute("listM",listMembers);  
		 m.addAttribute("added","block");
		
			
		return "AdminViews/MembersPanel";
			
			
		}
	
	
	
	
}



