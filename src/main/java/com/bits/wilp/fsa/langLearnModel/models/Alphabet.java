package com.bits.wilp.fsa.langLearnModel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alphabet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String language;
    private String actualLetter;
    private String translatedLetter;
    private String pronounciation;

    public Alphabet() {}

    public Alphabet(Long id, String language, String actualLetter, String translatedLetter, String pronounciation) {
        this.id = id;
        this.language = language;
        this.actualLetter = actualLetter;
        this.translatedLetter = translatedLetter;
        this.pronounciation = pronounciation;
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

    public String getActualLetter() {
        return actualLetter;
    }

    public void setActualLetter(String actualLetter) {
        this.actualLetter = actualLetter;
    }

    public String getTranslatedLetter() {
        return translatedLetter;
    }

    public void setTranslatedLetter(String translatedLetter) {
        this.translatedLetter = translatedLetter;
    }

    public String getPronounciation() {
        return pronounciation;
    }

    public void setPronounciation(String pronounciation) {
        this.pronounciation = pronounciation;
    }
}
