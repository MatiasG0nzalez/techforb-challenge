package com.techforb.userdashboard.controller;

import com.techforb.userdashboard.dto.TransactionDTO;
import com.techforb.userdashboard.dto.UserDTO;
import com.techforb.userdashboard.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactions(Authentication authentication){

            return transactionService.getTransactions(authentication);

    }

    @GetMapping("/transactions/recent")
    public ResponseEntity<?> getRecentTransactions(Authentication authentication){
        return transactionService.getRecentTransactions(authentication);
    }


    @PostMapping("/transactions")
    public ResponseEntity<?> makeTransaction(Authentication authentication, @RequestParam String destinationAccount, @RequestParam double amount ) {

       return transactionService.makeTransfer(authentication, destinationAccount, amount);

    }


}
