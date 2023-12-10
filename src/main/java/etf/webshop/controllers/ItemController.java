package etf.webshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.ItemDTO;
import etf.webshop.model.requests.ItemRequest;
import etf.webshop.services.ItemService;
import etf.webshop.services.UtilService;

import jakarta.validation.Valid;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

	private ItemService itemService;
	private UtilService utilService;
	
	@GetMapping("/all")
	public ResponseEntity<Page<ItemDTO>> getAllItems(@RequestParam(required = false) Integer categoryId,
													 @RequestParam(required = false) String search,
													 @RequestParam(required = false) String location,
													 @RequestParam(required = false) String lowerPrice,
													 @RequestParam(required = false) String upperPrice,
													 Pageable page){

		Page<ItemDTO> items=itemService.getAllItems(page, categoryId, search, location, lowerPrice, upperPrice);
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
	
	@GetMapping("/delete/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteItem(id);
	}
	
	@PostMapping("/{id}/upload-image")
	public void uploadImage(@RequestBody MultipartFile file, @PathVariable int id) {
		utilService.uploadImage(file, id);
	}
	
	@PostMapping("/buy/{id}")
	public Integer buyItem(@PathVariable int id, @RequestBody Integer customerId) {
		return itemService.buyItem(id, customerId);
	}
}
