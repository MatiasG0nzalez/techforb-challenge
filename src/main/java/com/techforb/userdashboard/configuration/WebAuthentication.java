package com.techforb.userdashboard.configuration;

import com.techforb.userdashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;



    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(inputDni -> {

            com.techforb.userdashboard.model.User user = userRepository.findByDni(inputDni);

            if (user != null) {

                    return new User(user.getDni(), user.getPassword(), AuthorityUtils.createAuthorityList("CLIENT"));

            }  else {

                throw new UsernameNotFoundException("Unknown user: " + inputDni);

            }

        });

    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }




}
