package tn.esprit.spring.Controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.Utils.MyConstants;


 
@Controller
public class AttachmentEmailController {
 
    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendAttachmentEmail")
    public String sendAttachmentEmail() throws MessagingException {
 
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
 
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
 
        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Test email with attachments");
         
        helper.setText("Hello, Im testing email with attachments!");
         
        String path1 = "/home/tran/Downloads/test.txt";
        String path2 = "/home/tran/Downloads/readme.zip";
 
     
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);
 

        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helper.addAttachment("Readme", file2);
 
        emailSender.send(message);
 
        return "Email Sent!";
    }
 
}