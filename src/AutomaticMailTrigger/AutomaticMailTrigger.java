package AutomaticMailTrigger;


import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class AutomaticMailTrigger {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		String fileName="../Nestle/src/AutomaticMailTrigger/EmailDetails.xls";
		EmailData e1=new EmailData(fileName);
		
		String emailTextArr[]=e1.getEmailText();
		 System.out.println("subject : "+emailTextArr[0]);
		 System.out.println("body : "+emailTextArr[1]);
		 List<String> pathList=e1.getFilePath();
		String arr[]=e1.loginCredentials();
		System.out.println("User name :: "+arr[0]);
		System.out.println("Password :: "+arr[1]);
		
		List<EmailDto> ccEmailList = e1.mailCC();
		System.out.println("ccEmailList :: "+ccEmailList);
		
		List<EmailDto> toEmailList = e1.mailTo();
		
		System.out.println("toEmailList :: "+toEmailList);
		
		
		final String username = arr[0];
        final String password = arr[1];

        
        System.out.println(username);
        System.out.println(password);
        

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            String s="";
            for(EmailDto dto:toEmailList){
            	
            	if(dto.status.equalsIgnoreCase("y")){
            		s = s+dto.email+",";
            	}
            }
            if(s.length()>1)
            	s=s.substring(0,s.length()-1);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(s));
            String s2="";
            for(EmailDto dto:ccEmailList){
            	
            	if(dto.status.equalsIgnoreCase("y")){
            		s2 = s2+dto.email+",";
            	}
            }
            if(s2.length()>1)
            	s2=s2.substring(0,s2.length()-1);
            
            
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(s2));
            
            
            System.out.println("s ::"+s);
            System.out.println("s2 ::"+s2);
         
            message.setSubject(emailTextArr[0]);

            BodyPart messageBodyPart = new MimeBodyPart();
	        
	         // Now set the actual message
	      
	        messageBodyPart.setText(emailTextArr[1]);
	        
           // messageBodyPart.setContent("<h1>sending html mail check</h1>","text/html" ); 
   	         // Create a multipart message
   	         Multipart multipart = new MimeMultipart("related");

   	         // Set text message part
   	         multipart.addBodyPart(messageBodyPart);
   	         

   	         // Part two is attachment
   	         //TC Attachment
   	         
   	         for(String path:pathList){
   	        	 System.out.println("path : "+path);
   	        	 MimeBodyPart mb = new MimeBodyPart();

   	        	 DataSource source = new FileDataSource(path);

   	        	 mb.setDataHandler(new DataHandler(source));
   	  
   	        	 mb.setFileName(path);
   
   	        	 multipart.addBodyPart(mb);
 
   	         }

   	 
         
           	         message.setContent(multipart);

                    Transport.send(message);


            System.out.println("Mail sent succesfully!");

        } catch (MessagingException e) {
        	System.out.println(e);
            throw new RuntimeException(e);
        }

		
	}
}
