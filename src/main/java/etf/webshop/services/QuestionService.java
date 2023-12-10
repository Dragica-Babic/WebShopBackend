package etf.webshop.services;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.QuestionDTO;
import etf.webshop.model.entities.Question;
import etf.webshop.model.requests.QuestionRequest;
import etf.webshop.repositories.QuestionRepository;

@AllArgsConstructor
@Service
public class QuestionService {
	private QuestionRepository questionRepository;
	private ModelMapper modelMapper;
	
	public List<QuestionDTO> getAllByItemId(int id){
		return questionRepository.findAllByItemId(id).stream().map(p->modelMapper.map(p, QuestionDTO.class)).collect(Collectors.toList());
	}

	public QuestionDTO insert(QuestionRequest request) {
		Question question=modelMapper.map(request, Question.class);
		question=questionRepository.save(question);
		return modelMapper.map(question, QuestionDTO.class);
	}
	
	public Question getById(int id) {
        return questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Pitanje nije pronadjeno"));
	}
	
	public QuestionDTO addAnswer(int id, QuestionRequest request) throws ResourceNotFoundException {
		Question question=modelMapper.map(request, Question.class);
		question.setId(id);
		Question qdto=getById(id);
		question.setUser(qdto.getUser());
		question=questionRepository.save(question);
		return modelMapper.map(question, QuestionDTO.class);
	}
}
