package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import valuebean.MasterBean;

import dao.LoginDao;

public class LogXServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("islogin")) {
			this.islogin(request, response);
		}
		if (action.equals("login")) {
			this.login(request, response);
		}
		if (action.equals("logout")) {
			this.logout(request, response);
		}
	}


	public void islogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String forward = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginer") != null)
			forward = "admin/AdminIndex.jsp";
		else
			forward = "admin/login.jsp";
		response.sendRedirect(forward);

	}
	
	
	/**
	 * µÇÂ¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		LoginDao masterDao = new LoginDao();
		MasterBean loginer = new MasterBean();
		loginer.setMasterName(request.getParameter("username"));
		loginer.setMasterPass(request.getParameter("password"));
		boolean mark = masterDao.login(loginer);
		if (!mark) {
			request.setAttribute("messages",
					"login fail");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginer", loginer);
			session.setAttribute("customerId", loginer.getMasterId());
			session.setAttribute("username", loginer.getMasterName());
			response.sendRedirect("index.jsp");
		}

	}

	/**
	 * µÇ³ö
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("index.jsp");
	}
}
