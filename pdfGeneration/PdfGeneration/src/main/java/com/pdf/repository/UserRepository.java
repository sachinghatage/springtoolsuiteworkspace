package com.pdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdf.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
