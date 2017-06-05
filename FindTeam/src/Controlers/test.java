package Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

	@RequestMapping(value="/home")
	public String Home(){
		
		return "index";
		
	}
	
	
}
