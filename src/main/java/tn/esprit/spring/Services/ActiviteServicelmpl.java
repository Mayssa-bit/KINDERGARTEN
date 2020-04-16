package tn.esprit.spring.Services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Models.Activités;
import tn.esprit.spring.Repository.ActiviteRepository;




@Service
public class ActiviteServicelmpl implements activiteService {
@Autowired
ActiviteRepository activiteRepository;
private static final Logger L = LogManager.getLogger(ActiviteServicelmpl.class);
@Override
public List<Activités> retrieveAllActivités() {
	List<Activités> act=(List<Activités>) activiteRepository.findAll();
	for (Activités Activités : act){
		L.info("Activités +++ :" + Activités);
	}
	return act;
}
@Override
      public Activités addActivités(Activités act) {
       return activiteRepository.save(act);
	
}


@Override
public void deleteActivités(String idact) {
	
	activiteRepository.deleteById(Long.parseLong(idact));
}

@Override
public Activités updateActivités(Activités a) {
	return activiteRepository.save(a);
	
}

@Override
public Activités retrieveActivités(String idact) {
	
	return null;
}
	
	

}
