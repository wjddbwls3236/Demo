package com.example.demo.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int BOARD_IDX;
	private String BOARD_WRITER;
	private String BOARD_TITLE; 
	private String BOARD_CONTENTS;
	private int BOARD_VIEW_COUNT;
	private String FILE_IDX; 
	private String BOARD_WRITE;
	private String BOARD_PUBLIC_FL; 
	private String BOARD_DEL_YN;
	private String BOARD_WRITE_DATE;
	private String findField;
	private String findName;
	
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

	public String getBOARD_WRITE_DATE() {
		return BOARD_WRITE_DATE;
	}

	public void setBOARD_WRITE_DATE(String bOARD_WRITE_DATE) {
		BOARD_WRITE_DATE = bOARD_WRITE_DATE;
	}
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호
	
	public int getBOARD_IDX() {
		return BOARD_IDX;
	}

	public void setBOARD_IDX(int bOARD_IDX) {
		BOARD_IDX = bOARD_IDX;
	}

	public String getBOARD_WRITER() {
		return BOARD_WRITER;
	}

	public void setBOARD_WRITER(String bOARD_WRITER) {
		BOARD_WRITER = bOARD_WRITER;
	}

	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}

	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}

	public String getBOARD_CONTENTS() {
		return BOARD_CONTENTS;
	}

	public void setBOARD_CONTENTS(String bOARD_CONTENTS) {
		BOARD_CONTENTS = bOARD_CONTENTS;
	}

	public int getBOARD_VIEW_COUNT() {
		return BOARD_VIEW_COUNT;
	}

	public void setBOARD_VIEW_COUNT(int bOARD_VIEW_COUNT) {
		BOARD_VIEW_COUNT = bOARD_VIEW_COUNT;
	}

	public String getFILE_IDX() {
		return FILE_IDX;
	}

	public void setFILE_IDX(String fILE_IDX) {
		FILE_IDX = fILE_IDX;
	}

	public String getBOARD_WRITE() {
		return BOARD_WRITE;
	}

	public void setBOARD_WRITE(String bOARD_WRITE) {
		BOARD_WRITE = bOARD_WRITE;
	}

	public String getBOARD_PUBLIC_FL() {
		return BOARD_PUBLIC_FL;
	}

	public void setBOARD_PUBLIC_FL(String bOARD_PUBLIC_FL) {
		BOARD_PUBLIC_FL = bOARD_PUBLIC_FL;
	}

	public String getBOARD_DEL_YN() {
		return BOARD_DEL_YN;
	}

	public void setBOARD_DEL_YN(String bOARD_DEL_YN) {
		BOARD_DEL_YN = bOARD_DEL_YN;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getStartrow() {
		return startrow;
	}
	
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	
}
