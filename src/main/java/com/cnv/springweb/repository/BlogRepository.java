package com.cnv.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnv.springweb.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
