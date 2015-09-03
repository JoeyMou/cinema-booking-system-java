package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("showPersonalInfo")) {
			this.showPersonalInfo(request, response);
		}
		if (action.equals("showPersonalComments")) {
			this.showPersonalComments(request, response);
		}
	}

	public void showPersonalInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.sendRedirect("showPersonalInfo.jsp");
	}

	public void showPersonalComments(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
		

}
