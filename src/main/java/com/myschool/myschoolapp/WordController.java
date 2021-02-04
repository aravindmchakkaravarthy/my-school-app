package com.myschool.myschoolapp;

import com.myschool.model.Word;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @GetMapping("/word")
    public Word word(){
        Word word = new Word();
        word.setId(1);
        word.setWord("define");
        word.setUrl("https://ssl.gstatic.com/dictionary/static/sounds/oxford/define--_us_1.mp3");
        return word;
    }


}
