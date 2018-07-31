package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemListDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<BuyItemDTO> getItemInfo() throws SQLException{
		ArrayList<BuyItemDTO> buyItemDTO=new ArrayList<BuyItemDTO>();

		String sql="SELECT id,item_name,item_price FROM item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				buyItemDTO.add(dto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		return buyItemDTO;
	}

}
