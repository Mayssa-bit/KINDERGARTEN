package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Models.Evenements;

public interface EvenementsService {
	List<Evenements> retrieveAllEvenements();
	Evenements addEvenements(Evenements e); 
	void deleteEvenements(String id);
	Evenements updateEvenements(Evenements e);
	Evenements retrieveEvenements(String id);


}
