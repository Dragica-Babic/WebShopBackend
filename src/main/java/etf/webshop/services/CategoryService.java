package etf.webshop.services;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.CategoryDTO;
import etf.webshop.model.entities.Category;
import etf.webshop.repositories.CategoryRepository;

@AllArgsConstructor
@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
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
