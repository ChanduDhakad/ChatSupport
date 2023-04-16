package App.Runner.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import App.Runner.Model.CurrentSession;
import App.Runner.Model.LoginDto;
import App.Runner.Model.User;
import App.Runner.Repository.CurrentSessionRepository;
import App.Runner.Repository.UserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class loginServices implements LoginService{

	@Autowired
	CurrentSessionRepository currRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public String LoginAccount(LoginDto Uslogin)throws LoginException {
		String key;
		Optional<CurrentSession> opt;
		User existingUser= userRepo.findByEmail(Uslogin.getEmail());
		if(existingUser!=null) {
			opt =currRepo.findById(existingUser.getUserId());
			if(opt.isPresent()) {
				throw new LoginException("User already Logged In with this Email");
			}	if(existingUser.getPassword().equals(Uslogin.getPassword())) {
				key= RandomString.make(6);
			}else {
				throw new LoginException("password is not Correct");
			}
		}else {
			throw new LoginException("User is not registered with this email");
		}
		return key;
	}

	@Override
	public String LogoutAccount(String uuid) throws LoginException {
	CurrentSession existing=currRepo.findByUuid(uuid);
	if(existing==null)
		throw new LoginException("NOT A VALID KEY");
	else {
		currRepo.delete(existing);
		return "User is sucessfully Logged out";
	}
	}
}
