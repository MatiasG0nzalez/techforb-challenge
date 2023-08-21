package com.techforb.userdashboard.controller;

import com.techforb.userdashboard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/cards")
    public ResponseEntity<?> getCards(Authentication authentication){
        return cardService.getCards(authentication);
    }
}
