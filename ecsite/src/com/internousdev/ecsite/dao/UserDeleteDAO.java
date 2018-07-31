package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserDeleteDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<UserDeleteDTO> getUserInfo() throws SQLException{

		ArrayList<UserDeleteDTO> userDeleteDTO=new ArrayList<UserDeleteDTO>();
		String sql="SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UserDeleteDTO dto=new UserDeleteDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdatedDate(rs.getString("updated_date"));
				userDeleteDTO.add(dto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		return userDeleteDTO;
	}

	public int userDelete(String[] deleteList) throws SQLException{

		String sql="DELETE FROM login_user_transaction WHERE login_id=?";
		int result=0;

		try{
			for(int i=0;i<deleteList.length;i++){
				String loginId=deleteList[i];
			    PreparedStatement ps=con.prepareStatement(sql);
			    ps.setString(1,loginId);

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
