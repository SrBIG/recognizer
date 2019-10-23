package bsuir.ai.recognizer.service;

import bsuir.ai.recognizer.model.Document;
import bsuir.ai.recognizer.model.Language;
import bsuir.ai.recognizer.model.RecognizeResult;
import bsuir.ai.recognizer.repository.DocumentRepository;
import bsuir.ai.recognizer.util.RecognizeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public void add(MultipartFile file, String lang) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return;
        }
        try {
            String text = new String(file.getBytes());
            Language language = Language.parse(lang);
            Map<String, Integer> image = RecognizeUtils.makeImage(text);
            Document document = createDocument(text, language, image);
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
    public List<RecognizeResult> recognize(MultipartFile file) {
        // TODO : add normal file handling
        if (Objects.isNull(file) || file.isEmpty()) {
            return null;
        }
        try {
            String text = new String(file.getBytes());
            List<Document> docs = documentRepository.findAll();
            return RecognizeUtils.recognize(text, docs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Document createDocument(String text, Language language, Map<String, Integer> image) {
        return Document.builder()
                .language(language)
                .text(text)
                .gramWeight(image)
                .build();
    }
}
