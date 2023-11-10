package etf.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import etf.webshop.model.dto.UserDTO;
import etf.webshop.model.enums.ImageType;
import etf.webshop.model.requests.SignupRequest;
import etf.webshop.services.UserService;
import etf.webshop.services.UtilService;

import jakarta.validation.Valid;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UtilService utilService;
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(userService.updateUser(request, id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable int id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PutMapping("/{id}/activate")
	public void activateUser(@PathVariable int id) {
		userService.activateUser(id);
	}
	
	@PostMapping("/{id}/upload-image")
	public void uploadImage(@PathVariable int id, @RequestBody MultipartFile file) {
		utilService.uploadImage(file, id, ImageType.USER);
	}
}
