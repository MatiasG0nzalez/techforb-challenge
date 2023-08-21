package com.techforb.userdashboard.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface CardService {

    public ResponseEntity<?> getCards(Authentication authentication);


}
