package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Models.Bus;
import tn.esprit.spring.Models.Inscrits;
import tn.esprit.spring.Repository.BusRepository;
import tn.esprit.spring.Repository.InscritsRepository;




@Service
public class InscritsServicelmpl implements InscritsService {
	
	@Autowired
	InscritsRepository inscritsRepository;
	@Autowired
	BusRepository busRepository;
	
	private static final Logger L = LogManager.getLogger(InscritsServicelmpl.class);
	@Override
	public List<Inscrits> retrieveAllInscrits() {
		List<Inscrits> B=(List<Inscrits>) inscritsRepository.findAll();
		for (Inscrits Inscrits : B){
			L.info("Inscrits +++ :" + Inscrits);
		}
		return B;
		}
	
	@Transactional	
	public void inscr(String matricule, String Idinscrip) {
		Inscrits InscritsEntity = inscritsRepository.findById(Long.parseLong(Idinscrip)).get();
		Bus BusEntity = busRepository.findById(Long.parseLong(matricule)).get();
		
		Integer nbrPlaces = busRepository.findById(Long.parseLong(matricule)).get().getNbrPlace();
		
		if (nbrPlaces-1==0){
			BusEntity.setEtat("saturée");
		}
		
		if (nbrPlaces>0){
			BusEntity.setNbrPlace(nbrPlaces-1);
			
			InscritsEntity.getBus().add(BusEntity);
			

		}
		
		
	}
	@Transactional	
	public void desinscr(String matricule, String Idinscrip) {
		Inscrits InscritsEntity = inscritsRepository.findById(Long.parseLong(Idinscrip)).get();
		Bus BusEntity = busRepository.findById(Long.parseLong(matricule)).get();
		
		Integer nbrPlaces = busRepository.findById(Long.parseLong(matricule)).get().getNbrPlace();
		
		if (nbrPlaces>0){
			BusEntity.setNbrPlace(nbrPlaces+1);
			
			InscritsEntity.getBus().remove(BusEntity);
			

		}	
		
	}
	
	
	
	@Override
    public Inscrits addInscrits(Inscrits B) {
		Inscrits insc =inscritsRepository.save(B);
		return insc;
     
}
	 @Override
     public void deleteInscrits(String B) {
     	
		 inscritsRepository.deleteById(Long.parseLong(B));
     } 
	
	
	 @Override
	 public Inscrits updateInscrits(Inscrits B) {
	 	return inscritsRepository.save(B);
	 		
	 }
	
		@Override
	 	public Inscrits retrieveInscrits(String idact) {
	 		
	 		return null;
	 	} 
	
	
	
	
}
	
