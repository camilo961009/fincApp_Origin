package com.uniquindio.FincApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.uniquindio.FincApp.dto.EmployeeDTO;

@Service
public class SendEmailService {
	
	
	//Importante hacer la inyección de dependencia de JavaMailSender:
    @Autowired
    private JavaMailSender mailSender;
    

    public void sendEmail(List<EmployeeDTO> listClients, String subject, String content) {

        for (EmployeeDTO c : listClients) 
        { 
            SimpleMailMessage email = new SimpleMailMessage();

            //recorremos la lista y enviamos a cada cliente el mismo correo
            email.setTo(c.getEmail());
            email.setSubject(subject);
            email.setText(content);

            mailSender.send(email);
        }
    }
}
