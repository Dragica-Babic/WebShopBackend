package etf.webshop.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import etf.webshop.exceptions.ResourceNotFoundException;

@Service
public class UtilService {
	
	@Value("${images-folder}")
	private String imagesFolder;

	@Autowired
	private ItemService itemService;
	
	public boolean uploadImage(MultipartFile file, Integer id) throws ResourceNotFoundException{
		boolean uploaded=false;
		String fileName=id + ".jpg";
		try {
			if(Files.exists(Paths.get(imagesFolder+File.separator+fileName)))
				Files.delete(Paths.get(imagesFolder+File.separator+fileName));
			
			Files.copy(file.getInputStream(), Paths.get(imagesFolder).resolve(fileName));
			uploaded=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(uploaded) {
			itemService.setImage(id, fileName);
		}
		
		return uploaded;
	}
}
