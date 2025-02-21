package com.example.PHONGTROSPRING.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PHONGTROSPRING.entities.User;
import com.example.PHONGTROSPRING.repository.UserRepository;
import com.example.PHONGTROSPRING.request.LoginRequest;
import com.example.PHONGTROSPRING.request.RegisterRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	 public void addUsers() {
	        User user1 = new User();
	        user1.setPassword("password123");
	        user1.setEmail("admin@example.com");
	        user1.setFullName("Nguyễn Văn A");
	        user1.setPhoneNumber("0901234567");
	        user1.setRole("Quản trị viên");
	        user1.setCreatedAt();

	        User user2 = new User();
	        user2.setPassword("password456");
	        user2.setEmail("user1@example.com");
	        user2.setFullName("Trần Thị B");
	        user2.setPhoneNumber("0907654321");
	        user2.setRole("Tìm kiếm");
	        user2.setCreatedAt();

	        User user3 = new User();
	        user3.setPassword("password789");
	        user3.setEmail("user2@example.com");
	        user3.setFullName("Lê Quang C");
	        user3.setPhoneNumber("0909876543");
	        user3.setRole("Chủ nhà");
	        user3.setCreatedAt();

	        User user4 = new User();
	        user4.setPassword("password321");
	        user4.setEmail("user3@example.com");
	        user4.setFullName("Phạm Minh D");
	        user4.setPhoneNumber("0912345678");
	        user4.setRole("Tìm kiếm");
	        user4.setCreatedAt();

	        repo.save(user1);
	        repo.save(user2);
	        repo.save(user3);
	        repo.save(user4);
	    }


	public User login(LoginRequest user) {
		User u = repo.findByphoneNumberAndPassword(user.getPhoneNumber(), user.getPassword());
		return u;
	}

	public boolean register(RegisterRequest user) {
		User u = new User();
		u.setFullName(user.getFullName());
		u.setPassword(user.getPassword());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setRole(user.getRole());
		u.setCreatedAt();
		u.setBalance(new BigDecimal("0.00"));
		repo.save(u);
		return true;
	}

	public boolean checkPhone(String phone) {
		return repo.existsByphoneNumber(phone) ? true : false;
	}
}
