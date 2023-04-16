package App.Runner.service;

import javax.security.auth.login.LoginException;

import App.Runner.Model.LoginDto;

public interface LoginService  {

	public String LoginAccount(LoginDto Uslogin)throws LoginException;
		
	public String LogoutAccount(String uuid)throws LoginException;
	
}
