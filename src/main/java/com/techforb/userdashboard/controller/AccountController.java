package com.techforb.userdashboard.controller;

import com.techforb.userdashboard.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance(Authentication authentication){
        return accountService.getBalance(authentication);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdrawMoney(@RequestParam double amount, Authentication authentication){
        return accountService.withdrawMoney(amount, authentication);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> depositMoney(@RequestParam double amount, Authentication authentication){
        return accountService.depositMoney(amount, authentication);
    }

}
