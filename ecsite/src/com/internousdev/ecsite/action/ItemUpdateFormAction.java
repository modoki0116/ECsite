package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.ItemOperateDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemUpdateFormAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemOperateDTO dto=new ItemOperateDTO();

	public String execute(){
		session.put("item_name",dto.getItemName());
		session.put("item_price",dto.getItemPrice());
		session.put("item_stock",dto.getItemStock());
		return SUCCESS;
	}

	public ItemOperateDTO getDto(){
		return dto;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
