package bsuir.ai.recognizer.parser;

import org.apache.logging.log4j.util.Strings;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class HTMLParser {

    public String parse(MultipartFile file) {
        try {
            return Jsoup.parse(new String(file.getBytes()).toLowerCase()).text();
        } catch (IOException e) {
            e.printStackTrace();
            return Strings.EMPTY;
        }
    }
}
