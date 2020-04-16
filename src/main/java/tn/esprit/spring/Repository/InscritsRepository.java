package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Models.Inscrits;



@Repository
public interface InscritsRepository extends CrudRepository<Inscrits, Long>{
	
	
	
}
