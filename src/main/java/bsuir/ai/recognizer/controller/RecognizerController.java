package bsuir.ai.recognizer.controller;

import bsuir.ai.recognizer.model.RecognizeResult;
import bsuir.ai.recognizer.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RecognizerController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/recognize")
    public ResponseEntity<RecognizeResult> recognize(@RequestParam("documents") MultipartFile file) {
        RecognizeResult recognizeResult = documentService.recognize(file);
        return new ResponseEntity<>(recognizeResult, HttpStatus.OK);
    }
}
