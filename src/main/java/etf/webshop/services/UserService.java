package etf.webshop.services;

import etf.webshop.model.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.entities.UserEntity;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.model.requests.UserRequest;
import etf.webshop.repositories.UserRepository;

import jakarta.validation.Valid;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	@Lazy
	private final PasswordEncoder passwordEncoder;

	public UserDTO updateUser(@Valid SignupRequest user, int id) throws ResourceNotFoundException {
		UserEntity originalUser=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(("Korisnik nije pronađen!")));
		UserEntity userEntity=modelMapper.map(user, UserEntity.class);
		userEntity.setId(id);
		userEntity.setActive(true);

		if("".equals(user.getPassword())) {
			userEntity.setPassword(originalUser.getPassword());
		}
		else{
			userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		userEntity=userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDTO.class);
	}

	public UserDTO getUserById(int id) throws ResourceNotFoundException {
		UserEntity user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Korisnik nije pronađen!"));
		return modelMapper.map(user, UserDTO.class);
	}
	
	public UserDetails getByUsername(String username) {
		UserEntity user=userRepository.findByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("Korisnik ne postoji!");
		}
        return User.builder().username(user.getUsername()).password(user.getPassword()).build();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getByUsername(username);
	}
}
