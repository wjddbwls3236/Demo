package com.example.demo.dto;

import lombok.Data;

@Data	
public class AdminDTO {
	private int ADMIN_IDX; 
	public int getADMIN_IDX() {
		return ADMIN_IDX;
	}
	public void setADMIN_IDX(int aDMIN_IDX) {
		ADMIN_IDX = aDMIN_IDX;
	}
	public String getADMIN_ID() {
		return ADMIN_ID;
	}
	public void setADMIN_ID(String aDMIN_ID) {
		ADMIN_ID = aDMIN_ID;
	}
	public String getADMIN_NAME() {
		return ADMIN_NAME;
	}
	public void setADMIN_NAME(String aDMIN_NAME) {
		ADMIN_NAME = aDMIN_NAME;
	}
	public String getADMIN_PW() {
		return ADMIN_PW;
	}
	public void setADMIN_PW(String aDMIN_PW) {
		ADMIN_PW = aDMIN_PW;
	}
	public String getADMIN_JOIN_DATE() {
		return ADMIN_JOIN_DATE;
	}
	public void setADMIN_JOIN_DATE(String aDMIN_JOIN_DATE) {
		ADMIN_JOIN_DATE = aDMIN_JOIN_DATE;
	}
	private String ADMIN_ID ;
	private String ADMIN_NAME;
	private String ADMIN_PW;
	private String ADMIN_JOIN_DATE;
}
