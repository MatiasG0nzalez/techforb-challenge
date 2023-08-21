package com.techforb.userdashboard.service.implement;

import com.techforb.userdashboard.dto.UserDTO;
import com.techforb.userdashboard.dto.UserRegisterDTO;
import com.techforb.userdashboard.model.Account;
import com.techforb.userdashboard.model.Card;
import com.techforb.userdashboard.model.CardType;
import com.techforb.userdashboard.model.User;
import com.techforb.userdashboard.repository.AccountRepository;
import com.techforb.userdashboard.repository.CardRepository;
import com.techforb.userdashboard.repository.TransactionRepository;
import com.techforb.userdashboard.repository.UserRepository;
import com.techforb.userdashboard.service.UserService;
import com.techforb.userdashboard.utils.NumberGenerator;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;





    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO getAuthUser(Authentication auth) {
        return new UserDTO(userRepository.findByDni(auth.getName()));
    }

    @Override
    public ResponseEntity<?> createUser(UserRegisterDTO userRegisterDTO) {

        if (userRegisterDTO.getName().isBlank() || userRegisterDTO.getName().isEmpty()) {
            return new ResponseEntity<>("The name cannot be empty", HttpStatus.BAD_REQUEST);
        }


        if (userRepository.findByDni(userRegisterDTO.getDni()) != null) {
            return new ResponseEntity<>("There is already a registered user with this DNI", HttpStatus.BAD_REQUEST);
        }


        if (!userRegisterDTO.getDni().matches("^\\d{8}$")) {
            return new ResponseEntity<>("The DNI must have exactly 8 numeric digits.", HttpStatus.BAD_REQUEST);
        }

        if (!userRegisterDTO.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            return new ResponseEntity<>("The password must have at least 8 characters, one uppercase letter, one lowercase letter and one digit.", HttpStatus.BAD_REQUEST);
        }


        User user = new User(userRegisterDTO.getName(), userRegisterDTO.getDni(), passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(user);

        NumberGenerator numberGenerator = new NumberGenerator();

        Account account = new Account(numberGenerator.generateRandomString(20) , LocalDateTime.now(), 0);
        user.setAccount(account);
        account.setUser(user);

        accountRepository.save(account);


        Card card = new Card(userRegisterDTO.getName(),numberGenerator.generateRandomString(16), LocalDate.now().plusYears(4),numberGenerator.generateRandomThreeDigit(), CardType.DEBIT);
        account.addCard(card);
        cardRepository.save(card);
        accountRepository.save(account);







        return ResponseEntity.ok("User successfully registered");

    }




}
