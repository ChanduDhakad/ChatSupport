package App.Runner.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import App.Runner.Model.LoginDto;
import App.Runner.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	

	@PostMapping("/login")
	public ResponseEntity<String> USerLogin(@RequestBody LoginDto logindto) throws LoginException{
		
	String result=	loginService.LoginAccount(logindto);
		
	
	return new ResponseEntity<String>(result,HttpStatus.OK);

}
	@DeleteMapping("/logout")
	public ResponseEntity<String> UserLogout(@RequestParam(required = false)String key) throws LoginException{
		String Result=loginService.LogoutAccount(key);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
