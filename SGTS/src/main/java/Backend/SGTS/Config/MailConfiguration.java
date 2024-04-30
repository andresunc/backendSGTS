package Backend.SGTS.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Value("${email.sender}")
    private String emailUser;

    @Value("${email.password}")
    private String password;

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(emailUser);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp"); // Protocolo de transporte SMTP
        props.put("mail.smtp.auth", "true"); // Habilitar autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS para conexión segura
        props.put("mail.smtp.host", "smtp.gmail.com"); // Host de SMTP de Gmail
        props.put("mail.smtp.port", "587"); // Puerto SMTP de Gmail
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Confiar en el servidor SMTP de Gmail
        props.put("mail.transport.protocol", "smtp"); // Protocolo de transporte SMTP
        props.put("mail.smtp.auth", "true"); // Habilitar autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS para conexión segura
        props.put("mail.smtp.host", "smtp.mi.unc.edu.ar"); // Host de SMTP de la UNC
        props.put("mail.smtp.port", "587"); // Puerto SMTP de la UNC
        props.put("mail.transport.protocol", "smtp"); // Protocolo de transporte SMTP
        props.put("mail.smtp.auth", "true"); // Habilitar autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS para conexión segura
        props.put("mail.smtp.host", "smtp.live.com"); // Host de SMTP de Hotmail/Outlook
        props.put("mail.smtp.port", "587"); // Puerto SMTP de Hotmail/Outlook
        return mailSender;
    }
}
