package toolsbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private final String url = "jdbc:mysql://127.0.0.1/theater";
    private final String userName = "root";
    private final String password = "";
    private Connection con = null;
    private Statement stm=null;
    
    /* ͨ�����췽���������ݿ����� */
    public DB(){
    	try {
    		Class.forName("com.mysql.jdbc.Driver"); 
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("�������ݿ�����ʧ�ܣ�");
    	}    	
    }
    /* �������ݿ����� */
    public void createCon() {
        try {
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
        }
    }
    /* ��ȡStatement���� */
    public void getStm(){
   		createCon();
    	try {
			stm=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����Statement����ʧ�ܣ�");
		}
    }
    /** 
     * @���� �����ݿ�����ӡ��޸ĺ�ɾ���Ĳ���
     * @���� sqlΪҪִ�е�SQL���
     * @����ֵ boolean��ֵ 
     */
    public boolean executeUpdate(String sql) {
    	System.out.println(sql);
        boolean mark=false;
    	try {
    		getStm();
            int iCount = stm.executeUpdate(sql);
            if(iCount>0)            	
            	mark=true;            
            else
            	mark=false;
        } catch (Exception e) {
            e.printStackTrace();
		    mark=false;
        }
        return mark;
    }
    /* ��ѯ���ݿ� */
    public ResultSet executeQuery(String sql) {
        ResultSet rs=null;
        try {
            getStm();
            try {
                rs = stm.executeQuery(sql);
            } catch (Exception e) {
            	e.printStackTrace();
                System.out.println("��ѯ���ݿ�ʧ�ܣ�");
            }
        } catch (Exception e) {
            e.printStackTrace();          
        }
        return rs;
    }
    /* �ر����ݿ�Ĳ��� */
    public void closed() {
    	if(stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�stm����ʧ�ܣ�");
			}
    	if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�con����ʧ�ܣ�");
			}
    }
}
