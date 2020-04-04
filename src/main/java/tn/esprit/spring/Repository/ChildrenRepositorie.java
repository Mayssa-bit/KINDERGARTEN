/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Models.Children;




public interface ChildrenRepositorie extends CrudRepository<Children,Integer> {
    Children findOneById(Integer id);
   
    
}
