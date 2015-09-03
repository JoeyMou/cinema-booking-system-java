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
	 * 连接数据库，获得所有电影的数据
	 * @return 包含所有电影的arrayList
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
				System.out.println("显示所有电影错误");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("空");
		}
		return arrayList;
	}
	
	/**
	 * 连接数据库，获得movieId所对应的正在放映的电影
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
				System.out.println("显示正在放映的电影错误");
				e.printStackTrace();
			}
		}
		
		
		return arrayList;
	}
	
	/**
	 * 通过runningMovieId获取对应的一个runningMovieBean对象
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
				System.out.println("获取runningMovieBean错误");
				e.printStackTrace();
			}
		}
		
		return runningMovieBean;
		
	}
}
