package com.techforb.userdashboard.repository;

import com.techforb.userdashboard.model.OptionMenuList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OptionMenuListRepository extends JpaRepository<OptionMenuList, Long> {

    public OptionMenuList findByCategory(String category);

}
