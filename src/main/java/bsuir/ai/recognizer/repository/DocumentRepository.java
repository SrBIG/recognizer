package bsuir.ai.recognizer.repository;

import bsuir.ai.recognizer.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("documentRepository")
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
