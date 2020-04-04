/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Services;

import java.util.List;
import java.util.Optional;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import static org.eclipse.persistence.config.ExclusiveConnectionMode.Transactional;
import static org.eclipse.persistence.sessions.server.ConnectionPolicy.ExclusiveMode.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.DTO.ChildDTO;
import tn.esprit.spring.DTO.UserDTO;
import tn.esprit.spring.DTO.parentDTO;
import tn.esprit.spring.Models.Address;
import tn.esprit.spring.Models.Admins;
import tn.esprit.spring.Models.Children;
import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Models.ParentsChildren;
import tn.esprit.spring.Models.Schooladmins;
import tn.esprit.spring.Models.Users;
import tn.esprit.spring.Repository.AddressRepository;
import tn.esprit.spring.Repository.AdminRepository;
import tn.esprit.spring.Repository.ChildrenRepositorie;
import tn.esprit.spring.Repository.ParentChildrenRepo;
import tn.esprit.spring.Repository.ParentRepo;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Repository.UserRepository;



@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    UserRepository repo;
    @Autowired
    ParentChildrenRepo repoParentChild;
    @Autowired
    ParentRepo repoParent;
    @Autowired
    SchooladminRepository repoSchool;
    @Autowired
    AddressRepository repoAddress;
  
    @Autowired
    ChildrenRepositorie repochild;
    @Autowired
    AdminRepository ADD;
    
  
    
    @Autowired
    MyUserDetailService service;
    
    @Override
    public int CreateNewKinderGarten(UserDTO userdto) {
        
        if (emailExist(userdto.getEmail())) {   
          return -1;
       }
       Users user = new Users();
       System.out.println(" 2");
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setMatchingPassword(userdto.getMatchingPassword());
        user.setUsername(userdto.getUsername());
        user.setRole("SCH-ADMIN");
        Schooladmins school = new Schooladmins();
        school.setEmail(userdto.getEmail());
        school.setName(userdto.getName());
        
        repoSchool.save(school);
        
        Address address = new Address();
        address.setCodePostale(userdto.getCodePostale());
        address.setNumero(userdto.getNumero());
        address.setVille(userdto.getVille());
        address.setRue(userdto.getRue());
        user.setAddress(address);
        
        service.saveUserComputingDerivedPassword(user, user.getPassword());
        return 0;
       
    }
    
    private boolean emailExist(String email){
      Users user = repo.findByEmail(email);
      
        if (user != null) {
            return true;
        }
        return false;
    }
    
    public Parents CreateNewParent(parentDTO dto) {
        if (emailExist(dto.getEmail())) {   
         throw new UnsupportedOperationException("Cette adresse mail eiste déjà.");
       }
        System.out.println(" Parent 1 ");
       Parents parent = new Parents();
       System.out.println("parent first Name "+dto.getFirstName());
       System.out.println("parent last Name "+dto.getLastName());
       parent.setFirstName(dto.getFirstName());
       parent.setLastName(dto.getLastName());
       parent.setEmail(dto.getEmail()); 
       parent.setGenre(dto.getGenreId());
       
     
       Parents par = repoParent.save(parent);
      
       
       System.out.println("parent registred !!!");

       
       ParentsChildren parentsChild = new ParentsChildren();
       parentsChild.setChildId(repochild.findOneById(dto.getChildId().getId()));
       parentsChild.setParentId(par);
       repoParentChild.save(parentsChild);
        
       System.out.println(" Parent 2 ");
       
      
        Address address = new Address();
        address.setCodePostale(dto.getCodePostale());
        address.setNumero(dto.getNumero());
        address.setVille(dto.getVille());
        address.setRue(dto.getRue());
        
        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMatchingPassword(dto.getMatchingPassword());
        user.setUsername(dto.getUsername());
        user.setRole("USER");
     
        user.setAddress(address);
        service.saveUserComputingDerivedPassword(user,user.getPassword());
        //repo.save(user);
        return par;
    }

    @Override
    public Children CreateNewChild(ChildDTO dto) {
        if (emailExist(dto.getEmail())) {   
         throw new UnsupportedOperationException("Cette adresse mail eiste déjà.");
       }
        System.out.println(" Child ");
      
        Children child = new Children();
        child.setClassesId(dto.getClassesId());
        child.setFirstName(dto.getFirstName());
        child.setLastName(dto.getLastName());
        child.setEmail(dto.getEmail());
      
        Address address = new Address();
        address.setCodePostale(dto.getCodePostale());
        address.setNumero(dto.getNumero());
        address.setVille(dto.getVille());
        address.setRue(dto.getRue());
      
        return repochild.save(child);
    }
    
    
  
    
    public int CreateNewAdmin(UserDTO dto){
    	 if (emailExist(dto.getEmail())) {   
             throw new UnsupportedOperationException("Cette adresse mail eiste déjà.");
             
           }
    	 Users user = new Users();
         user.setEmail(dto.getEmail());
         user.setPassword(dto.getPassword());
         user.setMatchingPassword(dto.getMatchingPassword());
         user.setUsername(dto.getUsername());
         user.setRole("ADMIN");
         
         Admins ad = new Admins();
         ad.setEmail(dto.getEmail());
         ad.setName(dto.getUsername());
         ADD.save(ad);
         service.saveUserComputingDerivedPassword(user,user.getPassword());
         return 0 ;
    }
    
    public Users findUserByEmail(String email){
    	return repo.findUByEmail(email);
    };
    public Users findUserByResetToken(String resetToken){
    	return repo.findByResetToken(resetToken);
    };

    
   

    public void save(Users user) {
		repo.save(user);
	};
    
}
