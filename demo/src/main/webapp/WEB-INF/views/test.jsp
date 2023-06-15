<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<div id="progressBar">
  <div id="progress"></div>
</div>

<script>
function loadData() {
	  var progressBar = document.getElementById("progress");
	  var width = 0;
	  var interval = setInterval(frame, 10);

	  function frame() {
	    if (width >= 100) {
	      clearInterval(interval);
	    } else {
	      width += 1;
	      progressBar.style.width = width + "%";
	    }
	  }
	}

	// 데이터 로딩 시작
	loadData();
</script>
<style>
#progressBar {
  width: 200px;
  height: 20px;
  border: 1px solid #ccc;
}

#progress {
  width: 0;
  height: 100%;
  background-color: #4caf50;
}
</style>
</body>
</html>