package com.lina.chat.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lina.chat.app.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
    public User findByUserName(String username);
    
}