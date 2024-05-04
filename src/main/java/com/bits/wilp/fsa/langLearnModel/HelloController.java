package com.bits.wilp.fsa.langLearnModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.HashMap;
import com.google.gson.Gson;

@RestController
public class HelloController {

    @GetMapping("/translate/spanish/{word}")
    public String translateHello(@PathVariable String word) {
        HashMap<String,String> translator = new HashMap<String,String>();
        translator.put("hello","Hola");
        translator.put("how","cómo");
        translator.put("morning","mañana");
        return translator.get(word);
    }

    @GetMapping("/spanish/readingLesson/{id}")
    public HashMap<String,String> readingLesson(@PathVariable int id) {
        HashMap<Integer, HashMap<String,String>> lessons = new HashMap<>();
        HashMap<String,String> translator = new HashMap<>();
        translator.put("hello","Hola");
        translator.put("how","cómo");
        translator.put("morning","mañana");
        lessons.put(1,translator);
        
        translator = new HashMap<>();
        translator.put("apple","manzana");
        translator.put("orange","naranja");
        translator.put("muskmelon","melón");
        lessons.put(2,translator);

        translator = new HashMap<>();
        translator.put("red","roja");
        translator.put("yellow","amarilla");
        translator.put("green","verde");
        lessons.put(3,translator);
        return lessons.get(id);
    }
}