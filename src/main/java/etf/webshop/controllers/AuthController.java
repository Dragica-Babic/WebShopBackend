package etf.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.requests.LoginRequest;
import etf.webshop.model.requests.PinRequest;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.services.AuthService;

import jakarta.validation.Valid;

@Validated
@RestController
@CrossOrigin(origins="*")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserDTO> signup(@Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(authService.signup(request));
	}
	
	@PostMapping("/activate/{id}")
	public ResponseEntity<?> activate(@PathVariable int id, @RequestBody PinRequest pin) {
		return ResponseEntity.ok(authService.activate(id, pin.getValue()));
	}
	
}
