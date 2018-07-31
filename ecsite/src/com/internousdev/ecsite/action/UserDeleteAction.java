package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserDeleteDAO;
import com.internousdev.ecsite.dto.UserDeleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteAction extends ActionSupport{

	private String[] deleteList;
	private ArrayList<UserDeleteDTO> userList=new ArrayList<UserDeleteDTO>();
	private UserDeleteDAO userDAO=new UserDeleteDAO();
	private String deleteFlg;


	public String execute() throws SQLException{

		String result=SUCCESS;

		if(deleteFlg==null){
		    userList=userDAO.getUserInfo();
		}else if(deleteFlg.equals("1")){
			delete();
			deleteFlg=null;
			result="complete";
		}
		return result;


	}

	public void delete() throws SQLException{

		userDAO.userDelete(deleteList);


		deleteList=null;
	}


	public ArrayList<UserDeleteDTO> getUserList(){
		return userList;
	}
	public void setUserList(ArrayList<UserDeleteDTO> userList){
		this.userList=userList;
	}


	public String[] getDeleteList(){
		return deleteList;
	}
	public void setDeleteList(String[] deleteList){
		this.deleteList=deleteList;
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

}
