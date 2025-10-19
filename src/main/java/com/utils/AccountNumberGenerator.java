package com.utils;
import java.util.Random;
import org.springframework.stereotype.Component;
@Component
public class AccountNumberGenerator {
	public String userAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // 0-9
        }
        String accountNumber = sb.toString();
        return accountNumber;
    }
}
