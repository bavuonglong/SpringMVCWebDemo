package com.cnv.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnv.springweb.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
