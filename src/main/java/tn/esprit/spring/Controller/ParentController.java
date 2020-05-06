package tn.esprit.spring.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.google.inject.spi.Element;

import antlr.collections.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.DTO.parentDTO;
import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Models.Schooladmins;
import tn.esprit.spring.Repository.ChildrenRepositorie;
import tn.esprit.spring.Repository.ParentChildrenRepo;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Security.MyUserDetailsService;
import tn.esprit.spring.Services.UserService;

@Controller
public class ParentController {
	
	 @Autowired
	 ChildrenRepositorie repochild;
	 

	 @Autowired
	 ParentChildrenRepo repochildParnt;
	 
	 @Autowired 
	 UserService service;
	 @Autowired
	 SchooladminRepository repo;

	 @Autowired
	    MyUserDetailsService userDetailsService;
	 
	 @ApiOperation(value = "register form for parent",response = Iterable.class)

	 @GetMapping("/addParent")
	    public String form(Model model){
	        model.addAttribute("parentdto", new parentDTO());
	        model.addAttribute("childrens",repochild.findAll() );
	        return "formParent";
	    }
	 
	 @ApiOperation(value = "Create a parent account",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully creation of the account "),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	 @PostMapping("/registrationParent")
	    public String register(Model model, parentDTO dto){
	   
	       Parents parent = null;
	       Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
	   
	   //    parent = service.CreateNewParent(dto);
	     
	       model.addAttribute("school",admin);
	        return "redirect:/login";
	    }
}
