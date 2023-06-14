package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class UserDTO {
	private int BOARD_WRITER_IDX;
	
	@JsonProperty("board_writer")
	private String BOARD_WRITER;
	
	@JsonProperty("board_writer_name")
	private String BOARD_WRITER_NAME;
	
	@JsonProperty("board_writer_pw")
	private String BOARD_WRITER_PW;
	
	@JsonProperty("board_writer_phone")
	private String BOARD_WRITER_PHONE;
	
	@JsonProperty("board_writer_email")
	private String BOARD_WRITER_EMAIL ;
	
	@JsonProperty("file_idx")
	private int FILE_IDX;
	private String BOARD_WRITER_JOIN_DATE;
	
	@JsonProperty("salt")
	private String SALT;
	private String DEL_YN;
	private String findField;
	private String findName;
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호
	
	
	public String getFindField() {
		return findField;
	}
	public void setFindField(String findField) {
		this.findField = findField;
	}
	public String getFindName() {
		return findName;
	}
	public void setFindName(String findName) {
		this.findName = findName;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public int getBOARD_WRITER_IDX() {
		return BOARD_WRITER_IDX;
	}
	public void setBOARD_WRITER_IDX(int bOARD_WRITER_IDX) {
		BOARD_WRITER_IDX = bOARD_WRITER_IDX;
	}
	public String getBOARD_WRITER() {
		return BOARD_WRITER;
	}
	public void setBOARD_WRITER(String bOARD_WRITER) {
		BOARD_WRITER = bOARD_WRITER;
	}
	public String getBOARD_WRITER_NAME() {
		return BOARD_WRITER_NAME;
	}
	public void setBOARD_WRITER_NAME(String bOARD_WRITER_NAME) {
		BOARD_WRITER_NAME = bOARD_WRITER_NAME;
	}
	public String getBOARD_WRITER_PW() {
		return BOARD_WRITER_PW;
	}
	public void setBOARD_WRITER_PW(String bOARD_WRITER_PW) {
		BOARD_WRITER_PW = bOARD_WRITER_PW;
	}
	public String getBOARD_WRITER_PHONE() {
		return BOARD_WRITER_PHONE;
	}
	public void setBOARD_WRITER_PHONE(String bOARD_WRITER_PHONE) {
		BOARD_WRITER_PHONE = bOARD_WRITER_PHONE;
	}
	public String getBOARD_WRITER_EMAIL() {
		return BOARD_WRITER_EMAIL;
	}
	public void setBOARD_WRITER_EMAIL(String bOARD_WRITER_EMAIL) {
		BOARD_WRITER_EMAIL = bOARD_WRITER_EMAIL;
	}
	public int getFILE_IDX() {
		return FILE_IDX;
	}
	public void setFILE_IDX(int fILE_IDX) {
		FILE_IDX = fILE_IDX;
	}
	public String getBOARD_WRITER_JOIN_DATE() {
		return BOARD_WRITER_JOIN_DATE;
	}
	public void setBOARD_WRITER_JOIN_DATE(String bOARD_WRITER_JOIN_DATE) {
		BOARD_WRITER_JOIN_DATE = bOARD_WRITER_JOIN_DATE;
	}
	public String getSALT() {
		return SALT;
	}
	public void setSALT(String sALT) {
		SALT = sALT;
	}
	public String getDEL_YN() {
		return DEL_YN;
	}
	public void setDEL_YN(String dEL_YN) {
		DEL_YN = dEL_YN;
	}
	
}
