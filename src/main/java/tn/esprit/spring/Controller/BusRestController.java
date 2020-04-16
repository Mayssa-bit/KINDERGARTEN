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

import tn.esprit.spring.Models.Bus;
import tn.esprit.spring.Services.BusService;






@RestController
public class BusRestController {


	@Autowired
     	BusService busService;
	
	
	
	 //  http://localhost:8081/SpringMVC/servlet/add-Bu
	   @PostMapping("/add-Bu")
	   @ResponseBody
	   public Bus addBus(@RequestBody Bus a) {
		   Bus act = busService.addBus(a);
	       return act;
	   }
	
	
		 // http://localhost:8081/SpringMVC/servlet/retrieve-all-Bu
		 @GetMapping("/retrieve-all-Bu")
		 @ResponseBody
		 public List<Bus> getBus() {
		 List<Bus> act = busService.retrieveAllBus();
		 return act;
	}
	
		  // http://localhost:8081/SpringMVC/servlet/remove-B/{B-id}
		    @DeleteMapping("/remove-B/{B-id}")
		    @ResponseBody
		    public void removeBus(@PathVariable("B-id") String BId) {
		    	busService.deleteBus(BId);
		    }
		    
		    // http://localhost:8081/SpringMVC/servlet/modify-Bus
		    @PutMapping("/modify-Bus")
		    @ResponseBody
		    public Bus modifyBus(@RequestBody Bus act) {
		    return busService.updateBus(act);
		    }
		    
		 // http://localhost:8081/SpringMVC/servlet/retrieve-Bus/{Bus-id}
			  @GetMapping("/retrieve-Bus/{Bus-id}")
			  @ResponseBody
			  public Bus retrieveBus(@PathVariable("Bus-id") String busId) {
			  return busService.retrieveBus(busId);
			  }  
			  
				// URL : http://localhost:8081/SpringMVC/servlet/getNombreBus
				@GetMapping(value = "getNombreBus")
				@ResponseBody
				public int getNombreEmployeJPQL() {

					return busService.getNombreBus();
				}

				  
	
}
