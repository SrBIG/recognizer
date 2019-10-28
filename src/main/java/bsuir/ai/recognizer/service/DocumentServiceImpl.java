package bsuir.ai.recognizer.service;

import bsuir.ai.recognizer.model.Document;
import bsuir.ai.recognizer.model.Language;
import bsuir.ai.recognizer.model.RecognizeResult;
import bsuir.ai.recognizer.repository.DocumentRepository;
import bsuir.ai.recognizer.util.RecognizeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("documentService")
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
    public void add(String file, String lang) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return;
        }
        try {
            Language language = Language.parse(lang);
            Map<String, Integer> image = RecognizeUtils.makeImage(file);
            Document document = createDocument(file, language, image);
            documentRepository.save(document);
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

    @Override
    public List<RecognizeResult> recognize(String file) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return null;
        }
        List<Document> docs = documentRepository.findAll();
        return RecognizeUtils.recognize(file, docs);
    }

    private Document createDocument(String text, Language language, Map<String, Integer> image) {
        return Document.builder()
                .language(language)
                .text(text)
                .gramWeight(image)
                .build();
    }
}
