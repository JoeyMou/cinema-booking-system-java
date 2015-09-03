<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	if ((String) request.getAttribute("messages") == "login fail") {
		out.print("<H2>账号密码错误，请重新登录</H2>");
	}
	else if ((String) request.getAttribute("messages") == "login first") {
		out.print("<H2>您还未登陆，请先登录</H2>");
	}
	else if ((String) request.getAttribute("messages") == "not admin"){
		out.print("<H2>您不是管理员，请先以管理员身份登录</H2>");
	}

%>
<div style="width:500px; height:300px; background-color:#ffff99">
	<p>老师可以使用测试用户：用户名：1234； 密码：1234</p>
	<h2>登陆</h2>
	<form action="LogXServlet?action=login" method="post">
		<p>
			用户名：<input type="text" name="username">
		</p>
		<p>
			密&nbsp&nbsp码：<input type="password" name="password">
		</p>
		<input type="submit" value="登陆">
	</form>
</div>

<%@ include file="footer.jsp"%>
