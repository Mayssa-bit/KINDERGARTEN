package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Models.Bus;
import tn.esprit.spring.Repository.BusRepository;







@Service
public class BusServicelmpl implements BusService {
	
	@Autowired
	BusRepository busRepository;
	private static final Logger L = LogManager.getLogger(ActiviteServicelmpl.class);
	@Override
	public List<Bus> retrieveAllBus() {
		List<Bus> B=(List<Bus>) busRepository.findAll();
		for (Bus Bus : B){
			L.info("Bus +++ :" + Bus);
		}
		return B;
	}
	
	@Override
    public Bus addBus(Bus B) {
     return busRepository.save(B);
     
}
	 @Override
     public void deleteBus(String B) {
     	
    	 busRepository.deleteById(Long.parseLong(B));
     } 
	
	
	 @Override
	 public Bus updateBus(Bus B) {
	 	return busRepository.save(B);
	 	
		
	 }
	
		@Override
	 	public Bus retrieveBus(String idact) {
	 		
	 		return null;
	 	} 
	
	
		@Override
		public int getNombreBus() {
			return busRepository.countBus();
		}
	
	
	
}
