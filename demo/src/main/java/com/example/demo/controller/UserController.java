package com.example.demo.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.PwdChange;
import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired 
	UserService userService;
	 
	//테이블 목록	
	@GetMapping("/main")
	public String boardList(Model m,HttpServletRequest request, HttpServletResponse response,
			BoardDTO b,HttpSession session) throws IOException  {
		
		
		response.setContentType("text/html;charset=UTF-8");
		//세션 확인
		String id = (String) session.getAttribute("id");
		if (id == null) {
			// 알림창 후 로그인 페이지로 리다이렉트
			m.addAttribute("error", "다시 로그인 하세요");
			return "main";
		}else {
		
			// 검색
			String findField = request.getParameter("findField");// 검색 필드
			String findName = request.getParameter("findName");// 검색어
			
			b.setFindField(findField);
			b.setFindName("%" + findName + "%");
			
			int page=1;//현재 페이지 번호
			int limit=10;//한페이지에 보여지는 목록 개수
	        
			if(request.getParameter("page") != null) {//get으로 전달된 쪽번호가 있는 경우 실행
				page=Integer.parseInt(request.getParameter("page"));//페이지 번호(쪽번호)를 정수 숫자로 변경해서 저장
			}
			b.setStartrow((page-1)*10+1);//시작행 번호
			b.setEndrow(b.getStartrow()+limit-1);//끝행 번호
			
		
			int totalCount=this.userService.getTotalCount();//총 레코드 개수
			
			List<BoardDTO> blist=this.userService.getBoardList(b);//게시물 목록
			
			
			//총페이지
			int maxpage=(int)((double)totalCount/limit+0.95);
			//현재 페이지에 보여질 시작페이지
			int startpage=(((int)((double)page/10+0.9))-1)*10+1;
			//현재 페이지에 보여질 마지막 페이지
			int endpage=maxpage;
			if(endpage>startpage+10-1) endpage=startpage+10-1;
			
			m.addAttribute("list",blist);//list속성 키이름에 목록저장
			m.addAttribute("totalCount",totalCount);//totalCount키이름에 총 레코드 개수 저장
			
			//페이징
			m.addAttribute("startpage",startpage);
			m.addAttribute("endpage",endpage);
			m.addAttribute("maxpage",maxpage);
			m.addAttribute("page",page);
	        
	        
	        return "main";
	    }
	}
	

	//로그인 페이지
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView loginM = new ModelAndView();
		loginM.setViewName("login"); // 뷰페이지
		
		return loginM;
	}
	
	
	//로그인 인증 후 메인
	@RequestMapping("/login_ok")
	public String member_login_ok(Model m,String BOARD_WRITER, String BOARD_WRITER_PW, HttpSession session, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		

		UserDTO user = this.userService.loginCheck(BOARD_WRITER);
		// 가입 회원 1인경우만 로그인 인증처리

		if (user == null) {
			
			AdminDTO admin= this.userService.adminloginCk(BOARD_WRITER); // 관리자 인지 체크
			if(admin != null) { 
				
				//일반회원 아니고 관리자일때
				if (!admin.getADMIN_PW().equals(admin.getADMIN_PW())) { // 비밀번호 확인 (다시 확인 필요)
					
					m.addAttribute("pwCkMsg", "비밀번호가 틀렸습니다.다시 입력해 주세요");
					return "login";
					
				} else { // 로그인 성공
					session.setAttribute("id", BOARD_WRITER); // 세션 아이디 저장

					return "admin"; //관리자 페이지로
				}
			}
			
			//일반 회원
			m.addAttribute("confirmMessage", "아이디가 존재하지 않습니다. 회원가입 하시겠습니까?");
			return "login";
			
		} else {

			if (!user.getBOARD_WRITER_PW().equals(PwdChange.getPassWord(BOARD_WRITER_PW, user.getSALT()))) { // 비밀번호 확인 (다시 확인 필요)
				
				m.addAttribute("pwCkMsg", "비밀번호가 틀렸습니다.다시 입력해 주세요");
				return "login";
				
			} else { // 비번이 같은경우
				session.setAttribute("id", BOARD_WRITER); // 세션 아이디 저장

				return "redirect:http://localhost:8080/users/main";
			}
		}
	}

	
	//회원가입 페이지
	@RequestMapping("/register")
	public ModelAndView Register() {
		ModelAndView joinM = new ModelAndView();
		joinM.setViewName("register");
		
		return joinM;
	}
	
	//회원 저장
	@RequestMapping("register_ok")
	public String register_ok(Model m,UserDTO user, HttpServletResponse response,HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		// 중복아이디 확인
		String id = user.getBOARD_WRITER();
		UserDTO userCk = this.userService.idcheck(id);// 중복아이디 검색

		int re = -1;// 중복 아이디가 없을때 반환

		if (userCk != null) { // 중복 아이디가 있다면
			re = 1;
			
			m.addAttribute("idMsg", "중복된 아이디 입니다.");
			return "register";

		}

		// 비번 암호화
		String raw = user.getBOARD_WRITER_PW(); // 사용자 비번

		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] bytes = new byte[16];
		random.nextBytes(bytes);
		String salt = new String(Base64.getEncoder().encode(bytes));

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(salt.getBytes());
		md.update(raw.getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		
		
		// 회원저장
		user.setSALT(salt);
		user.setBOARD_WRITER_PW(hex);// 암호화된 비번 저장
		user.setFILE_IDX(re);
		userService.userInsert(user); // 회원저장
		
		String message = "회원가입이 완료되었습니다. 로그인해주세요.";
		m.addAttribute("message", message);
		
		return "login";

	}
	
	
	
	
	
	
	
	
	
	
	
	
}