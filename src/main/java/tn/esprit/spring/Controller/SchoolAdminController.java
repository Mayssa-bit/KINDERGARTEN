/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Repository.ChildrenRepositorie;
import tn.esprit.spring.Repository.ParentChildrenRepo;
import tn.esprit.spring.Repository.ParentRepo;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Security.MyUserDetailsService;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/school")
public class SchoolAdminController {
    
    @Autowired
    SchooladminRepository repo;
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
	 ChildrenRepositorie repochild;
    @Autowired
	 ParentRepo repoParent;

	 @Autowired
	 ParentChildrenRepo repochildParnt;
    

	 /*   @ApiOperation(value = "Welcome page",response = Iterable.class)
    @GetMapping("/accueilSchool")
    private String accueil(Model model,Authentication auth ){
        
        if(userDetailsService.userCt.getRole().equals("SCH-ADMIN")){
            
            model.addAttribute("school",repo.findByEmail(userDetailsService.userCt.getEmail()));
            return "accueilSchool";
        }
       
        if(userDetailsService.userCt.getRole().equals("USER")){
        	
        	 

        	   Parents parnt =repoParent.findByFirstName(auth.getName());
        
   	 
   	    model.addAttribute("listChild",repochild.findAll());
            return "parentAccueil";
        }
        if(userDetailsService.userCt.getRole().equals("ADMIN")){
           
            return "redirect:/Admin";
        }
        
      return "";
    }*/
    
}
