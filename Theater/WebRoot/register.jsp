<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="GBK"%>
<%@ include file="header.jsp" %>

<%
	out.print("<div style='width:500px; height:300px; background-color:#ffff99'>");
	out.print("<h2>ע��</h2>");
	out.print("<form action='RegisterServlet' onsubmit='return validate_form(this)' method='post'>");
	out.print("<p>�û�����<input type='text' name='username'></p>");
	out.print("<p>��&nbsp&nbsp�룺<input type='password' name='password'></p>");
	out.print("<p>��&nbsp&nbsp����<input type='text' name='tel'</p>");
	out.print("<p>��&nbsp&nbsp�䣺<input type='text' name='email'</p>");
	out.print("<p>��&nbsp&nbsp��<input type='radio' checked='checked' name='sex' value='1' />��");
	out.print("<input type='radio' name='sex' value='0' />Ů");
	out.print("<input type='submit' value='ע��'>");
	out.print("</form>");
	out.print("</div>");	
 %>
<script type="text/javascript">
	function validate_form(thisform)
	{
		if (thisform.username.value == null || thisform.username.value=="") 
		{
			alert("�û�������Ϊ�գ�");
			return false;
		}
		else if (thisform.tel.value == null || thisform.tel.value=="") 
		{
			alert("�ֻ����벻��Ϊ�գ�");
			return false;
		}
		else if (thisform.email.value == null || thisform.email.value=="") 
		{
			alert("���䲻��Ϊ�գ�");
			return false;
		}
		return true;
	}
</script>
 
 

<%@ include file="footer.jsp" %>
