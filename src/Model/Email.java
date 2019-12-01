package Model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

/**
 * Class created by Abhi
 */

public class Email {

    private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    private final String username = "agarw9646@gapps.uwcsea.edu.sg";
    private String password = "010210Pranky!";

    public Email(String to, String subject, String body) {
        sendEmail(to, subject, body);
    }

    public void sendEmail(String to, String subject, String body) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.transport.protocol", "smtp");

        try {
            Session session = Session.getDefaultInstance(properties,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            // -- Create a new message --
            Message msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress("test@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject);
            msg.setText(body);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Email successfully sent...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}