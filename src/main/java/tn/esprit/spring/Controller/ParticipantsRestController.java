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

import tn.esprit.spring.Models.Participants;
import tn.esprit.spring.Services.ParticipantsService;

@RestController
public class ParticipantsRestController {
	
	@Autowired
	ParticipantsService participantsService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-participants
		@GetMapping("/retrieve-all-participants") 
		@ResponseBody
		public List<Participants> getParticipants() {
			 List<Participants> list = participantsService.retrieveAllParticipants(); 
			 return list; 
			}
		
	//http://localhost:8081/SpringMVC/servlet/retrieve-participants/{participants-id} 
		@GetMapping("/retrieve-participants/{participants-id}") 
		@ResponseBody
		public Participants getParticipants(@PathVariable("participants-id") String participantsId) { 
			return participantsService.retrieveParticipants(participantsId); 
			} 
		
	//http://localhost:8081/SpringMVC/servlet/add-participants 
		@PostMapping("/add-participants")
		@ResponseBody
		 public Participants addParticipants(@RequestBody Participants p) { 
			Participants particip = participantsService.addParticipants(p); 
			return particip; 
			}
		  
		
	//http://localhost:8081/SpringMVC/servlet/delete-participants/{participants-id}
		@DeleteMapping("/delete-participants/{participants-id}") 
		@ResponseBody
		public void deleteParticipants(@PathVariable("participants-id") String participantsId) {  
			participantsService.deleteParticipants(participantsId); 
			} 
		

	//http://localhost:8081/SpringMVC/servlet/update-participants
		@PutMapping("/update-participants")
		@ResponseBody
		public Participants updateParticipants(@RequestBody Participants participants) {
		return participantsService.updateParticipants(participants);
		}
		
	
	//http://localhost:8081/SpringMVC/servlet/affecterEvenementsAParticipants/{evenements-id}/{participants-id}
	@PutMapping(value = "/affecterEvenementsAParticipants/{evenements-id}/{participants-id}") 
	public void affecterEvenementsAParticipants(@PathVariable("evenements-id")String idEvent, @PathVariable("participants-id")String idParticip) 
	{
		participantsService.affecterEvenementsAParticipants(idEvent, idParticip);
		
	}
	 
}
