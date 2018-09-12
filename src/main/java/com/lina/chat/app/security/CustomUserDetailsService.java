package com.lina.chat.app.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lina.chat.app.domain.User;
import com.lina.chat.app.repository.UserRepository;
import com.lina.chat.app.repository.UserRolesRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	private final UserRolesRepository userRolesRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository) {
		this.userRepository = userRepository;
		this.userRolesRepository = userRolesRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		}
		List<String> roleNames = userRolesRepository.findRoleByUserName(username);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role : roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				user.getUserName(), //
				user.getPassword(), grantList);
		return userDetails;
	}
}
