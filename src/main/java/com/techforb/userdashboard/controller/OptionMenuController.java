package com.techforb.userdashboard.controller;

import com.techforb.userdashboard.model.OptionMenu;
import com.techforb.userdashboard.service.OptionMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class OptionMenuController {

    @Autowired
    private OptionMenuService optionMenuService;


    @GetMapping("/menu/home")
    public ResponseEntity<?> findUserHomeOptionsMenu(){
        return optionMenuService.findUserHomeOptionsMenu();
    }


}
