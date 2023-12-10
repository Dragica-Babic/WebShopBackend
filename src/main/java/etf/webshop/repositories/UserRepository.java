package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import etf.webshop.model.entities.UserEntity;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByUsername(String username);
	
	boolean existsByUsername(String username);
}
