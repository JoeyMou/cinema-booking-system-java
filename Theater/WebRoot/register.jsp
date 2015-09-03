<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="GBK"%>
<%@ include file="header.jsp" %>

<%
	out.print("<div style='width:500px; height:300px; background-color:#ffff99'>");
	out.print("<h2>注册</h2>");
	out.print("<form action='RegisterServlet' onsubmit='return validate_form(this)' method='post'>");
	out.print("<p>用户名：<input type='text' name='username'></p>");
	out.print("<p>密&nbsp&nbsp码：<input type='password' name='password'></p>");
	out.print("<p>手&nbsp&nbsp机：<input type='text' name='tel'</p>");
	out.print("<p>邮&nbsp&nbsp箱：<input type='text' name='email'</p>");
	out.print("<p>性&nbsp&nbsp别：<input type='radio' checked='checked' name='sex' value='1' />男");
	out.print("<input type='radio' name='sex' value='0' />女");
	out.print("<input type='submit' value='注册'>");
	out.print("</form>");
	out.print("</div>");	
 %>
<script type="text/javascript">
	function validate_form(thisform)
	{
		if (thisform.username.value == null || thisform.username.value=="") 
		{
			alert("用户名不能为空！");
			return false;
		}
		else if (thisform.tel.value == null || thisform.tel.value=="") 
		{
			alert("手机号码不能为空！");
			return false;
		}
		else if (thisform.email.value == null || thisform.email.value=="") 
		{
			alert("邮箱不能为空！");
			return false;
		}
		return true;
	}
</script>
 
 

<%@ include file="footer.jsp" %>
