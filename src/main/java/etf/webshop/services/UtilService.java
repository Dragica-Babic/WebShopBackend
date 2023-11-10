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
import etf.webshop.model.enums.ImageType;

@Service
public class UtilService {
	
	@Value("${images-folder}")
	private String imagesFolder;
	@Value("${user-images}")
	private String userImages;
	@Value("${item-images}")
	private String itemImages;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	
	public boolean uploadImage(MultipartFile file, Integer id, ImageType type) throws ResourceNotFoundException{
		boolean uploaded=false;
		
		String fileName=id + "." + file.getOriginalFilename().split("\\.")[1];
		String imageType=type.equals(ImageType.USER)?userImages:itemImages;
		try {
			if(Files.exists(Paths.get(imagesFolder+imageType+File.separator+fileName))) 
				Files.delete(Paths.get(imagesFolder+imageType+File.separator+fileName));
			
			Files.copy(file.getInputStream(), Paths.get(imagesFolder+imageType).resolve(fileName));
			uploaded=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(uploaded) {
			if(type.equals(ImageType.USER))
				userService.setAvatar(id, imageType+File.separator+fileName);
			else
				itemService.setImage(id, imageType+File.separator+fileName);
		}
		
		return uploaded;
	}
}
