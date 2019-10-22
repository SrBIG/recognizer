package bsuir.ai.recognizer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {

    @GetMapping("/")
    public ModelAndView recognizerMainPage() {
        return new ModelAndView("recognizer");
    }

}
