package com.utils;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class UserPasswordGenerator {

	 public String userPassword() {
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i = 0; i < 6; i++) {
	            sb.append(random.nextInt(10)); // 0-9
	        }
	        String userPassword = sb.toString();
	        return userPassword;
	    }

}
