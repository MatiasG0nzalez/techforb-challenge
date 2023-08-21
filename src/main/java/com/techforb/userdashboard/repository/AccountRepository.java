package com.techforb.userdashboard.repository;

import com.techforb.userdashboard.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

   public Account findByCVU(String string);

}
