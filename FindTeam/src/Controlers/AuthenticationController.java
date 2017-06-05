package Controlers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import metier.Admin;
import metier.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DaoImplementation;


//---------  Authentication and Security   --------------

// Here we Handle Authentication and Security of the application 
//  -- Checking Access authorization
//  -- Checking Authentication
//  -- handling Session during Login and Logout 




@Controller
public class AuthenticationController {


	
	
DaoImplementation dao = new DaoImplementation();






@RequestMapping(value="/authen")
public String authen(Model m,  HttpServletRequest req){
		
		
	
			// the user is already connected , redirect to target page based on his role
	 if (		req.getSession().getAttribute("UserID")!=null ) {
		 
		if ( req.getSession().getAttribute("Role").equals("member"))
		 return "redirect:/projects";
		else 
			return "redirect:/AdminPage";
		 
	 }
	 																
	 	m.addAttribute("show","none"); //  don't show msg erreur 
		return "authen";
		
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
	



	@RequestMapping(value="/authenLogin")
public String Authentication(Model m ,@RequestParam("Email") String Email, @RequestParam("Password") String Password, HttpServletRequest req){
		
		String PasswordInMD5=this.getMD5(Password);
				
		
		
		
		Boolean foundA=false;
		Boolean foundM=false;
		List<Admin> listA = dao.getAdmins();
		Admin admin=null;
		member member=null;
		for ( Admin ad : listA) {
			
			if (ad.getEmail().equals(Email) && ad.getPassword().equals(PasswordInMD5)) {  foundA=true; admin=ad; break; }
			
			
			
			
			
		}
		
		
		if(!foundA)
		{
			List<member> listM = dao.getMembers();
			for ( member mem : listM) {
				
				if (mem.getEmail().equals(Email)  ) {
						
					foundM=true;
					 member=mem; break;
					
				
				}
				
				
				
			} // #end for 
			
		} // #end if(!foundA)
		
		
		
	
	
		int	UserID = 0;
		String 	Role=null;
		String ViewTargetAfterAuthen="home";
		
	//	user found as Member
	if (foundM) {
		
		
		UserID=member.getId_user();
	 	Role=member.getRole();
	
	 	
	 	// if the user is new ( first acess ) --> we call the controller to complete his profil
	 	if (member.getPassword()==null)
	 		ViewTargetAfterAuthen="redirect:/CompletMemberProfil";
	 	else	 {		
	 	
	 		if (member.getPassword().equals(PasswordInMD5)) 
	 		ViewTargetAfterAuthen="redirect:/projects";
	 		else   {   // password incorrect 
	 			ViewTargetAfterAuthen="authen";
	 			m.addAttribute("show","block");  }
	 	
	 	}
	 	
	} // #end FoundM
	// user found as Admin
	else if (foundA ) {
		

		UserID=admin.getAdmin_id();
	 	Role=admin.getRole();
	 	
	 	ViewTargetAfterAuthen="redirect:/AdminPage";
		
	}
	
	// user not found
	else {
		
		ViewTargetAfterAuthen="authen";
		m.addAttribute("show","block");
		
		
	}
	 
		if (foundA || foundM){
	req.getSession().setAttribute("UserID", UserID);
	req.getSession().setAttribute("Role", Role);
	
		}
		
	
		
		System.out.println(	 " USerID and Role :  " +  req.getSession().getAttribute("UserID")+req.getSession().getAttribute("Role"));
		
		
		return ViewTargetAfterAuthen;

		
	}
	


@RequestMapping(value="/Logout")
public String Logout(HttpServletRequest req){
		
		req.getSession().invalidate();		
			return "redirect:authen";
	
		}


	
	
}
