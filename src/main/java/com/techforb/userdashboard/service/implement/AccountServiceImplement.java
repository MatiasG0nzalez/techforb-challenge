package com.techforb.userdashboard.service.implement;

import com.techforb.userdashboard.model.Account;
import com.techforb.userdashboard.model.User;
import com.techforb.userdashboard.repository.AccountRepository;
import com.techforb.userdashboard.repository.UserRepository;
import com.techforb.userdashboard.service.AccountService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImplement implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> getBalance(Authentication authentication) {

        if (!authentication.isAuthenticated()) {

            return new ResponseEntity<>("You do not have permissions to perform this operation", HttpStatus.BAD_REQUEST);

        }

        User user = userRepository.findByDni(authentication.getName());

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("balance", user.getAccount().getBalance());

        return ResponseEntity.ok(jsonResponse);


    }

    @Override
    @Transactional
    public ResponseEntity<?> withdrawMoney(double amount, Authentication authentication) {
        if (!authentication.isAuthenticated()) {

            return new ResponseEntity<>("You do not have permissions to perform this operation", HttpStatus.BAD_REQUEST);

        }

        if (amount <= 0) {

            return new ResponseEntity<>("Only withdraws greater than 0 are allowed", HttpStatus.BAD_REQUEST);

        }

        if (amount > userRepository.findByDni(authentication.getName()).getAccount().getBalance()) {

            return new ResponseEntity<>("The maximum balance available for withdrawal is: " + userRepository.findByDni(authentication.getName()).getAccount().getBalance(), HttpStatus.BAD_REQUEST);

        }


        User user = userRepository.findByDni(authentication.getName());

        Account account = accountRepository.findByCVU(user.getAccount().getCVU());

        double newBalance = user.getAccount().getBalance() - amount;

        account.setBalance(newBalance);

        accountRepository.save(account);

        return new ResponseEntity<>("Amount successfully withdrawn", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> depositMoney(double amount, Authentication authentication) {

        if (!authentication.isAuthenticated()) {

            return new ResponseEntity<>("You do not have permissions to perform this operation", HttpStatus.BAD_REQUEST);

        }

        if (amount <= 0) {

            return new ResponseEntity<>("Only deposits greater than 0 are allowed", HttpStatus.BAD_REQUEST);

        }


        User user = userRepository.findByDni(authentication.getName());

        Account account = accountRepository.findByCVU(user.getAccount().getCVU());

        double newBalance = user.getAccount().getBalance() + amount;

        account.setBalance(newBalance);

        accountRepository.save(account);

        return new ResponseEntity<>("Amount successfully deposited",HttpStatus.ACCEPTED);

    }

}
