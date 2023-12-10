package etf.webshop.services;

import etf.webshop.model.entities.UserEntity;
import etf.webshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.requests.LoginRequest;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.model.requests.UserRequest;

import jakarta.validation.Valid;

@AllArgsConstructor
@Service
public class AuthService {

	private final UserRepository userRepository;
	private ModelMapper modelMapper;
	@Lazy
	private final PasswordEncoder passwordEncoder;

	public UserDTO signup(@Valid SignupRequest request) {
		UserDTO userDTO=null;
		if(!existsByUsername(request.getUsername())) {
			UserRequest user=modelMapper.map(request, UserRequest.class);
			userDTO=addUser(user);
		}
		return userDTO;
	}

	public UserDTO login(LoginRequest request) {
		return getUserByUsername(request.getUsername());
	}

	private boolean existsByUsername(String username){
		return userRepository.existsByUsername(username);
	}

	private UserDTO addUser(UserRequest user) {
		UserEntity userEntity= modelMapper.map(user, UserEntity.class);
		userEntity.setActive(true);
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity=userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDTO.class);
	}

	private UserDTO getUserByUsername(String username){
		UserEntity user=userRepository.findByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("Korisnik ne postoji!");
		}
		return modelMapper.map(userRepository.findByUsername(username), UserDTO.class);
	}
}
