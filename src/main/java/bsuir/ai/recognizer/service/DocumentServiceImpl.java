package bsuir.ai.recognizer.service;

import bsuir.ai.recognizer.model.Document;
import bsuir.ai.recognizer.model.Language;
import bsuir.ai.recognizer.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void delete(Document document) {
        documentRepository.delete(document);
    }

    @Override
    public void add(MultipartFile file, String lang) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return;
        }
        try {
            String text = new String(file.getBytes());
            Language language = Language.parse(lang);
            Document document = createDocument(text, language);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public void saveAll(List<Document> documents) {
        documentRepository.saveAll(documents);
    }

    private Document createDocument(String text, Language language) {
        return Document.builder()
                .language(language)
                .text(text)
                .build();
    }
}
