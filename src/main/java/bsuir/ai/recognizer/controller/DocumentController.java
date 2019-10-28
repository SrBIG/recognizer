package bsuir.ai.recognizer.controller;

import bsuir.ai.recognizer.parser.HTMLParser;
import bsuir.ai.recognizer.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private HTMLParser parser;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadDocument(@RequestParam("document") MultipartFile file,
                                         @RequestParam("language") String lang) {
        documentService.add(parser.parse(file), lang);
        return new ResponseEntity(HttpStatus.OK);
    }
}
