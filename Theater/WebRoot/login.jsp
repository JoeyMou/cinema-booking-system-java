<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	if ((String) request.getAttribute("messages") == "login fail") {
		out.print("<H2>�˺�������������µ�¼</H2>");
	}
	else if ((String) request.getAttribute("messages") == "login first") {
		out.print("<H2>����δ��½�����ȵ�¼</H2>");
	}
	else if ((String) request.getAttribute("messages") == "not admin"){
		out.print("<H2>�����ǹ���Ա�������Թ���Ա��ݵ�¼</H2>");
	}

%>
<div style="width:500px; height:300px; background-color:#ffff99">
	<p>��ʦ����ʹ�ò����û����û�����1234�� ���룺1234</p>
	<h2>��½</h2>
	<form action="LogXServlet?action=login" method="post">
		<p>
			�û�����<input type="text" name="username">
		</p>
		<p>
			��&nbsp&nbsp�룺<input type="password" name="password">
		</p>
		<input type="submit" value="��½">
	</form>
</div>

<%@ include file="footer.jsp"%>
