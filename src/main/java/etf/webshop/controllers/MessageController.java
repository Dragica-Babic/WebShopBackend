package etf.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import etf.webshop.model.dto.MessageDTO;
import etf.webshop.model.requests.MessageRequest;
import etf.webshop.services.MessageService;

import jakarta.validation.Valid;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping
	public ResponseEntity<MessageDTO> insertMessage(@Valid @RequestBody MessageRequest request) {
		return ResponseEntity.ok(messageService.insertMessage(request));
	}

}
