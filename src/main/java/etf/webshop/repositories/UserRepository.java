package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import etf.webshop.model.entities.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	boolean existsByAccountUsernameAndAccountPassword(String username, String password);
	
	User findByAccountUsername(String username);
	
	boolean existsByAccountUsername(String username);
	
	@Modifying
	@Query("update User u set u.isActivated=true where u.id=:id")
	void activateUser(int id);
}
