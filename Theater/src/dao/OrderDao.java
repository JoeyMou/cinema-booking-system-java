package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.criteria.Order;

import toolsbean.DB;
import valuebean.MovieBean;
import valuebean.OrderBean;

public class OrderDao {
	private DB connection = null;

	public OrderDao() {
		connection = new DB();
	}

	/**
	 * 添加订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public boolean addOrder(OrderBean orderBean) {

		boolean mark;
		String sql = "insert into 12222_Orders(Customer_ID, Seat_ID, Order_Date, Total_Price) value("
				+ orderBean.getCustomerId()
				+ ","
				+ orderBean.getSeatId()
				+ ",'"
				+ orderBean.getDate()
				+ "',"
				+ orderBean.getPrice()
				+ ")";
		System.out.println(sql);
		mark = connection.executeUpdate(sql);
		return mark;

	}

	/**
	 * 根据用户Id获取所有订单信息
	 * 
	 * @param customerId
	 * @return
	 */
	public ArrayList<OrderBean> getOrders(String customerId) {
		ArrayList<OrderBean> arrayList = null;
		OrderBean orderBean = null;
		String sql = "select * from 12222_Orders where Customer_ID="
				+ customerId;
		ResultSet rs = connection.executeQuery(sql);
		if (rs != null) {
			arrayList = new ArrayList<OrderBean>();
			try {
				while (rs.next()) {
					orderBean = new OrderBean();

					orderBean.setCustomerId(customerId);
					;
					orderBean.setOrderId(rs.getString("Order_ID"));
					orderBean.setSeatId(rs.getString("Seat_ID"));
					orderBean.setDate(rs.getString("Order_Date"));
					orderBean.setPrice(rs.getString("Total_Price"));
					orderBean.setIsCommented(rs.getString("Is_Commented"));

					arrayList.add(orderBean);
				}
			} catch (Exception e) {
				System.out.println("获取所有订单信息错误");
				e.printStackTrace();
			}
		} else {
			System.out.println("空");
		}
		return arrayList;

	}
}
