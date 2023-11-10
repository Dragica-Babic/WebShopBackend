package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
