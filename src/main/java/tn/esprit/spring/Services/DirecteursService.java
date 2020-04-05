package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Models.Directeurs;

public interface DirecteursService {
	List<Directeurs> retrieveAllDirecteurs();
	Directeurs addDirecteurs(Directeurs e); 
	void deleteDirecteurs(String id);
	Directeurs updateDirecteurs(Directeurs e);
	Directeurs retrieveDirecteurs(String id);


}
