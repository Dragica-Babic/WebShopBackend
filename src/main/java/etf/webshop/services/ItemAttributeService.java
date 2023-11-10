package etf.webshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.model.dto.ItemAttributeDTO;
import etf.webshop.model.entities.ItemAttribute;
import etf.webshop.model.requests.ItemAttributeRequest;
import etf.webshop.repositories.ItemAttributeRepository;

@Service
public class ItemAttributeService {

	@Autowired
	private ItemAttributeRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	public List<ItemAttributeDTO> getItemAttributes(int itemId){
		return repository.findAllByItemId(itemId).stream().map(p-> mapper.map(p, ItemAttributeDTO.class)).collect(Collectors.toList());
	}
	
	public ItemAttributeDTO addItemAttribute(ItemAttributeRequest request) {
		ItemAttribute attribute=mapper.map(request, ItemAttribute.class);
		return mapper.map(repository.save(attribute), ItemAttributeDTO.class);
	}
}
