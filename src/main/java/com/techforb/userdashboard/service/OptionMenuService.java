package com.techforb.userdashboard.service;

import com.techforb.userdashboard.model.OptionMenu;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OptionMenuService {

    public ResponseEntity<?> findUserHomeOptionsMenu();


}
