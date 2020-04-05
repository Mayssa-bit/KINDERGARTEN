package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Models.Participants;

public interface ParticipantsService {
	List<Participants> retrieveAllParticipants();
	Participants addParticipants(Participants p); 
	void deleteParticipants(String id);
	Participants updateParticipants(Participants p);
	Participants retrieveParticipants(String id);
	public void affecterEvenementsAParticipants(String idEvent, String idParticip);


}
