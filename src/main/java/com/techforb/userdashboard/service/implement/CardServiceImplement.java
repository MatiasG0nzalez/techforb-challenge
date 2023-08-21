package com.techforb.userdashboard.service.implement;

import com.techforb.userdashboard.dto.CardDTO;
import com.techforb.userdashboard.model.Card;
import com.techforb.userdashboard.model.User;
import com.techforb.userdashboard.repository.CardRepository;
import com.techforb.userdashboard.repository.UserRepository;
import com.techforb.userdashboard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImplement  implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> getCards(Authentication authentication) {

        if(!authentication.isAuthenticated()){
            return new ResponseEntity<>("You don't have permission to make this operation", HttpStatus.UNAUTHORIZED);
        }

        List<CardDTO> cards = userRepository.findByDni(authentication.getName()).getAccount().getCards().stream().map(CardDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(cards);
    }
}
