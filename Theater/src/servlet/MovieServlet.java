package servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

import valuebean.MovieBean;
import valuebean.RunningMovieBean;

public class MovieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("showAllMovies")) {
			this.showAllMovies(request, response);
		}
		if (action.equals("showRunningMovies")) {
			this.showRunningMovies(request, response);
		}
		if (action.equals("arrangeRunningMovie")) {
			this.arrangeRunningMovie(request, response);
		}
	}

	/**
	 * ��ʾ���е�Ӱ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void showAllMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ͨ��movieDao�������movies������
		MovieDao movieDao = new MovieDao();
		ArrayList<MovieBean> movieList = movieDao.showAllMovies();
		// ͨ��RequestDispatcher�����ݷ���movies��jsp��ʾ
		request.setAttribute("movieList", movieList);
		RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
		rd.forward(request, response);
	}

	/**
	 * ��ʾ���ڷ�ӳ�ĵ�Ӱ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void showRunningMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ͨ��get������ò���movieId��ֵ
		String movieId = request.getParameter("movieId");
		// ͨ��movieDao���movieId����Ӧ�����ڷ�ӳ�ĵ�Ӱ��Ϣ
		MovieDao movieDao = new MovieDao();
		ArrayList<RunningMovieBean> runningMovieList = movieDao
				.showRunningMovies(movieId);
		// ͨ��RequestDispatcher�����ݷ���runningMovies��jsp��ʾ
		request.setAttribute("runningMovieList", runningMovieList);
		RequestDispatcher rd = request
				.getRequestDispatcher("runningMovies.jsp");
		rd.forward(request, response);
	}

	/**
	 * ����Ӱ��Ƭ
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean arrangeRunningMovie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean mark;
		// �ȼ����Ƿ��½
		if (request.getSession().getAttribute("username") == null) {
			mark = false;
			request.setAttribute("messages", "login first");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if((String)request.getSession().getAttribute("username") != "admin") {
			// ����Ѿ���½�����ǹ���Ա
			mark = false;
			request.setAttribute("messages", "not admin");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			//��Ƭ
			//arrange();
			mark = true;
		}
		
		return mark;
	}
}
