package tn.esprit.spring.Security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
