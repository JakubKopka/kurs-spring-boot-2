package pl.kopka.kursspringboot2.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kopka.kursspringboot2.Service.MailService;

import javax.mail.MessagingException;

@Aspect
@Component
public class MovieAspect {

    private MailService mailService;

    @Autowired
    public MovieAspect(MailService mailService) {
        this.mailService = mailService;
    }

    @After("@annotation(MovieAnnotation)")
    private void sendEmail() throws MessagingException {
        mailService.sendMail("mailto@gmial.com",
                "Emial Title",
                "Email Content", true);
    }
}
