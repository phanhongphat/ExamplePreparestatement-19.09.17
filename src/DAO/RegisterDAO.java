package DAO;

import java.sql.*;

import BEAN.Account;

public class RegisterDAO
{
	public static boolean InsertAccount(Connection conn,Account acc)
	{
		//create preparedstatement
		PreparedStatement pttm = null;
		// truyền truy vấn sql cho đối tượng preqaredstatement
		String sql = "insert into Account(uname,password) value(?,?)" ;
		try 
		{
			pttm = conn.prepareStatement(sql);
			
			//truyền 2 biến uname và password vào 2 dấu ? line 14
			String uname 	= acc.getUname();
			String password = acc.getPassword();
			
			pttm.setString(1,uname);						// 1 2 :paremeterindex là vị trí, x là biến 
			pttm.setString(2,password);
															//pttm.setString(parameterIndex, x);
			// thực thi truy vấn
			int kt = pttm.executeUpdate(); 							// khai báo int vì biến trả về của excuteupdate là kiểu int
		
			if (kt != 0)    // điề kiện if đúng thì thực thi thêm dữ liệu thành công
			{
				return true;
			}
			pttm.close();  // đóng pttm
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
