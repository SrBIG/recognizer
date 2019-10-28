package bsuir.ai.recognizer.controller;

import bsuir.ai.recognizer.model.RecognizeResult;
import bsuir.ai.recognizer.parser.HTMLParser;
import bsuir.ai.recognizer.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class RecognizerController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private HTMLParser parser;

    @PostMapping(value = "/recognize", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity recognize(@RequestParam("recognitionDoc") MultipartFile file) {
        List<RecognizeResult> recognizeResults = documentService.recognize(parser.parse(file));
        return new ResponseEntity<>(recognizeResults, HttpStatus.OK);
    }
}
