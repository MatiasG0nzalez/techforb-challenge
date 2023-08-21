package com.techforb.userdashboard.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface AccountService {

    public ResponseEntity<?> getBalance(Authentication authentication);


    public ResponseEntity<?> withdrawMoney(double amount, Authentication authentication);


    public ResponseEntity<?> depositMoney(double amount, Authentication authentication);
}
