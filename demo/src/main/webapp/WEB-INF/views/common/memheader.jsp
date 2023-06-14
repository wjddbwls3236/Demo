<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="header">
        <!-- 목록 조회 검색창 -->
        <form action="getmem">
        	<input type="text" name="findName" id="findName" placeholder="검색어를 입력하세요" />
            <button type="submit">검색</button>
        </form>
    </div>
</body>
</html>