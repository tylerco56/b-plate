package com.wiedenman.b_plate.service;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import java.util.Properties;

import static com.wiedenman.b_plate.secret.SimpleMailCredentials.SMTP_AUTH_PWD;
import static com.wiedenman.b_plate.secret.SimpleMailCredentials.SMTP_AUTH_USER;
import static com.wiedenman.b_plate.secret.SimpleMailCredentials.SMTP_HOST_NAME;


public class SimpleMail {

    public static void main(String[] args) throws Exception{
        new SimpleMail().test();
    }

    public void test() throws Exception{
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);
        // uncomment for debugging infos to stdout
        // mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setContent("This is a test", "text/plain");
        message.setFrom(new InternetAddress("landon@wiedenman.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress("landonwiedenman@gmail.com"));
        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
