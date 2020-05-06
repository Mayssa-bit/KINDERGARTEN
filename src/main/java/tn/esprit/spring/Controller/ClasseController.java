/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.Models.Classes;
import tn.esprit.spring.Models.Schooladmins;
import tn.esprit.spring.Repository.ClassesRepository;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Security.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class ClasseController {
    @Autowired
    MyUserDetailsService userDetailsService;
    
    @Autowired
    SchooladminRepository repo;
    
    @Autowired
    ClassesRepository repoClasse;
    
   
    
    @GetMapping("/formClasse")
    public String getForm(Model model){
        model.addAttribute("classe", new Classes());
        
        return "formClass";
    }
    
    @ApiOperation(value = "Create a new class account",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully creation of the class account "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/addClasse")
    public String add(Model model, Classes classe){
        Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
        Classes Newclasse = new Classes();
        Newclasse.setLabel(classe.getLabel());
        Newclasse.setAnneeScolaire(classe.getAnneeScolaire());
        Newclasse.setSchooladminId(admin);
        repoClasse.save(Newclasse);
        model.addAttribute("school",admin);
        
        
        return "accueilSchool";
    }
}
