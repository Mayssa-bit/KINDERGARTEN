package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.Models.Evenements;
import tn.esprit.spring.Repository.EvenementsRepository;

@Service
public class EvenementsServiceImpl implements EvenementsService {
	@Autowired
	EvenementsRepository evenementsRepository;
	
	private static final Logger L = LogManager.getLogger(EvenementsServiceImpl.class);

	@Override
	public List<Evenements> retrieveAllEvenements() {
		List<Evenements> events = (List<Evenements>) evenementsRepository.findAll();
		
		for (Evenements event : events){
			L.info("event +++ :" + event);
		}
		return events;
	}
	
	@Override
	public Evenements addEvenements(Evenements e) {
		Evenements event =evenementsRepository.save(e);
		return event;
		
	}

	@Override
	public void deleteEvenements(String id) {
		evenementsRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Evenements updateEvenements(Evenements e) {
		Evenements event =evenementsRepository.save(e);
		return event;
	}

	@Override
	public Evenements retrieveEvenements(String id) {
		Evenements event =evenementsRepository.findById(Long.parseLong(id)).orElse(null);
		return event;
	}
	
	
	
	
	
}
