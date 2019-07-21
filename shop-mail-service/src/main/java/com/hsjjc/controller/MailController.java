package com.hsjjc.controller;


import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.Configuration;
import freemarker.template.Template;
@RestController
public class MailController {
	@Value("${spring.mail.username}")
	String mailFrom;
	
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/mail")
	public String sendSimpleMail(@RequestParam("mailto") String mailTo,@RequestParam("nickname") String nickname,@RequestParam("yzm") String yzm)  {
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailFrom);
		message.setTo(mailTo);
		message.setSubject("帐号邮件验证码");
		message.setText("验证码："+yzm);
		mailSender.send(message);
		return "success";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	@RequestMapping("/tmail")
	public String sendTemplateMail(@RequestParam("mailto") String mailTo,@RequestParam("nickname") String nickname,@RequestParam("yzm") String yzm) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			//基本设置.
			helper.setFrom(mailFrom);//发送者.
			helper.setTo(mailTo);//接收者.
			helper.setSubject("帐号邮件验证码");//邮件主题.
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("nickname", nickname);
			model.put("yzm", yzm);
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);  
			// 设定去哪里读取相应的ftl模板  
			cfg.setClassForTemplateLoading(this.getClass(), "/templates");  
			// 在模板文件目录中寻找名称为name的模板文件  
			Template template   = cfg.getTemplate("email.html");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
			helper.setText(html, true);
			mailSender.send(mimeMessage);
			return "success";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";

	}
	
}
