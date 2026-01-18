package pl.edu.ug.ap.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ap.domain.ChatGPT;

import java.util.List;

@Repository
public interface ChatGPTRepository extends CrudRepository<ChatGPT, Long> {

    @Query("Select q from ChatGPT q join fetch q.person")
    List<ChatGPT> findAll();
}
