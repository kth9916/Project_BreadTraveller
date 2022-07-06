package com.proj.team;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MailTestController {

	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Test
	public void mailSendTest() throws Exception{
		
<<<<<<< HEAD
		String subject ="test ¸ÞÀÏ";
		String content = "¸ÞÀÏ Å×½ºÆ® ³»¿ë";
=======
		String subject ="test ë©”ì¼";
		String content = "ë©”ì¼ í…ŒìŠ¤íŠ¸ ë‚´ìš©";
>>>>>>> gyh
		String from ="modddl96@naver.com";
		String to = "modddl60@naver.com";
		
		try {
			MimeMessage email = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(email,"UTF-8");
			
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content,true);
			
			
			mailSender.send(email);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
