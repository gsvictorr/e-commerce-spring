package br.com.backend.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String remetente;

    // envio de email simples

    public String enviarEmailSimples(String destinatario, String titulo, String mensagem) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(titulo);
            simpleMailMessage.setText(mensagem);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado";
        } catch (Exception ex) {
            return "Erro ao enviar email";
        }

    }

    // envio de email com template
    public void enviarEmail(String destinatario, String titulo, Map<String, Object> propriedades) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(titulo);
            mimeMessageHelper.setFrom(remetente);
            mimeMessageHelper.setTo(destinatario);
            mimeMessageHelper.setText(conteudoTemplate(propriedades), true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // gerar template
    public String conteudoTemplate(Map<String, Object> model) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(fmConfiguration.getTemplate("email-recuperacao-codigo.flth"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();

    }

}
