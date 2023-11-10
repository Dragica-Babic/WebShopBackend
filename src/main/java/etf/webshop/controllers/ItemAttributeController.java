package etf.webshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import etf.webshop.model.dto.ItemAttributeDTO;
import etf.webshop.model.requests.ItemAttributeRequest;
import etf.webshop.services.ItemAttributeService;

import jakarta.validation.Valid;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/item-attributes")
public class ItemAttributeController {
	
	@Autowired
	private ItemAttributeService service;

	@GetMapping("/{itemId}")
	public ResponseEntity<List<ItemAttributeDTO>> getAttributes(@PathVariable int itemId){
		return ResponseEntity.ok(service.getItemAttributes(itemId));
	}
	
	@PostMapping()
	public ResponseEntity<ItemAttributeDTO> addItemAttribute(@Valid @RequestBody ItemAttributeRequest request){
		return ResponseEntity.ok(service.addItemAttribute(request));
	}
}
