package etf.webshop.services;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.model.dto.PinDTO;
import etf.webshop.model.entities.Pin;
import etf.webshop.model.requests.PinRequest;
import etf.webshop.repositories.PinRepository;

@Service
public class PinService {
	
	@Autowired
	private PinRepository pinRepository;
	@Autowired
	private ModelMapper mapper;
	
	public PinDTO getByUserId(int id) {
		return mapper.map(pinRepository.findByUserId(id), PinDTO.class);
	}
	
	public PinDTO insertPin(int userId) {
		Random random = new Random();
		String pinString=String.format("%04d", random.nextInt(10000));
		PinRequest request=new PinRequest();
		request.setValue(pinString);
		request.setUserId(userId);
		Pin pin=mapper.map(request, Pin.class);
		return mapper.map(pinRepository.save(pin), PinDTO.class);
	}
	
	public PinDTO updatePin(int userId) {
		PinDTO pinDTO=getByUserId(userId);
		Random random = new Random();
		String pinString=String.format("%04d", random.nextInt(10000));
		pinDTO.setValue(pinString);
		Pin pin=mapper.map(pinDTO, Pin.class);
		return mapper.map(pinRepository.save(pin), PinDTO.class);
	}
}
