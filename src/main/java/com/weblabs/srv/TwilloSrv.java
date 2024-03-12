
package com.weblabs.srv;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwilloSrv {

    private static final String TWILIO_ACCOUNT_SID = "";
    private static final String TWILIO_AUTH_TOKEN = "";

    public void sendOtp(String phno, String otp) {

    	String number = "whatsapp:+91" + phno;
        String otpText = otp;  

        try {	
        	    Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
       	        Message message = Message.creator(
        	      new com.twilio.type.PhoneNumber(number),
        	      new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
        	      otpText
        	    ).create();
        	    System.out.println(message.getSid());
            System.out.println("SMS sent successfully. SID: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Error sending SMS: " + e.getMessage());
        }
    }

   
}
