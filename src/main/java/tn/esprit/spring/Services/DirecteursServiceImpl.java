package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Models.Directeurs;
import tn.esprit.spring.Repository.DirecteursRepository;

@Service
public class DirecteursServiceImpl implements DirecteursService {
	@Autowired
	DirecteursRepository directeursRepository;
	
	private static final Logger L = LogManager.getLogger(DirecteursServiceImpl.class);

	@Override
	public List<Directeurs> retrieveAllDirecteurs() {
		List<Directeurs> directeurs = (List<Directeurs>) directeursRepository.findAll();
		
		for (Directeurs d : directeurs){
			L.info("d +++ :" + d);
		}
		return directeurs;
	}
	
	@Override
	public Directeurs addDirecteurs(Directeurs d) {
		Directeurs direct =directeursRepository.save(d);
		return direct;
		
	}

	@Override
	public void deleteDirecteurs(String id) {
		directeursRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Directeurs updateDirecteurs(Directeurs d) {
		Directeurs direct =directeursRepository.save(d);
		return direct;
	}

	@Override
	public Directeurs retrieveDirecteurs(String id) {
		Directeurs direct =directeursRepository.findById(Long.parseLong(id)).orElse(null);
		return direct;
	}
	
	
	
	
	
}
