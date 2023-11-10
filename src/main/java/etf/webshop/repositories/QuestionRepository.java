package etf.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findAllByItemId(int id);
}
