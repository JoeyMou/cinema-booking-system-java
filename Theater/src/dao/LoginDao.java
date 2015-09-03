package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import toolsbean.DB;
import valuebean.MasterBean;



public class LoginDao {
	private DB connection = null;

	public LoginDao() {
		connection = new DB();
	}
	
//	public MasterBean getMaster(){
//		MasterBean master=null;
//		String sql="select * from 12222_customer where ";
//		ResultSet rs=connection.executeQuery(sql);
//		try{
//			if(rs!=null&&rs.next()){
//				master=new MasterBean();	
//				master.setMasterName(rs.getString(1));
//				master.setMasterSex(rs.getString(3));
//				master.setMasterOicq(rs.getString(4));
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return master;
//	}
	
	/**
	 * 连接数据库，实现登陆，并获得用户完整信息
	 * @param loginer
	 * @return
	 */
	public boolean login(MasterBean loginer){
		boolean mark=false;
		if(loginer!=null){
			String sql="select * from 12222_customer where Nickname='"+loginer.getMasterName()+"' and Pwd='"+loginer.getMasterPass()+"'";
			ResultSet rs=connection.executeQuery(sql);
			try {
				if(rs!=null&&rs.next()){
					loginer.setMasterId(rs.getString("Customer_ID"));
					loginer.setMasterSex(rs.getString("Sex"));
					loginer.setMasterTel(rs.getString("Tel"));
					loginer.setMasterEmail(rs.getString("Email"));
					mark=true;
				}
				else
					mark=false;
			} catch (SQLException e) {
				mark=false;
				e.printStackTrace();
			}
			try {
				rs.close();
				connection.closed();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mark;		
	}
}
