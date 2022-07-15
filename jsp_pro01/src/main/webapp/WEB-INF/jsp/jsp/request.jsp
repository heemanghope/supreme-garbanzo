<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP -request</title>
</head>
<body>
  <h1>JSP  - request</h1>
  <h2>request.getMethod()</h2>
  <p>
    request.getMethod() -> <%=request.getMethod() %>
  </p>
  <form action="./request" method="get">
    <button type="submit">GET 전송</button>
  </form>
  <form action="./request" method="post">
    <button type="submit">POST 전송</button>
  </form>
  <hr>
  <h2>request.getParameter(name)</h2> 
  <p>
     request.getParameter(name)=> <%=request.getParameter("param_name") %><%--?물음표 이후에 나온다. --%>
  <br>
     name은 HTML 폼 관련속성 중 name 속성에 정의한 속성값이다.
  </p>
  <form action="./request" method="get">
      <div>
           <input type="text" name="param_name"> <%--파라메터 값 일치해야함 --%>    
       </div>
       <div>
         <button type="submit"> 전송</button>
       </div>
  </form>
  <hr>
  <h2>request.getParameterValues()</h2>
  <p>
    request.getParameterValues() -> 
    
    <%
    if(request.getParameterValues("param_chk") != null) {
       String[] sArr= request.getParameterValues("param_chk");
       for(String s: sArr) {
     %>	 
         <%=s+ "" %>  
     <% 
             } 
          }
    %>
  
    
 
   
  </p>
   <form action="./request" method="get"> 
      <div>
           <input type="checkbox" name="param_chk" value="a">     <%--이름은 같은데 value(값)이 다르게 :checkbox --%>
           <input type="checkbox" name="param_chk" value="b">     <%-- 복수선택.배열사용 --%>
           <input type="checkbox" name="param_chk" value="c">     
           <input type="checkbox" name="param_chk" value="d">     
       </div>
       <div>
         <button type="submit"> 전송</button>
       </div>
  </form>
   <hr>
   <h2>request.getParameterNames()</h2>
   <p>
       request.getParameterNames() -> 
       <%
          Iterator<String> iter= request.getParameterNames().asIterator();
          while(iter.hasNext()){
        %>
        	<%=iter.next() +" " %>
       <% 	
          }
       %>
   </p>  
   <form action="./request" method="get">
    <div>
      <input type="text" name="username">
    </div>
    <div>
      <input type="text" name="password">
    </div>
    <div>
      <button type="submit">전송</button>
    </div>
   </form>
   <hr>
   <h2>request.setCharacterEncoding()</h2>
   <p>
      request.setCharacterEncoding("UTF-8") ->
      <%=request.getParameter("param_name") %>
      <br>
      servlet 페이지에서 작성해야 적용됨.
   </p>
   <form action="./request" method="post">
     <div>
        <input type="text" name="param_name">
     </div>
     <button type="submit">전송</button>
   </form>
   <hr>
   <h2>request.getSession()</h2>
   <p>
     request.getSession() -> <%=request.getSession() %>
     JSESSIONID = "<%=request.getSession().getId() %>"<%--세션,로그인 정보를 세션에 담아놓기 가능 --%>
    </p>
    <form action="./request" method="get">
        <button type="submit">전송</button>
        </form>
</body>
</html>