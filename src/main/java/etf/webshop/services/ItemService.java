package etf.webshop.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.ItemDTO;
import etf.webshop.model.entities.Item;
import etf.webshop.model.requests.ItemRequest;
import etf.webshop.repositories.ItemRepository;
import etf.webshop.specification.ItemSearchCriteria;
import etf.webshop.specification.ItemSpecification;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class ItemService {

	private ItemRepository itemRepository;
	private ModelMapper modelMapper;
	
	public Page<ItemDTO> getAllItems(Pageable page, Integer categoryId, String search, String location, String lowerPrice, String upperPrice){
		Double lowerPriceValue=null;
		Double upperPriceValue=null;
		if(!lowerPrice.isEmpty()){lowerPriceValue=Double.parseDouble((lowerPrice));}
		if(!upperPrice.isEmpty()){upperPriceValue=Double.parseDouble((upperPrice));}
		ItemSearchCriteria criteria=new ItemSearchCriteria(categoryId, search, location, lowerPriceValue, upperPriceValue);
		Specification<Item> specification=ItemSpecification.createItemSpecification(criteria);
		return itemRepository.findAll(specification,page).map(p->modelMapper.map(p, ItemDTO.class));
	}

	public List<ItemDTO> getAll(){
		return  itemRepository.findAllByIsDeletedFalseAndIsActiveTrue().stream().map(p->modelMapper.map(p, ItemDTO.class)).collect(Collectors.toList());
	}
	
	//aktivne
	public Page<ItemDTO> getAllByUserId(int id, Pageable page){
		return itemRepository.findAllByUserIdAndIsDeletedFalseAndIsActiveTrue(id,page).map(p->modelMapper.map(p, ItemDTO.class));
	}
	
	//zavrsene
	public Page<ItemDTO> getAllFinishedItems(int id, Pageable page){
		return itemRepository.findAllByUserIdAndIsDeletedFalseAndIsActiveFalse(id,page).map(p->modelMapper.map(p, ItemDTO.class));
	}
	
	//istorija 
	public Page<ItemDTO> getAllByCustomerId(int id, Pageable page){
		return itemRepository.findAllByCustomerId(id, page).map(p->modelMapper.map(p, ItemDTO.class));
	}
	
	public ItemDTO getById(int id) {
		Item item = itemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
		return modelMapper.map(item, ItemDTO.class);
	}
	
	public ItemDTO addItem(ItemRequest itemReq){
		Item item=modelMapper.map(itemReq, Item.class);
		item.setActive(true);
		item=itemRepository.save(item);
		return getById(item.getId());
	}
	
	public ItemDTO updateItem(int id, ItemRequest itemReq) {
		Item item=modelMapper.map(itemReq, Item.class);
		item.setId(id);
		item.setActive(true);
		item=itemRepository.saveAndFlush(item);
		return getById(item.getId());
	}
	
	public int deleteItem(int id) {
		return itemRepository.deleteItem(id);
	}
	
	public void setImage(int id, String fileName) {
		ItemDTO item=getById(id);
		item.setImage(fileName);
		Item itemEntity=modelMapper.map(item, Item.class);
		itemEntity.setCustomerId(null);
		itemEntity.setActive(true);
		itemRepository.saveAndFlush(itemEntity);
	}
	
	public int buyItem(int id, Integer customerId) {
		return itemRepository.buyItem(id, customerId);
	}
}
