package com.techforb.userdashboard.service;

import com.techforb.userdashboard.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransactionService {



    public ResponseEntity<?> getTransactions(Authentication authentication);


    public ResponseEntity<?> getRecentTransactions(Authentication authentication);


    public ResponseEntity<?> makeTransfer(Authentication authentication, String destinationAccount, double amount);


}
