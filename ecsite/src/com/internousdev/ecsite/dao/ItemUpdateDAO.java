package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemOperateDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemUpdateDAO{

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<ItemOperateDTO> getItemInfo() throws SQLException{
		ArrayList<ItemOperateDTO> itemListDTO=new ArrayList<ItemOperateDTO>();
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
				itemListDTO.add(dto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		return itemListDTO;
	}

}
