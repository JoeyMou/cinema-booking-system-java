package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import valuebean.MovieBean;
import valuebean.RunningMovieBean;
import valuebean.SeatBean;
import dao.MovieDao;
import dao.SeatDao;

public class SeatServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("showSeatsAvailable")) {
			this.showSeatsAvailable(request, response);
		}
		if (action.equals("chooseSeat")) {
			this.chooseSeat(request, response);
		}
	}

	/**
	 * 显示指定场次所有座位的信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 */
	public void showSeatsAvailable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String runningMovieId = request.getParameter("Running_Movie_ID");
		// 通过参数runningMovieId获取一个runningMovieBean对象，并将其存入session中
		MovieDao movieDao = new MovieDao();
		RunningMovieBean runningMovieBean = movieDao
				.getRunningMovie(runningMovieId);
		request.getSession().setAttribute("runningMovieBean", runningMovieBean);
		// 通过seatDao获得所有座位的信息
		SeatDao seatDao = new SeatDao();
		ArrayList<SeatBean> seatList = seatDao
				.showSeatsAvailable(runningMovieId);
		// 通过RequestDispatcher将数据发给seats.jsp显示
		request.setAttribute("seatList", seatList);
		RequestDispatcher rd = request.getRequestDispatcher("seats.jsp");
		rd.forward(request, response);
	}

	/**
	 * 选择座位，并提交订单信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void chooseSeat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 先检验是否登陆
		if (request.getSession().getAttribute("username") == null) {
			request.setAttribute("messages", "login first");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			// 如果已经登陆，则修改该位置的预定状态
			String runningMovieId = (String) request.getSession().getAttribute(
					"runningMovieId");
			String rowNumber = request.getParameter("Row_Num");
			String columnNumber = request.getParameter("Column_Num");
			SeatDao seatDao = new SeatDao();
			seatDao.changeState(runningMovieId, rowNumber, columnNumber);
			// 通过RequestDispatcher将数据发给OrderServlet,生成订单信息
			String seatId = seatDao.getSeatId(runningMovieId, rowNumber,
					columnNumber);
			request.setAttribute("seatId", seatId);
			RequestDispatcher rd = request
					.getRequestDispatcher("OrderServlet?action=generateOrder&seatId="
							+ seatId);
			rd.forward(request, response);
		}

	}

}
