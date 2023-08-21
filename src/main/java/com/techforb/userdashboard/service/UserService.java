package com.techforb.userdashboard.service;

import com.techforb.userdashboard.dto.UserDTO;
import com.techforb.userdashboard.dto.UserRegisterDTO;
import com.techforb.userdashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserService {

        public List<UserDTO> getUsers();

        public UserDTO getAuthUser(Authentication auth);

        public ResponseEntity<?> createUser(UserRegisterDTO userRegisterDTO);






}
