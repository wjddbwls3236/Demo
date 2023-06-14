<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 헤더 영역 -->
    <div id="header">
        <!-- 목록 조회 검색창 -->
        <form action="/users/main">
        	<select class="form-control" id="findField" name="findField"
									style="margin-top: 15px;">
									<option value="all">전체</option>
									<option value="BOARD_WRITER">작성자</option>
									<option value="BOARD_TITLE">글제목</option>
								</select>
            <input type="text" name="findName" id="findName" placeholder="검색어를 입력하세요" />
            <button type="submit">검색</button>
        </form>
    </div>
    
    
    
</body>
</html>