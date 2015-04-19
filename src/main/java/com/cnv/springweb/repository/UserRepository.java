package com.cnv.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnv.springweb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
