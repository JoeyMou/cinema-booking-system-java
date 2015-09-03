package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import toolsbean.DB;
import valuebean.SeatBean;

public class SeatDao {
	private DB connection = null;

	public SeatDao() {
		connection = new DB();
	}

	/**
	 * ���ָ�����ε���λ��Ϣ
	 * 
	 * @param runningMovieId
	 * @return
	 */
	public ArrayList<SeatBean> showSeatsAvailable(String runningMovieId) {
		ArrayList<SeatBean> arrayList = null;
		SeatBean seatBean = null;
		String sql = "select * from 12222_seat_on_sale where Running_Movie_ID="
				+ runningMovieId + " order by Row_Num asc, Column_Num asc;";
		ResultSet rs = connection.executeQuery(sql);
		if (rs != null) {
			arrayList = new ArrayList<SeatBean>();

			try {
				while (rs.next()) {
					seatBean = new SeatBean();

					seatBean.setSeatId(rs.getInt("Seat_ID"));
					seatBean.setRowNumber(rs.getInt("Row_Num"));
					seatBean.setColumnNumber(rs.getInt("Column_Num"));
					seatBean.setReserved(rs.getBoolean("Is_Reserved"));

					arrayList.add(seatBean);
				}
			} catch (Exception e) {
				System.out.println("��ѯ��λ��Ϣ����");
				e.printStackTrace();
			}
		}
		return arrayList;

	}

	/**
	 * �ı���λ��Ԥ��״̬���ɹ�����true��ʧ�ܷ���false
	 * 
	 * @param runninString
	 * @param rowNumber
	 * @param columnNumber
	 * @return
	 */
	public boolean changeState(String runninString, String rowNumber,
			String columnNumber) {
		String sql = "update 12222_seat_on_sale set Is_Reserved=1 where Running_Movie_ID="
				+ runninString
				+ " and Row_Num="
				+ rowNumber
				+ " and Column_Num=" + columnNumber;
		if (connection.executeUpdate(sql)) {
			return true;
		} else {
			System.out.print("change the state of the seat wrongly");
			return false;
		}

	}
	
	/**
	 * ��ȡSeatId
	 * @param runninString
	 * @param rowNumber
	 * @param columnNumber
	 * @return
	 */
	public String getSeatId(String runningMovieId, String rowNumber,
			String columnNumber) {
		String seatId = "";
		String sql = "select * from 12222_seat_on_sale where Running_Movie_ID="
				+ runningMovieId + " and Row_Num=" + rowNumber
				+ " and Column_Num=" + columnNumber;
		ResultSet rs = connection.executeQuery(sql);
		
		if (rs != null) {
			try {
				if (rs.next()) {
					seatId = rs.getString("Seat_ID");
				}
			} catch (Exception e) {
				System.out.println("��ȡseatId����");
				e.printStackTrace();
			}
		}
		return seatId;
	}
}
