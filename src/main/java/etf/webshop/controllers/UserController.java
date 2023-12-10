package etf.webshop.controllers;

import etf.webshop.exceptions.UnauthorizedException;
import etf.webshop.model.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.services.UserService;

import jakarta.validation.Valid;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(userService.updateUser(request, id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable int id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

}
