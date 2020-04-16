package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Activités;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.activiteService;


@RestController
public class ActiviteRestController {

	@Autowired
	 activiteService ActiviteService;
	
	
	 // http://localhost:8081/SpringMVC/servlet/retrieve-all-Act
	 @GetMapping("/retrieve-all-Act")
	 @ResponseBody
	 public List<Activités> getActivités() {
	 List<Activités> act = ActiviteService.retrieveAllActivités();
	 return act;
}
	 
	 
	 
	 //  http://localhost:8081/SpringMVC/servlet/add-Ac
	   @PostMapping("/add-Ac")
	   @ResponseBody
	   public Activités addActivités(@RequestBody Activités a) {
	   Activités act = ActiviteService.addActivités(a);
	   return act;
	   }
	   
	    // http://localhost:8081/SpringMVC/servlet/modify-Ac
	    @PutMapping("/modify-Ac")
	    @ResponseBody
	    public Activités modifyActivités(@RequestBody Activités act) {
	    return ActiviteService.updateActivités(act);
	    }
	    
	    // http://localhost:8081/SpringMVC/servlet/remove-act/{act-id}
	    @DeleteMapping("/remove-act/{act-id}")
	    @ResponseBody
	    public void removeActivités(@PathVariable("act-id") String actId) {
	    	ActiviteService.deleteActivités(actId);
	    }
	    
	 // http://localhost:8081/SpringMVC/servlet/retrieve-act/{act-id}
		  @GetMapping("/retrieve-act/{act-id}")
		  @ResponseBody
		  public Activités retrieveActivités(@PathVariable("act-id") String actId) {
		  return ActiviteService.retrieveActivités(actId);
		  }  
}
