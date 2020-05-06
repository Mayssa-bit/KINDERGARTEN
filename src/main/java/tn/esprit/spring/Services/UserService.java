/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.inject.Inject;
import static org.eclipse.persistence.config.ExclusiveConnectionMode.Transactional;
import static org.eclipse.persistence.sessions.server.ConnectionPolicy.ExclusiveMode.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import tn.esprit.spring.DTO.ChildDTO;
import tn.esprit.spring.DTO.UserDTO;
import tn.esprit.spring.DTO.parentDTO;
import tn.esprit.spring.Errors.UserAlreadyExistException;
import tn.esprit.spring.Models.Address;
import tn.esprit.spring.Models.Admins;
import tn.esprit.spring.Models.Children;
import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Models.ParentsChildren;
import tn.esprit.spring.Models.PasswordResetToken;
import tn.esprit.spring.Models.Schooladmins;
import tn.esprit.spring.Models.Users;
import tn.esprit.spring.Models.VerificationToken;
import tn.esprit.spring.Repository.AddressRepository;
import tn.esprit.spring.Repository.AdminRepository;
import tn.esprit.spring.Repository.ChildrenRepositorie;
import tn.esprit.spring.Repository.ParentChildrenRepo;
import tn.esprit.spring.Repository.ParentRepo;
import tn.esprit.spring.Repository.PasswordResetTokenRepository;
import tn.esprit.spring.Repository.RoleRepository;
import tn.esprit.spring.Repository.SchooladminRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Repository.VerificationTokenRepository;
import tn.esprit.spring.Security.MyUserDetailsService;



@Service
@Transactional
public class UserService implements IUserService {
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private VerificationTokenRepository tokenRepository;

	    @Autowired
	    private PasswordResetTokenRepository passwordTokenRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private RoleRepository roleRepository;

	    @Autowired
	    private SessionRegistry sessionRegistry;
	    
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
    
        public static final String TOKEN_INVALID = "invalidToken";
        public static final String TOKEN_EXPIRED = "expired";
        public static final String TOKEN_VALID = "valid";

        public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
        public static String APP_NAME = "SpringRegistration";
    
    @Autowired
    MyUserDetailsService service;
  /*  
    @Override
    public int CreateNewKinderGarten(UserDTO userdto) {
        
        if (emailExist(userdto.getEmail())) {   
          return -1;
       }
       Users user = new Users();
       System.out.println(" 2");
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setUsername(userdto.getUsername());
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
      Users user = userRepository.findByEmail(email);
      
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
        user.setUsername(dto.getUsername());
     
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
         user.setUsername(dto.getUsername());
         
         Admins ad = new Admins();
         ad.setEmail(dto.getEmail());
         ad.setName(dto.getUsername());
         ADD.save(ad);
         service.saveUserComputingDerivedPassword(user,user.getPassword());
         return 0 ;
    }
    */
    
    @Override
    public Users registerNewUserAccount(final UserDTO accountDto) {
        if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final Users user = new Users();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setUsing2FA(accountDto.isUsing2FA());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public Users getUser(final String verificationToken) {
        final VerificationToken token = tokenRepository.findByToken(verificationToken);
        if (token != null) {
            return token.getUser();
        }
        return null;
    }

    @Override
    public VerificationToken getVerificationToken(final String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(final Users user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(final Users user) {
        final VerificationToken verificationToken = tokenRepository.findByUser(user);

        if (verificationToken != null) {
            tokenRepository.delete(verificationToken);
        }

        final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(user);

        if (passwordToken != null) {
            passwordTokenRepository.delete(passwordToken);
        }

        userRepository.delete(user);
    }

    @Override
    public void createVerificationTokenForUser(final Users user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID()
            .toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public void createPasswordResetTokenForUser(final Users user, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
    }

    @Override
    public Users findUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token);
    }

    @Override
    public Users getUserByPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token)
            .getUser();
    }

    @Override
    public Optional<Users> getUserByID(final long id) {
        return userRepository.findById(id);
    }

    @Override
    public void changeUserPassword(final Users user, final String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final Users user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public String validateVerificationToken(String token) {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }

        final Users user = verificationToken.getUser();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate()
            .getTime()
            - cal.getTime()
                .getTime()) <= 0) {
            tokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setEnabled(true);
        // tokenRepository.delete(verificationToken);
        userRepository.save(user);
        return TOKEN_VALID;
    }

    @Override
    public String generateQRUrl(Users user) throws UnsupportedEncodingException {
        return QR_PREFIX + URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME, user.getEmail(), user.getSecret(), APP_NAME), "UTF-8");
    }

    @Override
    public Users updateUser2FA(boolean use2FA) {
        final Authentication curAuth = SecurityContextHolder.getContext()
            .getAuthentication();
        Users currentUser = (Users) curAuth.getPrincipal();
        currentUser.setUsing2FA(use2FA);
        currentUser = userRepository.save(currentUser);
        final Authentication auth = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(), curAuth.getAuthorities());
        SecurityContextHolder.getContext()
            .setAuthentication(auth);
        return currentUser;
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public List<String> getUsersFromSessionRegistry() {
        return sessionRegistry.getAllPrincipals()
            .stream()
            .filter((u) -> !sessionRegistry.getAllSessions(u, false)
                .isEmpty())
            .map(o -> {
                if (o instanceof Users) {
                    return ((Users) o).getEmail();
                } else {
                    return o.toString();
                }
            })
            .collect(Collectors.toList());

    }
    
   
    
   

    public void save(Users user) {
    	userRepository.save(user);
	};
    
}
