package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.Models.Evenements;
import tn.esprit.spring.Models.Participants;
import tn.esprit.spring.Repository.EvenementsRepository;
import tn.esprit.spring.Repository.ParticipantsRepository;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {
	@Autowired
	ParticipantsRepository participantsRepository;
	
	@Autowired
	EvenementsRepository evenementsRepository;
	
	
	
	private static final Logger L = LogManager.getLogger(ParticipantsServiceImpl.class);
	
	@Transactional	
	public void affecterEvenementsAParticipants(String idEvent, String idParticip) {
		Participants participManagedEntity = participantsRepository.findById(Long.parseLong(idParticip)).get();
		Evenements evenementsManagedEntity = evenementsRepository.findById(Long.parseLong(idEvent)).get();
		String name = evenementsRepository.findById(Long.parseLong(idEvent)).get().getNomE();
		Integer nbPlaces = evenementsRepository.findById(Long.parseLong(idEvent)).get().getNbPlace();
		if (nbPlaces>0){
			participManagedEntity.setNomEvent(name);
			evenementsManagedEntity.setNbPlace(nbPlaces-1);
			participManagedEntity.getEvenements().add(evenementsManagedEntity);

		}
		if (nbPlaces-1==0){
			evenementsManagedEntity.setStatutE("Complet");
		}
		
	}


	@Override
	public List<Participants> retrieveAllParticipants() {
		List<Participants> participants = (List<Participants>) participantsRepository.findAll();
		
		for (Participants p : participants){
			L.info("p +++ :" + p);
		}
		return participants;
	}
	
	@Override
	public Participants addParticipants(Participants p) {
		Participants particip =participantsRepository.save(p);
		return particip;
		
	}

	@Override
	public void deleteParticipants(String id) {
		participantsRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Participants updateParticipants(Participants p) {
		Participants particip =participantsRepository.save(p);
		return particip;
	}

	@Override
	public Participants retrieveParticipants(String id) {
		Participants particip =participantsRepository.findById(Long.parseLong(id)).orElse(null);
		return particip;
	}
	
	
	
	
	
}
