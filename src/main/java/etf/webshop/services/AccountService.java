package etf.webshop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import etf.webshop.exceptions.ResourceNotFoundException;
import etf.webshop.model.dto.AccountDTO;
import etf.webshop.model.entities.Account;
import etf.webshop.model.requests.AccountRequest;
import etf.webshop.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public AccountDTO addAccount(AccountRequest request) {
		Account account=modelMapper.map(request, Account.class);
		return modelMapper.map(accountRepository.save(account), AccountDTO.class);
	}
	
	public AccountDTO updateAccount(AccountRequest request) {
		Account account=modelMapper.map(request, Account.class);
		return modelMapper.map(accountRepository.save(account), AccountDTO.class);
	}
	
	public AccountDTO getById(int id) {
		Account account=accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Korisnik nije pronađen!"));
		return modelMapper.map(account, AccountDTO.class);
	}
}
