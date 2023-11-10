package etf.webshop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.model.dto.MessageDTO;
import etf.webshop.model.entities.Message;
import etf.webshop.model.requests.MessageRequest;
import etf.webshop.repositories.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public MessageDTO insertMessage(MessageRequest request) {
		Message message=modelMapper.map(request, Message.class);
		message=messageRepository.save(message);
		return modelMapper.map(message, MessageDTO.class);
	}

}
