package etf.webshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.CategoryDTO;
import etf.webshop.model.entities.Category;
import etf.webshop.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CategoryDTO> findAll(){
		return categoryRepository.findAll().stream().map(p->modelMapper.map(p, CategoryDTO.class)).collect(Collectors.toList());
	}
	
	public CategoryDTO getCategoryById(int id) throws ResourceNotFoundException {
		return modelMapper.map(getById(id), CategoryDTO.class);
	}
	
	public CategoryDTO getById(int id) throws ResourceNotFoundException {
		Category cat= categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kategorija nije pronađena!"));
		return modelMapper.map(cat, CategoryDTO.class);
	}
}
