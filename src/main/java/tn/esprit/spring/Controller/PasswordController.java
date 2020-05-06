package tn.esprit.spring.Controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.esprit.spring.Models.Users;
import tn.esprit.spring.Services.EmailService;
import tn.esprit.spring.Services.UserService;





@Controller
public class PasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new ModelAndView("ForgetPassword");
    }
    

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request) {


		Users optional = userService.findUserByEmail(userEmail);

		if (optional== null) {
			modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
		} else {
			

			Users user = optional;
            final String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token); 

			
			userService.save(user);

			String appUrl = request.getScheme() + "://" + request.getServerName();
			
		
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("support@demo.com");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
					+ "/reset?token=" + token);
			
			emailService.sendEmail(passwordResetEmail);

		
			modelAndView.addObject("successMessage", "A password reset link has been sent to " + userEmail);
		}

		modelAndView.setViewName("ForgetPassword");
		return modelAndView;

	}

	
	/*@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		Users user = userService.findUserByResetToken(token);

		if (user!=null) { 
			modelAndView.addObject("resetToken", token);
			
		} else { 
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}

	
		return new ModelAndView("ResetPassword");
	}


	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

	
		Users user = userService.findUserByResetToken(requestParams.get("token"));

		
		if (user!=null) {
			
			Users resetUser = user; 
            
			   
            resetUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
            
			
			resetUser.setResetToken(null);

			
			userService.save(resetUser);

			
			redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

			modelAndView.setViewName("redirect:login");
			return modelAndView;
			
		} else {
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			modelAndView.setViewName("ResetPassword");	
		}
		
		return modelAndView;
   }
   */

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}
}