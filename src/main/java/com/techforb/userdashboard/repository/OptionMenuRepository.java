package com.techforb.userdashboard.repository;

import com.techforb.userdashboard.model.OptionMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OptionMenuRepository extends JpaRepository<OptionMenu, Long> {
}
