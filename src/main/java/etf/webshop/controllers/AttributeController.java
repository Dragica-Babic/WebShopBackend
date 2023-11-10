package etf.webshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import etf.webshop.model.dto.AttributeDTO;
import etf.webshop.services.AttributeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/attributes")
public class AttributeController {
	
	@Autowired
	private AttributeService attributeService;

	@GetMapping("/{categoryId}")
	public ResponseEntity<List<AttributeDTO>> getAllBycategoryId(@PathVariable int categoryId){
		List<AttributeDTO> attributes = attributeService.getAllByCategoryId(categoryId);
		return ResponseEntity.ok(attributes);
	}
}
