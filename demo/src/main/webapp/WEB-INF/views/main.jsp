<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<script>
	if("${error}"!=""){
		alert("${error}"); 
		location.href ="http://localhost:8080/users/login";
	}
</script>
</head>

<body>
 <table border="1">
  <tr>
   <td colspan="5" align="right">총 게시물 수 : <strong>${totalCount}</strong> 개</td>
  </tr>
  <tr>
   <th>번호</th> <th>글쓴이</th> <th>제목</th> <th>내용</th> <th>조회수</th> <th>등록날짜</th>
  </tr>
  
  <c:if test="${!empty list}">
   <c:forEach var="b" items="${list}">
    <tr>
     <th>${b.BOARD_IDX}</th>
     <th>${b.BOARD_WRITER}</th>
     <th>${b.BOARD_TITLE}</th>
     <th>${b.BOARD_CONTENTS}</th>
     <th>${b.BOARD_VIEW_COUNT}</th>
     <th>${b.BOARD_WRITE_DATE}</th>
     
    </tr>
   </c:forEach>
  </c:if>
  
  <c:if test="${empty list}">
  <tr>
   <th colspan="5">게시물 목록이 없습니다!</th>
  </tr>
  </c:if>
  
  <%-- 페이징 즉 쪽나누기 출력 부분 --%>
  <tr>
   <th colspan="5">
    <c:if test="${page <= 1}">
     [이전]&nbsp;
    </c:if>
    <c:if test="${page > 1}">
     <a href="/users/main?page=${page-1}">[이전]</a>&nbsp;
    </c:if>
    
    <%--쪽번호 출력 --%>
    <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
      <c:if test="${a == page}"><%-- 현재 쪽번호가 선택되었다면 --%>
       <${a}>
      </c:if>
      <c:if test="${a != page}"><%-- 현재 쪽번호가 선택 안된 경우 --%>
      <a href="/users/main?page=${a}">[${a}]</a>&nbsp;
      </c:if>
    </c:forEach>
    
     <c:if test="${page >= maxpage}">
      [다음]
     </c:if>
     <c:if test="${page < maxpage}">
     <a href="/users/main?page=${page+1}">[다음]</a>
     </c:if>
   </th>
  </tr>
  
  <%-- <tr>
   <th colspan="5"><input type="button" value="글쓰기" onclick="location='/controller/board/board_write?page=${page}';" /></th>
                  책갈피 기능(페이징에서 내가 본 쪽번호로 이동하는 기능)을 구현하기 위해서 ?page=페이지번호를 get 으로 전달함.
  </tr> --%>
 </table>

</body>
</html>