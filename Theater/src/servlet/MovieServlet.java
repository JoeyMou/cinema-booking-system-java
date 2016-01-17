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
	 * 显示所有电影
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void showAllMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 通过movieDao获得所有movies的数据
		MovieDao movieDao = new MovieDao();
		ArrayList<MovieBean> movieList = movieDao.showAllMovies();
		// 通过RequestDispatcher将数据发给movies。jsp显示
		request.setAttribute("movieList", movieList);
		RequestDispatcher rd = request.getRequestDispatcher("movies.jsp");
		rd.forward(request, response);
	}

	/**
	 * 显示正在放映的电影
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void showRunningMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 通过get方法获得参数movieId的值
		String movieId = request.getParameter("movieId");
		// 通过movieDao获得movieId所对应的正在放映的电影信息
		MovieDao movieDao = new MovieDao();
		ArrayList<RunningMovieBean> runningMovieList = movieDao
				.showRunningMovies(movieId);
		// 通过RequestDispatcher将数据发给runningMovies。jsp显示
		request.setAttribute("runningMovieList", runningMovieList);
		RequestDispatcher rd = request
				.getRequestDispatcher("runningMovies.jsp");
		rd.forward(request, response);
	}

	/**
	 * 给电影排片
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
		// 先检验是否登陆
		if (request.getSession().getAttribute("username") == null) {
			mark = false;
			request.setAttribute("messages", "login first");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if((String)request.getSession().getAttribute("username") != "admin") {
			// 如果已经登陆，但是管理员
			mark = false;
			request.setAttribute("messages", "not admin");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			//排片
			//arrange();
			mark = true;
		}
		
		return mark;
	}
}
