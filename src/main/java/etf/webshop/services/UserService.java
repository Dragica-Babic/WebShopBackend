package etf.webshop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.AccountDTO;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.entities.Account;
import etf.webshop.model.entities.User;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.model.requests.UserRequest;
import etf.webshop.repositories.AccountRepository;
import etf.webshop.repositories.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO addUser(UserRequest user) {
		User userEntity= modelMapper.map(user, User.class);
		userEntity.setActive(true);
		userEntity=userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDTO.class);
	}

	public UserDTO updateUser(@Valid SignupRequest user, int id) throws ResourceNotFoundException {
		Account account=modelMapper.map(user, Account.class);
		UserDTO userDTO=getUserById(id);
		AccountDTO accountOriginal=accountService.getById(userDTO.getAccountId());
		if("".equals(account.getPassword())) {
			account.setPassword(accountOriginal.getPassword());
		}
		
		account.setId(userDTO.getAccountId());
		account=accountRepository.save(account);
		UserRequest userReq=modelMapper.map(user, UserRequest.class);
		userReq.setAccountId(userDTO.getAccountId());
		User userEntity=modelMapper.map(userReq, User.class);
		userEntity.setAvatar(userDTO.getAvatar());
		
		userEntity.setId(id);
		userEntity.setActivated(true);
		userEntity.setActive(true);
		userEntity=userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDTO.class);
	}
	
	public void activateUser(int id) {
		userRepository.activateUser(id);
	}
	
	public UserDTO getUserById(int id) throws ResourceNotFoundException {
		User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Korisnik nije pronađen!"));
		return modelMapper.map(user, UserDTO.class);
	}
	
	public boolean existsByUsernameAndPassword(String username, String password) {
		return userRepository.existsByAccountUsernameAndAccountPassword(username, password);
	}
	
	public boolean existsByUsername(String username) {
		return userRepository.existsByAccountUsername(username);
	}
	
	public UserDTO getByUsername(String username) {
		return modelMapper.map(userRepository.findByAccountUsername(username), UserDTO.class);
	}
	
	public void setAvatar(int id, String fileName) {
		UserDTO user=getUserById(id);
		user.setAvatar(fileName);
		user.setActivated(true);
		User userEntity=modelMapper.map(user, User.class);
		userEntity.setActive(true);
		userRepository.save(userEntity);
	}
	
}
