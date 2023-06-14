package com.example.demo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	
	int getTotalCount();

	List<BoardDTO> getBoardList(BoardDTO b);

	UserDTO loginCheck(String login_id);

	UserDTO idcheck(String id);

	void userInsert(UserDTO user);

	AdminDTO adminloginCk(String bOARD_WRITER);

	int getUserTotalCount();

	List<UserDTO> getUSerList(UserDTO u);

	UserDTO getMember(String bOARD_WRITER);

	void updatemember(UserDTO u);

	int getTotalCount2(UserDTO u);

	
	
	
}
