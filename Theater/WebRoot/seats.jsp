<%@page import="valuebean.SeatBean"%>
<%@page import="valuebean.RunningMovieBean"%>
<%@page import="valuebean.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GBK"%>
<%@ include file="header.jsp"%>

<%
	if ((String) request.getAttribute("messages") == "order succeed") {
		out.print("<H2>��ϲ�㣬Ԥ���ɹ�</H2>");
	}
	else if ((String) request.getAttribute("messages") == "order fail") {
		out.print("<H2>���ź���Ԥ��ʧ��</H2>");
	}
%>
<%
	ArrayList<SeatBean> seatList = (ArrayList<SeatBean>) request
			.getAttribute("seatList");
	out.print("<table cellspacing='8'>");
	int count = 0;//����һ������td�ĸ���
	for (int i = 0; i < seatList.size(); i++) {
		//�µ�һ��
		if (count == 0) {
			out.print("<tr>");
			out.print("<td>��" + seatList.get(i).getRowNumber()
					+ "��</td>");
		}
		if (seatList.get(i).isReserved()) {
			out.print("<td width='20' bgcolor='red'>1");
		} else {
			out.print("<td width='20' bgcolor='#1ec5e5'>0");
		}
		out.print("</td>");
		count++;
		//һ��������
		if (count == 12) {
			out.print("</tr>");
			count = 0;
		}

	}
	out.print("</table>");
%>
<%
	out.print("<h3>��ѡ��������λ</h3>");
	out.print("<form action='SeatServlet?action=chooseSeat' method='post'>");
	out.print("�к�:");
	out.print("<select name='Row_Num'>");
	out.print("<option value='1'>1</option>");
	out.print("<option value='2'>2</option>");
	out.print("<option value='3'>3</option>");
	out.print("<option value='4'>4</option>");
	out.print("<option value='5'>5</option>");
	out.print("<option value='6'>6</option>");
	out.print("<option value='7'>7</option>");
	out.print("<option value='8'>8</option>");
	out.print("<option value='9'>9</option>");
	out.print("<option value='10'>10</option>");
	out.print("<option value='11'>11</option>");
	out.print("<option value='12'>12</option>");
	out.print("</select>");
	out.print("�кţ�");
	out.print("<select name='Column_Num'>");
	out.print("<option value='1'>1</option>");
	out.print("<option value='2'>2</option>");
	out.print("<option value='3'>3</option>");
	out.print("<option value='4'>4</option>");
	out.print("<option value='5'>5</option>");
	out.print("<option value='6'>6</option>");
	out.print("<option value='7'>7</option>");
	out.print("<option value='8'>8</option>");
	out.print("<option value='9'>9</option>");
	out.print("<option value='10'>10</option>");
	out.print("<option value='11'>11</option>");
	out.print("<option value='12'>12</option>");
	out.print("</select>");
	out.print("&nbsp&nbsp");
	out.print("<input type='submit' value='ȷ��'>");
	out.print("</form>");
%>

<%@ include file="footer.jsp"%>
