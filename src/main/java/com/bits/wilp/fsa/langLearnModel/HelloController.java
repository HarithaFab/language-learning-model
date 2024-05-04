package com.bits.wilp.fsa.langLearnModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.HashMap;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {
	@Autowired
	private LanguageService languageService;

    @GetMapping("/translate/spanish/{word}")
    public String translateHello(@PathVariable String word) {
     return languageService.getTranslation(word);
        
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

    @GetMapping("/spanish/readingLesson/{id}")
    public HashMap<String,String> readingLesson(@PathVariable int id) {
    	return languageService.readingLesson(id);
        
    }
}