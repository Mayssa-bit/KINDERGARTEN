package tn.esprit.spring.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.DTO.UserDTO;
import tn.esprit.spring.Models.Admins;
import tn.esprit.spring.Models.Schooladmins;
import tn.esprit.spring.Repository.AdminRepository;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Security.MyUserDetailsService;
import tn.esprit.spring.Services.UserService;

@Controller
public class AdminController {
	public Integer adminId=null;
	
	
	
	@Autowired
	AdminRepository repoad;
	
	 @Autowired
	 MyUserDetailsService userDetailsService;
	 
	 @Autowired
	 SchooladminRepository repo;
	 
	 @Autowired UserService serviceUser;
	    
	 @ApiOperation(value = "Register form for admin",response = Iterable.class)
	@GetMapping("/addadmin")
	public String addadmin(Model model, @Param("id") Integer adminId) {
		 this.adminId = adminId;
		 UserDTO admin = new UserDTO();
		
		model.addAttribute("admin", admin);
		return "AdminForm";
	}
	 
	
	 @ApiOperation(value = "Create Admin account",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully creation of the account "),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	 
	 @GetMapping("/registrationAdmin")
		public String regadmin(Model model, @Param("id") Integer adminId) {
			 this.adminId = adminId;
			 UserDTO admin = new UserDTO();
			
			model.addAttribute("admin", admin);
			return "accueillAdmin";
		}
	 @PostMapping("/registrationAdmin")
	 public String register(Model model, UserDTO dto){

	       int ad ;
	       Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
	   
	   //    ad = serviceUser.CreateNewAdmin(dto);
	     
	       model.addAttribute("school",admin);
	        return "accueillAdmin";
	    }
	  
	@GetMapping("/Admin")
	public String accueil(Model model) throws IOException {
		Admins ad = repoad.findByEmail(userDetailsService.userCt.getEmail());
		
		model.addAttribute("admin", ad);
		

		
		return "accueillAdmin";
	}
	
	
}
