package com.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.models.UserMO;

@Repository
public interface UserRE extends JpaRepository<UserMO, Long>{
}
