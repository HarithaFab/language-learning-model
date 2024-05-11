package com.bits.wilp.fsa.langLearnModel.controllers;
import com.bits.wilp.fsa.langLearnModel.models.Alphabet;
import com.bits.wilp.fsa.langLearnModel.models.Language;
import com.bits.wilp.fsa.langLearnModel.models.ReadingLesson;
import com.bits.wilp.fsa.langLearnModel.repositories.AlphabetRepo;
import com.bits.wilp.fsa.langLearnModel.repositories.LanguageRepo;
import com.bits.wilp.fsa.langLearnModel.repositories.ReadingLessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {

    @Autowired
    private ReadingLessonRepo repo;
    @Autowired
    private AlphabetRepo alphaRepo;
    @Autowired
    private LanguageRepo languageRepo;

    @GetMapping("/translate/{language}/word/{word}")
    public String translateHello(@PathVariable String language, @PathVariable String word) {
        return repo.findByLanguageAndActualWord(language, word).getTranslatedWord();
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) {
        byte[] image = new byte[0];
        String context = "E://personal/BITS-WILP/Sem2/Full Stack/assignment/language-learning-model/src/main/java/com/bits/wilp/fsa/langLearnModel/";
        try {
            image = FileUtils.readFileToByteArray(new File(context+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @GetMapping("/{language}/readingLesson/{id}")
    public HashMap<String,String> readingLesson(@PathVariable String language, @PathVariable Long id) {
        List<ReadingLesson> lessonContent = repo.findByLanguageAndLessonId(language, id);
        HashMap<String, String> result = new HashMap<>();
        for(ReadingLesson lesson : lessonContent) {
            result.put(lesson.getActualWord(),lesson.getTranslatedWord());
        }
        return result;
    }
    
    @GetMapping("/languages")
    public List<Language> availableLanguages() {
        return languageRepo.findAll();
    }

    @GetMapping("/translate/{language}/alphabets")
    public List<Alphabet> getAlphabet(@PathVariable String language) {
        return alphaRepo.findAlphabetByLanguage(language);
    }
}