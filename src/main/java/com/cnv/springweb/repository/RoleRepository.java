package com.cnv.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnv.springweb.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
