package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemUpdateDAO;
import com.internousdev.ecsite.dto.ItemOperateDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<ItemOperateDTO> itemList=new ArrayList<ItemOperateDTO>();
	private ItemUpdateDAO dao=new ItemUpdateDAO();

	public String execute() throws SQLException{
		itemList=dao.getItemInfo();
		session.remove("item_name");
		session.remove("item_price");
		session.remove("item_stock");

		return SUCCESS;
	}

	public ArrayList<ItemOperateDTO> getItemList(){
		return itemList;
	}
	public void setItemList(ArrayList<ItemOperateDTO> itemList){
		this.itemList=itemList;
	}

	public ItemUpdateDAO getDao(){
		return dao;
	}
	public void setDao(ItemUpdateDAO dao){
		this.dao=dao;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
