/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.DTO.ChildDTO;
import tn.esprit.spring.Models.Children;
import tn.esprit.spring.Models.Schooladmins;
import tn.esprit.spring.Repository.ChildrenRepositorie;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Security.MyUserDetailsService;
import tn.esprit.spring.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ChildrenController {
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
    SchooladminRepository repo;
    @Autowired UserService service;
    @Autowired
    ChildrenRepositorie repochild;
    
    @ApiOperation(value = "register form for a child",response = Iterable.class)
    @GetMapping("/child")
    public String form(Model model){
        model.addAttribute("childdto", new ChildDTO());
        model.addAttribute("classes", repo.findByEmail(userDetailsService.userCt.getEmail()).getClassesCollection());
        return "formChild";
    }
    
    @ApiOperation(value = "Create a new child account",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully creation of the account "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/registrationChild")
    public String register(Model model, ChildDTO dto){
       Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
       Children child = null;
       
      // child = service.CreateNewChild(dto);
       model.addAttribute("school",admin);
        return "/accueilSchool";
    }
    
}
