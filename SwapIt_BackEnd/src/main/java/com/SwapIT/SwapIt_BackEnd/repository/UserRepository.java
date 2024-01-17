package com.SwapIT.SwapIt_BackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SwapIT.SwapIt_BackEnd.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findFirstByEmail(String email);
}
