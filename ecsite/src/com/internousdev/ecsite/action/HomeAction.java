package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemListDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();
	private BuyItemListDAO buyItemListDAO=new BuyItemListDAO();

	public String execute() throws SQLException{
		String result="login";
		if(session.containsKey("id")){
			buyItemList=buyItemListDAO.getItemInfo();
			session.remove("buyItem_name");
			session.remove("buyItem_price");
			result=SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}

	public ArrayList<BuyItemDTO> getBuyItemList(){
		return buyItemList;
	}
	public void setBuyItemList(ArrayList<BuyItemDTO> buyItemList){
		this.buyItemList=buyItemList;
	}

	public BuyItemListDAO getBuyItemListDAO(){
		return buyItemListDAO;
	}
	public void setBuyItemListDAO(BuyItemListDAO buyItemListDAO){
		this.buyItemListDAO=buyItemListDAO;
	}

}
