package com.pdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdf.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
