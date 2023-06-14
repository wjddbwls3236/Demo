<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login</title>
<script>
       // 알림창을 띄우고 페이지 이동 처리
      
       if ("${confirmMessage}" != "") {
           if (confirm("${confirmMessage}")) {
               location.href ='register';
           } else {
        	   location.href ='login';
           }
       }
       
       if ("${pwCkMsg}" != ""){
       	 alert("${pwCkMsg}");
            history.back();
       }
       
       
       if ("${message}" != "") {
         	alert("${message}");
       }
   
        
</script>

</head>
<body>
 	<h1>Login Page</h1>
    <form action="login_ok" method="post">
        <label for="userid">Userid:</label>
        <input type="text" id="Userid" name="BOARD_WRITER" ><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="BOARD_WRITER_PW" ><br><br>
        
        <input type="submit" value="Login">
    </form>
</body>
</html>