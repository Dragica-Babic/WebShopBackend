package etf.webshop.controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.CategoryDTO;
import etf.webshop.services.CategoryService;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getAll(){
		List<CategoryDTO> categories = categoryService.findAll();
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getById(@PathVariable int id) throws ResourceNotFoundException{
		CategoryDTO category=categoryService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}
}
