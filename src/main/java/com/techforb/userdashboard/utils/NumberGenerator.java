package com.techforb.userdashboard.utils;
import java.security.SecureRandom;
import java.util.Random;


public class NumberGenerator {

    private static final String ALLOWED_CHARACTERS = "0123456789";
    private static final SecureRandom random = new SecureRandom();

    public String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public int generateRandomThreeDigit() {
        Random random = new Random();
        int minValue = 100;  // Valor mínimo de 3 dígitos
        int maxValue = 999;  // Valor máximo de 3 dígitos
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

}
