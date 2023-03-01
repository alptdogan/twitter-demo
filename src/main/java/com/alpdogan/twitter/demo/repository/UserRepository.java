package com.alpdogan.twitter.demo.repository;

import com.alpdogan.twitter.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(int id);

    Optional<User> findByUsername(String username);

}
