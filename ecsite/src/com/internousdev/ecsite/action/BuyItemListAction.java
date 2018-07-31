package com.internousdev.ecsite.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class BuyItemListAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private BuyItemDTO dto=new BuyItemDTO();



	public String execute(){

		session.put("id",dto.getId());
		session.put("buyItem_name", dto.getItemName());
		session.put("buyItem_price",dto.getItemPrice());
		return SUCCESS;
	}

	public BuyItemDTO getDto(){
		return dto;
	}


	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
