<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String menuLocation = "";
	if(request.getAttribute("menuLocation") != null) {
		menuLocation = (String)request.getAttribute("menuLocation");
	}
%>
<header>
	<nav class="top-nav center">
		<ul class="nav">
			<li class="nav-item dropdown">
				<a class="nav-link" href="#">JSP/Servlet</a>
				<ul class="nav dropdown-nav">
					<li class="nav-item">
						<a class="nav-link" href="./jsp/script_tag">Script Tag</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./jsp/request">request</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./jsp/response">response</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./jsp/mvc">MVC Model</a>
					</li>
				</ul>
			</li>
			<c:if test="${not empty sessionScope.loginData}">
			<!-- 로그인 접속했을때 직원, 부서,지역이 나오게 하기 -->
			<li class="nav-item <%=menuLocation.equals("emps") ? "active" : "" %>">
				<a class="nav-link" href="./emps">직원</a>
			</li>
			<li class="nav-item <%=menuLocation.equals("depts") ? "active" : "" %>">
				<a class="nav-link" href="./depts">부서</a>
			</li>
			<li class="nav-item <%=menuLocation.equals("locs") ? "active" : "" %>">
				<a class="nav-link" href="./locs">지역</a>
			</li>
			<li class="nav-item">
					<c:url var="myInfoUrl" value="/myinfo" />
					<a class="nav-link" href="${myInfoUrl}">내정보</a>
			</li>
			<li class="nav-item">
					<c:url var="logoutUrl" value="/logout" />
					<a class="nav-link" href="${logoutUrl}">로그아웃</a>
			</li>
			</c:if>
		</ul>
	</nav>
</header>