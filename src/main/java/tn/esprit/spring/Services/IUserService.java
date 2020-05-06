/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Services;

import java.io.UnsupportedEncodingException;
import java.util.List;


import java.util.Optional;

import tn.esprit.spring.DTO.ChildDTO;
import tn.esprit.spring.DTO.UserDTO;
import tn.esprit.spring.DTO.parentDTO;
import tn.esprit.spring.Errors.UserAlreadyExistException;
import tn.esprit.spring.Models.Children;
import tn.esprit.spring.Models.Parents;
import tn.esprit.spring.Models.PasswordResetToken;
import tn.esprit.spring.Models.Users;
import tn.esprit.spring.Models.VerificationToken;

public interface IUserService {
   /* int CreateNewKinderGarten(UserDTO user);
    Children CreateNewChild(ChildDTO dto);
	Parents CreateNewParent(parentDTO dto);
	  int CreateNewAdmin(UserDTO dto);*/
	
	    Users registerNewUserAccount(UserDTO accountDto) throws UserAlreadyExistException;

	    Users getUser(String verificationToken);

	    void saveRegisteredUser(Users user);

	    void deleteUser(Users user);

	    void createVerificationTokenForUser(Users user, String token);

	    VerificationToken getVerificationToken(String VerificationToken);

	    VerificationToken generateNewVerificationToken(String token);

	    void createPasswordResetTokenForUser(Users user, String token);

	    Users findUserByEmail(String email);

	    PasswordResetToken getPasswordResetToken(String token);

	    Users getUserByPasswordResetToken(String token);

	    Optional<Users> getUserByID(long id);

	    void changeUserPassword(Users user, String password);

	    boolean checkIfValidOldPassword(Users user, String password);

	    String validateVerificationToken(String token);

	    String generateQRUrl(Users user) throws UnsupportedEncodingException;

	    Users updateUser2FA(boolean use2FA);

	    List<String> getUsersFromSessionRegistry();
}