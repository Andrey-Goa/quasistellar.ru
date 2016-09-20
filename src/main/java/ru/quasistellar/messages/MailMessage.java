package ru.quasistellar.messages;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service("MailService")
public class MailMessage {

    private String to = "test@mail.ru";
    private final Logger loggerMail = LoggerFactory.getLogger((this.getClass()));

    @Autowired
    private JavaMailSender mailSender;

    public void sendM(String name, String email, String tel, String content ) {
        try {

            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom("test@gmail.com");
            helper.setTo(to);
            helper.setSubject("New mail!");
            helper.setText(name + "\n" + email + "\n" + tel + "\n " + content);
            mailSender.send(mail);

            loggerMail.info("Send email, client email: " + email);

        } catch (Exception e) {
           loggerMail.error("Mail Error: ", e);

        }
    }

}
