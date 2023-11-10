package etf.webshop.controllers;

import java.util.List;

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
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.QuestionDTO;
import etf.webshop.model.requests.QuestionRequest;
import etf.webshop.services.QuestionService;

import jakarta.validation.Valid;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	private QuestionService service;
	
	@GetMapping("/{itemId}")
	public ResponseEntity<List<QuestionDTO>> getAllByItemId(@PathVariable int itemId){
		return ResponseEntity.ok(service.getAllByItemId(itemId));
	}
	
	@PostMapping
	public ResponseEntity<QuestionDTO> insertQuestion(@Valid @RequestBody QuestionRequest request) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.insert(request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<QuestionDTO> addAnswer(@PathVariable int id, @Valid @RequestBody QuestionRequest request) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.addAnswer(id, request));
	}
}
