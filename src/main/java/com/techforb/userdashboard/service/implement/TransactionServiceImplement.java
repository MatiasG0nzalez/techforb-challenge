package com.techforb.userdashboard.service.implement;

import com.techforb.userdashboard.dto.TransactionDTO;
import com.techforb.userdashboard.model.Account;
import com.techforb.userdashboard.model.Transaction;
import com.techforb.userdashboard.model.User;
import com.techforb.userdashboard.repository.AccountRepository;
import com.techforb.userdashboard.repository.TransactionRepository;
import com.techforb.userdashboard.repository.UserRepository;
import com.techforb.userdashboard.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class TransactionServiceImplement implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public ResponseEntity<?> getTransactions(Authentication authentication) {

        List<TransactionDTO> transactions = userRepository.findByDni(authentication.getName()).getAccount().getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toList());

        if (!authentication.isAuthenticated()) {
            return new ResponseEntity<>("You do not have permission to perform this operation", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(transactions);
    }

    @Override
    public ResponseEntity<?> getRecentTransactions(Authentication authentication) {

        if (!authentication.isAuthenticated()) {
            return new ResponseEntity<>("You do not have permission to perform this operation", HttpStatus.BAD_REQUEST);
        }

        List<TransactionDTO> transactions = userRepository.findByDni(authentication.getName()).getAccount().getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toList());

        List<TransactionDTO> sortedTransactions = transactions.stream().sorted(Comparator.comparing(TransactionDTO::getDate).reversed()).collect(Collectors.toList());

        List<TransactionDTO> recentTransactions = sortedTransactions.stream().limit(10).collect(Collectors.toList());

        return ResponseEntity.ok(recentTransactions);
    }

    @Override
    @Transactional
    public ResponseEntity<?> makeTransfer(Authentication authentication, String destinationAccount, double amount) {

        if (!authentication.isAuthenticated()) {
            return new ResponseEntity<>("You do not have permission to perform this operation", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.findByDni(authentication.getName()).getAccount().getBalance() < amount) {
            return new ResponseEntity<>("Insufficient balance to perform this operation", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.findByDni(authentication.getName()).getAccount().getBalance() < amount) {
            return new ResponseEntity<>("Insufficient balance to perform this operation", HttpStatus.BAD_REQUEST);
        }

        if (amount <= 0) {
            return new ResponseEntity<>("The amount of the transaction is not valid.", HttpStatus.BAD_REQUEST);
        }


        Transaction transaction = new Transaction(destinationAccount, amount, LocalDateTime.now(),"Completed");

        User user = userRepository.findByDni(authentication.getName());

        Account account = accountRepository.findByCVU(user.getAccount().getCVU());

        double newBalance = user.getAccount().getBalance() - amount;

        account.setBalance(newBalance);

        account.addTransaction(transaction);

        accountRepository.save(account);


        transactionRepository.save(transaction);

        return ResponseEntity.ok("Successful transaction");

    }


}
