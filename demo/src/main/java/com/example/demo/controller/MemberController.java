package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/getmem")
public class MemberController {
	@Autowired 
	UserService userService;
	
	
	//회원 조회
	@GetMapping
	public ModelAndView userList(UserDTO u,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView m= new ModelAndView();
		
		int page=1;//현재 페이지 번호
		int limit=10;//한페이지에 보여지는 목록 개수
		
		if(request.getParameter("page") != null) {//get으로 전달된 쪽번호가 있는 경우 실행
			page=Integer.parseInt(request.getParameter("page"));//페이지 번호(쪽번호)를 정수 숫자로 변경해서 저장
		}
		u.setStartrow((page-1)*10+1);//시작행 번호
		u.setEndrow(u.getStartrow()+limit-1);//끝행 번호
		
		
		//회원 목록
		List<UserDTO> ulist=this.userService.getUSerList(u);
		
		int totalCount=this.userService.getTotalCount2(u);//총 레코드 갯수
		
		m.setViewName("member");
		m.addObject("list", ulist);
		
		//총페이지
		int maxpage=(int)((double)totalCount/limit+0.95);
		//현재 페이지에 보여질 시작페이지
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 마지막 페이지
		int endpage=maxpage;
		if(endpage>startpage+10-1) {
			endpage=startpage+10-1;
		}
		
		m.addObject("totalCount",totalCount);//totalCount키이름에 총 레코드 개수 저장
		
		//페이징
		m.addObject("startpage",startpage);
		m.addObject("endpage",endpage);
		m.addObject("maxpage",maxpage);
		m.addObject("page",page);
	    m.addObject("findName",u.getFindName());
		return m;
	}
	
	// 회원 개별 조회
	@GetMapping("/{BOARD_WRITER}")
		public ModelAndView getMemberById(@PathVariable("BOARD_WRITER") String BOARD_WRITER) {
		ModelAndView m =new ModelAndView();
		UserDTO u = this.userService.getMember(BOARD_WRITER); // 아이디 기준으로 회원정보 가져옴
		
		m.setViewName("modify");
		m.addObject("u", u);
		return m;

	}
	
	//회원등록
	@PostMapping("/member")
    public Map<String, Object> createMember(@RequestBody UserDTO user) {
        
		userService.userInsert(user);
        // 등록 완료 메시지를 JSON 형식으로 응답
        String message = "등록되었습니다.";
        Map<String, Object> response = new HashMap<>();
        response.put("msg", message);

      
        return response;
    }
	
	//회원 수정
	@RequestMapping("/updateMem")
	public ResponseEntity<Map<String, String>> updateMember(UserDTO u){
		
		//회원 수정
		this.userService.updatemember(u);
		
		 Map<String, String> response = new HashMap<>();
		    response.put("message", "회원 정보가 수정되었습니다.");
		    response.put("BOARD_WRITER",u.getBOARD_WRITER());
	    return  ResponseEntity.ok(response);
			
	}
	
	
	//회원 목록 엑셀 다운로드
  	@GetMapping("/download")
	public void excelList(UserDTO u,HttpServletRequest request, HttpServletResponse response) {
		
  		int page=1;//현재 페이지 번호
		int limit=10;//한페이지에 보여지는 목록 개수
		
		if(request.getParameter("page") != null) {//get으로 전달된 쪽번호가 있는 경우 실행
			page=Integer.parseInt(request.getParameter("page"));//페이지 번호(쪽번호)를 정수 숫자로 변경해서 저장
		}
		u.setStartrow((page-1)*10+1);//시작행 번호
		u.setEndrow(u.getStartrow()+limit-1);//끝행 번호
		
		
		//회원 목록
		List<UserDTO> ulist=this.userService.getUSerList(u);
		
		try {
			//엑셀파일 생성
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Members");
			
			// 헤더 폰트 스타일 설정
	        XSSFFont headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14); // 크게 설정

	        //헤더 셀 스타일 설정
	        XSSFCellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);
	        headerCellStyle.setBorderBottom(BorderStyle.THIN);
	        headerCellStyle.setBorderTop(BorderStyle.THIN);
	        headerCellStyle.setBorderRight(BorderStyle.THIN);
	        headerCellStyle.setBorderLeft(BorderStyle.THIN);
			
