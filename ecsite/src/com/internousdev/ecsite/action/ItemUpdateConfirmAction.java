package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String errorMessage;

	public String execute(){
		String result=ERROR;

		if(!(itemName.equals(""))&&!(itemPrice.equals(""))&&!itemStock.equals("")){
			result=SUCCESS;
		}else{
			errorMessage="未入力の項目があります。";
		}
		return result;
	}


	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}

	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock=itemStock;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
