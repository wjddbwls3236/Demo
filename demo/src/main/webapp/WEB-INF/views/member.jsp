<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>

<div >
<div id="header">
        <!-- 목록 조회 검색창 -->
        <form action="getmem">
        	<input type="text" name="findName" id="findName" placeholder="검색어를 입력하세요" />
            <button type="submit">검색</button>
        </form>
 </div>

 <table border="1" id="userTableBody" >
  <tr>
   <td colspan="5" align="right">총 게시물 수 : <strong>${totalCount}</strong> 개</td>
  </tr>
  <tr>
   <th>번호</th> <th>아이디	</th> <th>이름</th> <th>번호</th> <th>이메일</th> 
  </tr>
  
  <c:if test="${!empty list}">
   <c:forEach var="u" items="${list}">
    <tr>
     <th>${u.BOARD_WRITER_IDX}</th>
     <th><a href="/getmem/${u.BOARD_WRITER}">${u.BOARD_WRITER}</a></th>
     <th>${u.BOARD_WRITER_NAME}</th>
     <th>${u.BOARD_WRITER_PHONE}</th>
     <th>${u.BOARD_WRITER_EMAIL}</th>
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
     <a href="/getmem?page=${page-1}&findName=${findName}">[이전]</a>&nbsp;
    </c:if>
    
    <%--쪽번호 출력 --%>
    <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
      <c:if test="${a == page}"><%-- 현재 쪽번호가 선택되었다면 --%>
       <${a}>
      </c:if>
      <c:if test="${a != page}"><%-- 현재 쪽번호가 선택 안된 경우 --%>
      <a href="/getmem?page=${a}&findName=${findName}">[${a}]</a>&nbsp;
      </c:if>
    </c:forEach>
    
     <c:if test="${page >= maxpage}">
      [다음]
     </c:if>
     <c:if test="${page < maxpage}">
     <a href="/getmem?page=${page+1}&findName=${findName}">[다음]</a>
     </c:if>
   </th>
  </tr>
  <!-- 엑셀 다운로드 버튼 -->
            <tr>
                <th colspan="5">
                    <form action="getmem/download" method="get">
                        <input type="hidden" name="findName" value="${findName}" />
                        <input type="hidden" name="page" value="${page}" />
                        <button type="submit">회원목록 다운로드</button>
                    </form>
                </th>
            </tr>
            <tr>
                <th colspan="5">
                    <form action="getmem/upload" method="post" enctype="multipart/form-data">
	       				<input type="file" name="file" accept=".xlsx">
	        			<button type="submit">회원목록 가져오기</button>
    				</form>	
                </th>
            </tr>
  
   </table>



<script>
$(document).ready(function() {
	$('#findName').on('keyup', function() {
	var keyword = $(this).val();  
	 
	// AJAX 요청
	    $.ajax({
	      url: "getmem",
	      method: "get",
	      data: { findName : keyword },
	      
	      success: function(response) {
	    	$("#userTableBody").empty();
	    	var result = $(response).find("#userTableBody").html();
	    	$("#userTableBody").html(result);
	      },
	      error: function(xhr, status, error) {
	        console.log(error); // 에러 처리
	      }
    	});
  	});
});
</script>
</div>

</body>
</html>