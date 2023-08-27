package com.ozge.spring.jpa.postgresql.repository;

import com.ozge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByMarried(boolean married);

    List<User> findByEmailContaining(String email);
}
