package etf.webshop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.model.dto.AccountDTO;
import etf.webshop.model.dto.PinDTO;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.requests.AccountRequest;
import etf.webshop.model.requests.LoginRequest;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.model.requests.UserRequest;

import jakarta.validation.Valid;

@Service
public class AuthService {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PinService pinService;
	@Autowired
	private EmailService emailService;
	
	public UserDTO signup(@Valid SignupRequest request) {
		UserDTO userDTO=null;
		if(!userService.existsByUsername(request.getUsername())) {
		AccountRequest account=modelMapper.map(request, AccountRequest.class);
		AccountDTO accountDTO=accountService.addAccount(account);
		UserRequest user=modelMapper.map(request, UserRequest.class);
		user.setAccountId(accountDTO.getId());
		userDTO=userService.addUser(user);
		if(userDTO != null) {
			pinService.insertPin(userDTO.getId());
			emailService.sendMail(userDTO.getEmail(), pinService.getByUserId(userDTO.getId()).getValue());
		}
		}
		return userDTO;
		
	}
	
	public UserDTO login(LoginRequest request) {
		if(userService.existsByUsernameAndPassword(request.getUsername(), request.getPassword())){
			UserDTO user=userService.getByUsername(request.getUsername());
			if(!user.isActivated()) {
				pinService.updatePin(user.getId());
				emailService.sendMail(user.getEmail(), pinService.getByUserId(user.getId()).getValue());
			}
			return user;
		}
		return null;
	}
	
	public boolean activate(int userId, String pin) {
		boolean result=false;
		PinDTO pinDTO=pinService.getByUserId(userId);
		if(pin.equals(pinDTO.getValue())) {
			result=true;
			userService.activateUser(userId);
		}
		
		return result;
	}
}
