/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.Models.Classes;
import tn.esprit.spring.Models.Schooladmins;




public interface ClassesRepository extends CrudRepository<Classes, Integer> {
  
   
    @Query("SELECT u FROM Classes u WHERE u.schooladminId = :id")
    List<Classes> getAllClass(@Param("id") Schooladmins id);
}
