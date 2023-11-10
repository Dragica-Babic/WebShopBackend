package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}
