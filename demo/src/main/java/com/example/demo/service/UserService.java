package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public int getTotalCount() {
		
		return userMapper.getTotalCount();
	}
	
	
	public List<BoardDTO> getBoardList(BoardDTO b) {
		
		return this.userMapper.getBoardList(b);
	}


	public UserDTO loginCheck(String login_id) {
		
		return this.userMapper.loginCheck(login_id);
	}


	public UserDTO idcheck(String id) {
		
		return this.userMapper.idcheck(id);
	}


	public void userInsert(UserDTO user) {
		userMapper.userInsert(user);
		
	}


	public AdminDTO adminloginCk(String bOARD_WRITER) {
		
		return this.userMapper.adminloginCk(bOARD_WRITER);
	}


	public int getUserTotalCount() {
		return userMapper.getUserTotalCount();
	}


	public List<UserDTO> getUSerList(UserDTO u) {
		return this.userMapper.getUSerList(u);
	}


	public UserDTO getMember(String bOARD_WRITER) {
		return this.userMapper.getMember(bOARD_WRITER);
	}


	public void updatemember(UserDTO u) {
		
		 this.userMapper.updatemember(u);
	}


	public int getTotalCount2(UserDTO u) {
		// TODO Auto-generated method stub
		return this.userMapper.getTotalCount2(u);
	}


	




	
	
	
}
