package com.example.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pet.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByusernameAndPassword(String username, String password);
	User findByuserId(long userId);
	User findByusername(String userName);
}
