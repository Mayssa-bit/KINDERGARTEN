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

import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Inscrits;
import tn.esprit.spring.service.InscritsService;

@RestController
public class InscritsRestController {

	
	@Autowired
	InscritsService inscritsService;
	
	
	 // http://localhost:8081/SpringMVC/servlet/retrieve-all-In
	 @GetMapping("/retrieve-all-In")
	 @ResponseBody
	 public List<Inscrits> getInscrits() {
	 List<Inscrits> act = inscritsService.retrieveAllInscrits();
	 return act;
}
	 
	  // http://localhost:8081/SpringMVC/servlet/remove-In/{In-id}
	    @DeleteMapping("/remove-In/{In-id}")
	    @ResponseBody
	    public void removeInscrits(@PathVariable("In-id") String BId) {
	    	inscritsService.deleteInscrits(BId);
	    }	 
	
	    
	    // http://localhost:8081/SpringMVC/servlet/modify-Inscrits
	    @PutMapping("/modify-Inscrits")
	    @ResponseBody
	    public Inscrits modifyInscrits(@RequestBody Inscrits act) {
	    return inscritsService.updateInscrits(act);
	    }
	
	    //  http://localhost:8081/SpringMVC/servlet/add-Inscrits
		   @PostMapping("/add-Inscrits")
		   @ResponseBody
		   public Inscrits addBus(@RequestBody Inscrits a) {
			   Inscrits act = inscritsService.addInscrits(a);
		       return act;
		   }
		   
			//http://localhost:8081/SpringMVC/servlet/inscr/{bus-id}/{inscrit-id}
			@PutMapping(value = "/inscr/{bus-id}/{inscrit-id}") 
			public void inscr(@PathVariable("bus-id")String idEvent, @PathVariable("inscrit-id")String idParticip) 
			{
				inscritsService.inscr(idEvent, idParticip);
				
			}
			
			//http://localhost:8081/SpringMVC/servlet/desinscr/{buss-id}/{inscrits-id}
			@PutMapping(value = "/desinscr/{buss-id}/{inscrits-id}") 
			public void desinscr(@PathVariable("buss-id")String idEvent, @PathVariable("inscrits-id")String idParticip) 
			{
				inscritsService.desinscr(idEvent, idParticip);
				
			}
}
