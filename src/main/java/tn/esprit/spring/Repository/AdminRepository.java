package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Models.Admins;
import tn.esprit.spring.Models.Users;



public interface AdminRepository extends CrudRepository<Users,Integer>{

	void save(Admins ad);
	 @Query("SELECT u FROM Admins u WHERE u.email= ?1")
	 Admins findByEmail(String email);


}
