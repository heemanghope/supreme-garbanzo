<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    <%-- 지시자 태그 --%>

<%!    //선언태그

    //멤버변수
     private String name= "Hello";
     
     //메서드
     public String hello(){
    	 return "Hello";
    	 
     }
%> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP - Script Tag</title>
</head>
<body>
      <%--주석 --%>
      <h1>JSP - Script Tag</h1>
      <ul>
      <%       //스크립트릿 태그
      
        //Java 주석
        for(int i=0; i< 5; i++) {
        	Random rd= new Random();
       
       %>
        	
        	<li><%= rd.nextInt(100) %></li>
       <%  	
           }
       %>
       </ul>
       <br>
     <input type="text" value="<%=name %>"><br> <%--<%=name은 표현식 태그 --%>
     <input type="text" value="<%=hello() %>">
     
</body>
</html>