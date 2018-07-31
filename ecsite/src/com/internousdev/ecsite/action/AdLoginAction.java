package com.internousdev.ecsite.action;


import com.internousdev.ecsite.dao.AdLoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdLoginAction extends ActionSupport{

	private String loginPassword;
	private AdLoginDAO adLoginDAO=new AdLoginDAO();
	private LoginDTO loginDTO=new LoginDTO();

	public String execute(){
		String result=ERROR;
		loginDTO=adLoginDAO.getLoginUserInfo(loginPassword);

		if(loginPassword.equals(loginDTO.getLoginPassword())){
			result=SUCCESS;
			return result;
		}
		return result;
	}


	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}



}
