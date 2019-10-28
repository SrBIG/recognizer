package bsuir.ai.recognizer.service;

import bsuir.ai.recognizer.model.Document;
import bsuir.ai.recognizer.model.RecognizeResult;

import java.util.List;

public interface DocumentService {
    void save(Document document);

    void delete(Document document);

    void add(String file, String language);

    List<Document> findAll();

    void saveAll(List<Document> documents);

    List<RecognizeResult> recognize(String file);
}

