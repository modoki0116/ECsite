package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemOperateDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<ItemOperateDTO> getItemInfo() throws SQLException{
		ArrayList<ItemOperateDTO> itemList=new ArrayList<ItemOperateDTO>();
		String sql="SELECT * FROM item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemOperateDTO dto=new ItemOperateDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdateDate(rs.getString("update_date"));

				itemList.add(dto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}

		return itemList;
	}


	public int itemDelete(String[] deleteList) throws SQLException{

		String sql="DELETE FROM item_info_transaction WHERE item_name=?";
		int result=0;

		try{
			for(int i=0;i<deleteList.length;i++){
				String itemName=deleteList[i];
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,itemName);

				result=ps.executeUpdate();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		return result;
	}

}
