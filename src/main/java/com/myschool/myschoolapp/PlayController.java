package com.myschool.myschoolapp;

import com.myschool.model.PlayRequest;
import com.myschool.model.PlayResponse;
import com.myschool.model.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class PlayController {

    List<String> words;

    private static final Logger log = LoggerFactory.getLogger(PlayController.class);

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;

    }

    private Word getNextWord() {
        if (null == words) {
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("good-words.txt");
            try (
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(in))
            ) {
                words = br.lines().map(String::toLowerCase).map(String::trim).collect(Collectors.toList());
            } catch (IOException E) {
                log.error("Error in reading words", E);
            }
        }

        int index = getRandomNumber(0, words.size()-1);
        Word word = new Word();
        word.setWord(words.get(index));
        word.setId(index);
        word.setUrl("https://ssl.gstatic.com/dictionary/static/sounds/oxford/"+words.get(index)+"--_us_1.mp3");
        return word;
    }

    @CrossOrigin
    @PostMapping("/play")
    public PlayResponse play(@RequestBody PlayRequest playRequest) {
        PlayResponse playResponse = new PlayResponse();
        if(null != playRequest.getCurrentWord()){
            Word currentWord = playRequest.getCurrentWord();
            if(currentWord.getWord().equals(currentWord.getSpelling())){
                playResponse.setCurrentScore(playRequest.getCurrentScore() + 1);
                playResponse.setResult(true);
            }else{
                playResponse.setCurrentScore(playRequest.getCurrentScore());
            }
            playResponse.setTotal(playRequest.getTotal()+1);
        }
        Word word = getNextWord();
        playResponse.setNextWord(word);
        return playResponse;
    }
}
