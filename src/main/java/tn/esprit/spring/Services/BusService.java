package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Models.Bus;




public interface BusService {
	
	List<Bus> retrieveAllBus(); 
	Bus addBus(Bus B);
	void deleteBus(String matricule);
	Bus updateBus(Bus B);
	Bus retrieveBus(String matricule);
	public int getNombreBus();
	

}
