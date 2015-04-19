package com.cnv.springweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnv.springweb.entity.Blog;
import com.cnv.springweb.entity.Item;
import com.cnv.springweb.entity.Role;
import com.cnv.springweb.entity.User;
import com.cnv.springweb.repository.BlogRepository;
import com.cnv.springweb.repository.ItemRepository;
import com.cnv.springweb.repository.RoleRepository;
import com.cnv.springweb.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	//this annotation use to run init() method after spring context configuration which created during application startup during deployment on the server   
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);

		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setRoles(roles);
		
		userRepository.save(userAdmin);
		
		Blog blog = new Blog();
		blog.setName("van cuong ngo");
		blog.setUrl("https://www.google.com.vn");
		blog.setUser(userAdmin);
		blogRepository.save(blog);
		
		Item item1 = new Item();
		item1.setBlog(blog);
		item1.setTitle("first");
		item1.setLink("https://abc.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blog);
		item2.setTitle("second");
		item2.setLink("https://xyz.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
	}
	
}
