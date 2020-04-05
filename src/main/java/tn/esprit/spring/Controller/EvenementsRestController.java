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

import tn.esprit.spring.Models.Evenements;
import tn.esprit.spring.Services.EvenementsService;

@RestController
public class EvenementsRestController {
	
	@Autowired
	EvenementsService eventService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-events 
		@GetMapping("/retrieve-all-events") 
		@ResponseBody
		public List<Evenements> getEvenements() {
			 List<Evenements> list = eventService.retrieveAllEvenements(); 
			 return list; 
			}
		
	//http://localhost:8081/SpringMVC/servlet/retrieve-evenements/{evenements-id} 
		@GetMapping("/retrieve-evenements/{evenements-id}") 
		@ResponseBody
		public Evenements getEvenements(@PathVariable("evenements-id") String evenementsId) { 
			return eventService.retrieveEvenements(evenementsId); 
			} 
	
		
	//http://localhost:8081/SpringMVC/servlet/add-event 
		@PostMapping("/add-event")
		@ResponseBody
		 public Evenements addEvenements(@RequestBody Evenements e) { 
			Evenements event = eventService.addEvenements(e); 
			return event; 
			}
		  
		
	//http://localhost:8081/SpringMVC/servlet/delete-event/{event-id}
		@DeleteMapping("/delete-event/{event-id}") 
		@ResponseBody
		public void deleteEvenements(@PathVariable("event-id") String evenementsId) {  
			eventService.deleteEvenements(evenementsId); 
			} 
		

	//http://localhost:8081/SpringMVC/servlet/update-evenements
		@PutMapping("/update-evenements")
		@ResponseBody
		public Evenements updateEvenements(@RequestBody Evenements evenements) {
		return eventService.updateEvenements(evenements);
		}
}
