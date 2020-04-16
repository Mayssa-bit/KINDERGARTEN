package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Models.Activités;




@Repository
public interface ActiviteRepository extends CrudRepository<Activités, Long>{
		
}