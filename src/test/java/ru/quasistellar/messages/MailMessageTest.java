package ru.quasistellar.messages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MailMessageTest {


    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private MailMessage mailMessage;

    @Test
    public void testSendMAllParams() throws Exception {


        String to = "test@mail.ru";
        String name = "Name";
        String email = "simple@mail.ru";
        String tel = "";
        String content = "HelloWorld";

        MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom("test@gmail.com");
            helper.setTo(to);
            helper.setSubject("New mail!");
            helper.setText(name + "\n" + email + "\n" + tel + "\n " + content);



        mailMessage.sendM(name,email,tel,content);

        Mockito.verify(javaMailSender).send(mail);
    }


}
