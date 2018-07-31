package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemDeleteDAO;
import com.internousdev.ecsite.dto.ItemOperateDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteAction extends ActionSupport{

	private String[] deleteList;
	private ArrayList<ItemOperateDTO> itemList=new ArrayList<ItemOperateDTO>();
	private ItemDeleteDAO itemDAO=new ItemDeleteDAO();
	private String deleteFlg;


	public String execute() throws SQLException{

		String result=SUCCESS;

		if(deleteFlg==null){
			itemList=itemDAO.getItemInfo();
		}else if(deleteFlg.equals("1")){
			delete();
			deleteFlg=null;
			result="complete";
		}

		return result;

	}

	public void delete() throws SQLException{

		itemDAO.itemDelete(deleteList);
		deleteList=null;

	}


	public ArrayList<ItemOperateDTO> getItemList(){
		return itemList;
	}
	public void setItemList(ArrayList<ItemOperateDTO> itemList){
		this.itemList=itemList;
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
