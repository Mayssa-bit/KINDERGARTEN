package tn.esprit.spring.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Models.ParentsChildren;



public interface ParentChildrenRepo extends  CrudRepository<ParentsChildren,Integer>{

	ParentsChildren save(ParentsChildren parentsChild);
	List<ParentsChildren> findAllByparentId(Parents id);
    
}
