package etf.webshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.QuestionDTO;
import etf.webshop.model.entities.Question;
import etf.webshop.model.requests.QuestionRequest;
import etf.webshop.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
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
		Question question=questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Pitanje nije pronadjeno"));
		return question;
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
