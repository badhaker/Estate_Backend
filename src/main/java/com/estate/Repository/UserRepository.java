package com.estate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
