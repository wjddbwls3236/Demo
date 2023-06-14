<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<script>
        // 알림창을 띄우고 페이지 이동 처리
        if ("${idMsg}" != ""){
        	 alert("${idMsg}");
             history.back();
        }
        
</script>

</head>
<body>
	<h1>Registration Page</h1>
    <form action="register_ok" method="post">
        <label for="userid">userid:</label>
        <input type="text" id="userid" name="BOARD_WRITER" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="BOARD_WRITER_PW" required><br><br>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="BOARD_WRITER_NAME" required><br><br>
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="BOARD_WRITER_PHON" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="BOARD_WRITER_EMAIL" required><br><br>
        
        <input type="submit" value="register_ok">
    </form>
</body>
</html>