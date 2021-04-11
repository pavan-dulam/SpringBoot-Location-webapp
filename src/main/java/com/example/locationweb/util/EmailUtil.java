package com.example.locationweb.util;

import javax.mail.MessagingException;

public interface EmailUtil {
		void sendEmail(String toAddress,String subject,String body) throws MessagingException;
}
