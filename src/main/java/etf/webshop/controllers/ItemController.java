package etf.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.ItemDTO;
import etf.webshop.model.enums.ImageType;
import etf.webshop.model.requests.ItemRequest;
import etf.webshop.services.ItemService;
import etf.webshop.services.UtilService;
import etf.webshop.specification.ItemSearchCriteria;

import jakarta.validation.Valid;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private UtilService utilService;
	
	@PostMapping("/all")
	public ResponseEntity<Page<ItemDTO>> getAllItems(Pageable page, @RequestBody ItemSearchCriteria criteria){
		Page<ItemDTO> items=itemService.getAllItems(page, criteria);
		return ResponseEntity.ok(items);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ItemDTO>> getItems(){
		List<ItemDTO> items=itemService.getAll();
		return ResponseEntity.ok(items);
	}

	
	@GetMapping("/history/{id}")
	public ResponseEntity<Page<ItemDTO>> getUserPurchaseHistory(@PathVariable int id, Pageable page){
		Page<ItemDTO> items=itemService.getAllByCustomerId(id, page);
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> getItemById(@PathVariable int id) throws ResourceNotFoundException{
		ItemDTO item=itemService.getById(id);
		return ResponseEntity.ok(item);
	}
	
	@GetMapping("user-finished/{id}")
	public ResponseEntity<Page<ItemDTO>> getAllFinishedItems(@PathVariable int id, Pageable page){
		Page<ItemDTO> items=itemService.getAllFinishedItems(id, page);
		return ResponseEntity.ok(items);
	}
	
	//aktivne
	@GetMapping("user/{id}")
	public ResponseEntity<Page<ItemDTO>> getAllItemsByUserId(@PathVariable int id, Pageable page){
		Page<ItemDTO> items=itemService.getAllByUserId(id, page);
		return ResponseEntity.ok(items);
	}
	
	@PostMapping
	public ResponseEntity<ItemDTO> addItem(@Valid @RequestBody ItemRequest item) throws ResourceNotFoundException{
		ItemDTO newItem=itemService.addItem(item);
		
		return ResponseEntity.ok(newItem);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemDTO> updateItem(@Valid @RequestBody ItemRequest item, @PathVariable int id) throws ResourceNotFoundException{
		ItemDTO updatedItem=itemService.updateItem(id, item);
		return ResponseEntity.ok(updatedItem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable int id) {
		return ResponseEntity.ok(itemService.deleteItem(id));
	}
	
	@PostMapping("/{id}/upload-image")
	public void uploadImage(@RequestBody MultipartFile file, @PathVariable int id) {
		utilService.uploadImage(file, id, ImageType.ITEM);
	}
	
	@PutMapping("/buy/{id}")
	public ResponseEntity<?> buyItem(@PathVariable int id, @RequestBody Integer customerId) {
		return ResponseEntity.ok(itemService.buyItem(id, customerId));
	}
}
