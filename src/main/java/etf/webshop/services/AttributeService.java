package etf.webshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.model.dto.AttributeDTO;

import etf.webshop.repositories.AttributeRepository;

@Service
public class AttributeService {
	
	@Autowired
	private AttributeRepository attributeRepository;
	private final ModelMapper modelMapper=new ModelMapper();
	
	public List<AttributeDTO> getAllByCategoryId(int id){
		return attributeRepository.findByCategoryId(id).stream().map(p -> modelMapper.map(p, AttributeDTO.class)).collect(Collectors.toList());
	}

}
