package com.lina.chat.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lina.chat.app.domain.User;
import com.lina.chat.app.dto.ApiResponseDto;
import com.lina.chat.app.dto.ApiResponseDto.ApiResponseDtoBuilder;
import com.lina.chat.app.dto.UserDto;
import com.lina.chat.app.mapper.CustomMapper;
import com.lina.chat.app.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired	
	private CustomMapper mapper;


	@RequestMapping(value = "/getSessionUser", method = RequestMethod.GET)
	public ResponseEntity<?> getSessionUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return ResponseEntity.ok(authentication.getName());
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		return "success";
	}

	@RequestMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ApiResponseDto login() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUserName(authentication.getName());
		UserDto userDto = mapper.userToUserDto(user);
		apiResponseDtoBuilder.withData(userDto).withMessage("success").withStatus(HttpStatus.OK);
		return apiResponseDtoBuilder.build();
	}

	@RequestMapping(value = "/403", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ApiResponseDto accessDenied() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		apiResponseDtoBuilder.withMessage("access denied").withStatus(HttpStatus.BAD_REQUEST);
		return apiResponseDtoBuilder.build();
	}

}
