package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.security.interfaces.RSAKey;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dao.SeatDao;

import valuebean.MasterBean;
import valuebean.OrderBean;
import valuebean.RunningMovieBean;

public class OrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("generateOrder")) {
			this.generateOrder(request, response);
		}
		if (action.equals("showOrders")) {
			this.showOrders(request, response);
		}
	}

	/**
	 * 生成订单
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void generateOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		OrderBean orderBean = new OrderBean();
		// 通过session获得orderBean的各项参数
		RunningMovieBean runningMovieBean = (RunningMovieBean) request
				.getSession().getAttribute("runningMovieBean");
		MasterBean loginer = (MasterBean) request.getSession().getAttribute(
				"loginer");

		orderBean.setSeatId(new SeatDao().getSeatId(
				runningMovieBean.getRunningMovieId(),
				request.getParameter("Row_Num"),
				request.getParameter("Column_Num")));
		orderBean.setCustomerId(loginer.getMasterId());
		orderBean.setPrice(runningMovieBean.getPrice());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		orderBean.setDate(sdf.format(date));

		// 通过OrderDao向数据库插入订单信息
		boolean mark;
		OrderDao orderDao = new OrderDao();
		mark = orderDao.addOrder(orderBean);
		// 返回jsp前台
		if (mark) {
			request.setAttribute("messages", "order succeed");
		} else {
			request.setAttribute("messages", "order fail");
		}
		RequestDispatcher rd = request.getRequestDispatcher("orderResult.jsp");
		rd.forward(request, response);

	}
	
	/**
	 * 获取当前用户的所有订单信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
		
		OrderDao orderDao = new OrderDao();
		orderList = orderDao.getOrders(((MasterBean)request.getSession().getAttribute("loginer")).getMasterId());
		
		request.setAttribute("orderList", orderList);
		RequestDispatcher rd = request.getRequestDispatcher("showOrders.jsp");
		rd.forward(request, response);
	}

}
