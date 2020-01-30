package com.example.springsecurity.service;

import com.example.springsecurity.model.User;
import com.example.springsecurity.model.UserDetailsImpl;
import com.example.springsecurity.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		Optional<User> optionalUser = usersRepository.findByFirstName(userName);
		if (optionalUser.isPresent())
			return Optional.ofNullable(optionalUser)
					.orElseThrow(() -> new UsernameNotFoundException("Username Not Found")).map(UserDetailsImpl::new)
					.get();
		else
			return (UserDetails) new UsernameNotFoundException("Username not found");
	}
}
