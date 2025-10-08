package com.assignment68.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment68.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
