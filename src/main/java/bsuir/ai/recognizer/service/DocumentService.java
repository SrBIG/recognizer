package bsuir.ai.recognizer.service;

import bsuir.ai.recognizer.model.Document;
import bsuir.ai.recognizer.model.RecognizeResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    void save(Document document);

    void delete(Document document);

    void add(MultipartFile file, String language);

    List<Document> findAll();

    void saveAll(List<Document> documents);

    RecognizeResult recognize(MultipartFile file);
}

