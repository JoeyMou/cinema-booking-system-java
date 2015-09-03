package dao;

import java.awt.List;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import toolsbean.DB;
import valuebean.MovieBean;
import valuebean.RunningMovieBean;

public class MovieDao {
	private DB connection = null;
	
	public MovieDao() {
		connection = new DB();
	}
	
	/**
	 * �������ݿ⣬������е�Ӱ������
	 * @return �������е�Ӱ��arrayList
	 */
	public ArrayList<MovieBean> showAllMovies() {
		ArrayList<MovieBean> arrayList = null;
		MovieBean  movieBean = null;
		String sql = "select * from 12222_movie";
		ResultSet rs = connection.executeQuery(sql);
		if (rs != null) {
			arrayList = new ArrayList<MovieBean>();
			try {
				while(rs.next()){
					movieBean = new MovieBean();
					
					movieBean.setMovieId(rs.getString("Movie_ID"));
					movieBean.setMovieName(rs.getString("Movie_Name"));
					movieBean.setProductionYear(rs.getString("Production_Year"));
					movieBean.setMovieType(rs.getString("Movie_Type"));
					movieBean.setDirector(rs.getString("Director"));
					movieBean.setActor(rs.getString("Actors"));
					movieBean.setMovieDescription(rs.getString("Movie_Desc"));
		
					arrayList.add(movieBean);
				}
			} catch (Exception e) {
				System.out.println("��ʾ���е�Ӱ����");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("��");
		}
		return arrayList;
	}
	
	/**
	 * �������ݿ⣬���movieId����Ӧ�����ڷ�ӳ�ĵ�Ӱ
	 * @param movieId
	 * @return arrayList
	 */
	public ArrayList<RunningMovieBean> showRunningMovies(String movieId) {
		ArrayList<RunningMovieBean> arrayList = null;
		RunningMovieBean runningMovieBean = null;
		String sql = "select * from 12222_running_movie where Movie_ID=" + movieId +"";
		ResultSet rs = connection.executeQuery(sql);
		if (rs != null) {
			arrayList = new ArrayList<RunningMovieBean>();
			try {
				while (rs.next()){
					runningMovieBean = new RunningMovieBean();
					
					runningMovieBean.setRunningMovieId(rs.getString("Running_Movie_ID"));
					runningMovieBean.setMovieId(rs.getString("Movie_ID"));
					runningMovieBean.setHallId(rs.getString("Hall_ID"));
					runningMovieBean.setShowtime(rs.getString("Showtime"));
					runningMovieBean.setPrice(rs.getString("Price"));
					
					arrayList.add(runningMovieBean);
				}
			} catch (Exception e) {
				System.out.println("��ʾ���ڷ�ӳ�ĵ�Ӱ����");
				e.printStackTrace();
			}
		}
		
		
		return arrayList;
	}
	
	/**
	 * ͨ��runningMovieId��ȡ��Ӧ��һ��runningMovieBean����
	 * @param runningMovieId
	 * @return
	 * @throws SQLException
	 */
	public RunningMovieBean getRunningMovie( String runningMovieId){
		RunningMovieBean runningMovieBean = null;
		String sql = "select * from 12222_running_movie where Running_Movie_Id=" + runningMovieId;
		ResultSet rs = connection.executeQuery(sql);
		if (rs!= null) {
			runningMovieBean = new RunningMovieBean();
			try {
				if (rs.next()) {
					runningMovieBean.setRunningMovieId(rs.getString("Running_Movie_ID"));
					runningMovieBean.setMovieId(rs.getString("Movie_ID"));
					runningMovieBean.setHallId(rs.getString("Hall_ID"));
					runningMovieBean.setPrice(rs.getString("Price"));
					runningMovieBean.setShowtime(rs.getString("Showtime"));
				}
			} catch (SQLException e) {
				System.out.println("��ȡrunningMovieBean����");
				e.printStackTrace();
			}
		}
		
		return runningMovieBean;
		
	}
}
