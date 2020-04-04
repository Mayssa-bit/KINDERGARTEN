/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Services;

import java.util.List;


import com.google.common.base.Optional;

import tn.esprit.spring.DTO.ChildDTO;
import tn.esprit.spring.DTO.UserDTO;
import tn.esprit.spring.DTO.parentDTO;
import tn.esprit.spring.Models.Children;
import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Models.Users;
/**
 *
 * @author Souleymane
 */
public interface IUserService {
    int CreateNewKinderGarten(UserDTO user);
    Children CreateNewChild(ChildDTO dto);
   
	Parents CreateNewParent(parentDTO dto);
	  int CreateNewAdmin(UserDTO dto);
	  public Users findUserByEmail(String email);
	    public Users findUserByResetToken(String resetToken);
}