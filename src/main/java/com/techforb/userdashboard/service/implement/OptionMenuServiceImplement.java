package com.techforb.userdashboard.service.implement;

import com.techforb.userdashboard.dto.OptionMenuListDTO;
import com.techforb.userdashboard.model.OptionMenu;
import com.techforb.userdashboard.model.OptionMenuList;
import com.techforb.userdashboard.repository.OptionMenuListRepository;
import com.techforb.userdashboard.service.OptionMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class OptionMenuServiceImplement implements OptionMenuService {

    @Autowired
    private OptionMenuListRepository optionMenuListRepository;

    @Override
    public ResponseEntity<?> findUserHomeOptionsMenu() {

        OptionMenuList optionMenuList = optionMenuListRepository.findByCategory("User_Home");

        return ResponseEntity.ok(new OptionMenuListDTO(optionMenuList));
    }


}
