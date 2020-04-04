/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Models.Schooladmins;




public interface SchooladminRepository extends CrudRepository<Schooladmins,Integer> {
  
    @Query("SELECT u FROM Schooladmins u WHERE u.email= ?1")
    Schooladmins findByEmail(String email);

    
   
}
