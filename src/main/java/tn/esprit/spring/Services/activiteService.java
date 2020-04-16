package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Models.Activités;




public interface activiteService {
	
	List<Activités> retrieveAllActivités(); 
	Activités addActivités(Activités A);
	void deleteActivités(String idact);
	Activités updateActivités(Activités A);
	Activités retrieveActivités(String idact);
	
	

}
