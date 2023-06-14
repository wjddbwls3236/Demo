<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/waitme@1.19.0/waitMe.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/waitme@1.19.0/waitMe.min.css" rel="stylesheet"/>
<script>
$(document).ready(function() {
	// 버튼 클릭 이벤트 핸들러
	  $("#updateButton").click(function(event) {
        debugger;
        // 수정된 값 수집
        var writer = $('#writer').val();
        var writerName = $('#writerName').val();
        var writerPhone = $('#writerPhone').val();
        var writerEmail = $('#writerEmail').val();
        var params = {
        		"BOARD_WRITER" : writer,
            	"BOARD_WRITER_NAME" : writerName,
            	"BOARD_WRITER_PHONE" : writerPhone,
            	"BOARD_WRITER_EMAIL": writerEmail
    		};
        // Ajax 요청 전송
        $.ajax({
            type: "post",
            url: "updateMem",
            data: params,
            dataType: "json",
            beforeSend: function() {
            	/* $('body').waitMe({
            		effect : 'ios',
            		text : '수정 중입니다.',
            		bg : 'rgba(255,255,255,0.7)',
            		color : '#000',
            		source : 'img/img.svg'
            		}); */
            	
            	$('body').waitMe({
            		  effect: 'bounce',
            		  text: '로딩 중...',
            		  bg: 'rgba(255,255,255,0.7)',
            		  color: '#000',
            		  waitTime: -1
            		});
            	
              },
            success: function(response) {
                // 서버 처리 성공 시
                alert('회원 정보가 수정되었습니다.');
                window.location.replace("/getmem/"+response.BOARD_WRITER);
                // 추가로 필요한 작업 수행
            },
            error: function(request,status,error) {
                // 서버 처리 실패 시
                alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
            },
            complete: function() {
            	// 로딩 바 숨김
            	$('#loading-bar').waitMe('hide');
             }
        });
      });
	 });
</script>
</head>
<body  class="waitMe_body">
<div>
	<label for="writer">아이디:</label>
	<input type="text" id="writer" name="writer" value="${u.BOARD_WRITER}" readonly="readonly"/><br/>
	
    <label for="writerName">이름:</label>
    <input type="text" id="writerName" name="writerName" value="${u.BOARD_WRITER_NAME}" /><br/>
    
    <label for="writerPhone">전화번호:</label>
    <input type="text" id="writerPhone" name="writerPhone" value="${u.BOARD_WRITER_PHONE}" /><br/>
    
    <label for="writerEmail">이메일:</label>
    <input type="text" id="writerEmail" name="writerEmail" value="${u.BOARD_WRITER_EMAIL}" /><br/>
    
    <input type="hidden" name="writerIdx" value="${u.BOARD_WRITER_IDX}" />
    
    
    <button type="button" id="updateButton">수정</button>
</div>
<!-- 로딩바 -->






</body>
</html>