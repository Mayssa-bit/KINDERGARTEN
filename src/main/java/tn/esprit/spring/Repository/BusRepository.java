package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Models.Bus;




@Repository
public interface BusRepository extends CrudRepository<Bus, Long>{
	
	
	@Query("SELECT count(*) FROM Bus")
    public int countBus();
	
}
