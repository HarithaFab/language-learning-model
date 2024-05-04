package com.bits.wilp.fsa.langLearnModel;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service

public class LanguageService {
	
	public String getTranslation(String word) {
	HashMap<String,String> translator = new HashMap<String,String>();
    translator.put("hello","Hola");
    translator.put("how","cómo");
    translator.put("morning","mañana");
    return translator.get(word);
	}
    
	public HashMap<String,String> readingLesson(int id) {
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