			// 헤더 생성
	        XSSFRow headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("ID");
	        headerRow.createCell(1).setCellValue("Name");
	        headerRow.createCell(2).setCellValue("Phone");
	        headerRow.createCell(3).setCellValue("Email");
	        
	        //헤더에 스타이 적용
	        for (int i = 0; i < 4; i++) {
	            headerRow.getCell(i).setCellStyle(headerCellStyle);
	        }
	        
	        // 데이터 셀 스타일 설정
	        XSSFCellStyle dataCellStyle = workbook.createCellStyle();
	        dataCellStyle.setBorderBottom(BorderStyle.THIN);
	        dataCellStyle.setBorderTop(BorderStyle.THIN);
	        dataCellStyle.setBorderRight(BorderStyle.THIN);
	        dataCellStyle.setBorderLeft(BorderStyle.THIN);
	        
	        //회원 데이터 채우기
	        int rowNum = 1;
	        for (UserDTO member : ulist) {
	            XSSFRow row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(member.getBOARD_WRITER());
	            row.createCell(1).setCellValue(member.getBOARD_WRITER_NAME());
	            row.createCell(2).setCellValue(member.getBOARD_WRITER_PHONE());
	            row.createCell(3).setCellValue(member.getBOARD_WRITER_EMAIL());
	        
	            for (int i = 0; i < 4; i++) {
	                row.getCell(i).setCellStyle(dataCellStyle);
	            }
	        }
	        
	        //엑셀 파일 다운로드 설정
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=members.xlsx");
	
	        // 엑셀 파일 출력
	        OutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        outputStream.close();
	        
		 }catch (IOException e) {
		    e.printStackTrace();
		 }
		
	}
	
	//엑셀읽기
  	@PostMapping("/upload")
  	public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file) {
  	    try (
  	    	// 엑셀 파일 읽기
  	    	XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
  	        XSSFSheet sheet = workbook.getSheetAt(0);
  	        System.out.println("마지막행!!!!!!!!!!!!!"+sheet.getLastRowNum());
  	        List<UserDTO> userList = new ArrayList<>();

  	        // 헤더 행 스킵 (데이터 시작 행부터 읽기)
  	        int startRow = sheet.getFirstRowNum() + 1;
  	        for (int rowNum = startRow; rowNum <= sheet.getLastRowNum(); rowNum++) {
  	            XSSFRow row = sheet.getRow(rowNum);
  	            if (row == null) {
  	                continue;
  	            }

  	            // 각 셀의 데이터 추출
  	            String id = row.getCell(0).getStringCellValue();
  	            String name = row.getCell(1).getStringCellValue();
  	            String phone = row.getCell(2).getStringCellValue();
  	            String email = row.getCell(3).getStringCellValue();

  	            // UserDTO 객체 생성 및 데이터 설정
  	            UserDTO user = new UserDTO();
  	            user.setBOARD_WRITER(id);
  	            user.setBOARD_WRITER_NAME(name);
  	            user.setBOARD_WRITER_PHONE(phone);
  	            user.setBOARD_WRITER_EMAIL(email);

  	            // 리스트에 추가
  	            userList.add(user);
  	       }

	  	      ModelAndView m= new ModelAndView();
	  	      int totalCount=userList.size();  
	          
	  	      m.setViewName("member");
	          m.addObject("list", userList);
	          m.addObject("totalCount", totalCount);
	            
		          
	  	        // 처리 결과 반환
	  	      return m;

  	    } catch (IOException e) {
  	        e.printStackTrace();
  	        return null;
  	    }
  	   
  	}
  }
