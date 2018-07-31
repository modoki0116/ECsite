package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemUpdateCompleteDAO {

	private DateUtil dateUtil=new DateUtil();
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	String sql="UPDATE item_info_transaction SET item_name=?,item_price=?,item_stock=?,update_date=? WHERE item_name=?";

	public void updateItem(String updateName,String updatePrice,String updateStock,String preName) throws SQLException{

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,updateName);
			ps.setString(2,updatePrice);
			ps.setString(3,updateStock);
			ps.setString(4,dateUtil.getDate());
			ps.setString(5,preName);

			ps.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}

	}

}
