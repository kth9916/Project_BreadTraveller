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
		
		String subject ="test 메일";
		String content = "메일 테스트 내용";
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
