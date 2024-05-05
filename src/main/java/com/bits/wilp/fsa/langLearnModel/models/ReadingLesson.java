package com.bits.wilp.fsa.langLearnModel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "READINGLESSON")
public class ReadingLesson {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String language;
    private Long lessonId;
    private String actualWord;
    private String translatedWord;

    public ReadingLesson(Long id, String language, Long lessonId, String actualWord, String translatedWord) {
        this.id = id;
        this.language = language;
        this.lessonId = lessonId;
        this.actualWord = actualWord;
        this.translatedWord = translatedWord;
    }

    public ReadingLesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getActualWord() {
        return actualWord;
    }

    public void setActualWord(String actualWord) {
        this.actualWord = actualWord;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}
