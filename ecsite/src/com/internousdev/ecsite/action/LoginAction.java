package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemListDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();
	private BuyItemListDAO buyItemListDAO=new BuyItemListDAO();

	public String execute() throws SQLException{
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			buyItemList=buyItemListDAO.getItemInfo();
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",0);


			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
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

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
