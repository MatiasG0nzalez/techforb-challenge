package com.techforb.userdashboard.repository;

import com.techforb.userdashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByDni(String dni);

}
