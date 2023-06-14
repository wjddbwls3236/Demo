<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <div id="container">
        <div id="header">
            <tiles:insertAttribute name="header"/>
        </div>
        
        <div id="sidebar-left">
            <tiles:insertAttribute name="adminSide"/>
        </div>
        
        <div id="content">
            <tiles:insertAttribute name="body"/>
        </div>
        
        <div id="footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>
</body>
</html>