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

import tn.esprit.spring.Models.Directeurs;
import tn.esprit.spring.Services.DirecteursService;

@RestController
public class DirecteursRestController {
	
	@Autowired
	DirecteursService directeursService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-directeurs 
		@GetMapping("/retrieve-all-directeurs") 
		@ResponseBody
		public List<Directeurs> getDirecteurs() {
			 List<Directeurs> list = directeursService.retrieveAllDirecteurs(); 
			 return list; 
			}
		
	//http://localhost:8081/SpringMVC/servlet/retrieve-directeurs/{directeurs-id} 
		@GetMapping("/retrieve-directeurs/{directeurs-id}") 
		@ResponseBody
		public Directeurs getDirecteurs(@PathVariable("directeurs-id") String directeursId) { 
			return directeursService.retrieveDirecteurs(directeursId); 
			} 
		
	//http://localhost:8081/SpringMVC/servlet/add-directeurs 
		@PostMapping("/add-directeurs")
		@ResponseBody
		 public Directeurs addDirecteurs(@RequestBody Directeurs p) { 
			Directeurs direct = directeursService.addDirecteurs(p); 
			return direct; 
			}
		  
		
	//http://localhost:8081/SpringMVC/servlet/delete-directeurs/{directeurs-id}
		@DeleteMapping("/delete-directeurs/{directeurs-id}") 
		@ResponseBody
		public void deleteDirecteurs(@PathVariable("directeurs-id") String directeursId) {  
			directeursService.deleteDirecteurs(directeursId); 
			} 
		

	//http://localhost:8081/SpringMVC/servlet/update-directeurs
		@PutMapping("/update-directeurs")
		@ResponseBody
		public Directeurs updateDirecteurs(@RequestBody Directeurs directeurs) {
		return directeursService.updateDirecteurs(directeurs);
		}
}
