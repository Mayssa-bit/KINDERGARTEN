package tn.esprit.spring.Repository;

import org.hibernate.annotations.Parent;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Models.Parents;



public interface ParentRepo extends CrudRepository<Parents, Integer> {
	Parents findByFirstName(String firstName );
}    

