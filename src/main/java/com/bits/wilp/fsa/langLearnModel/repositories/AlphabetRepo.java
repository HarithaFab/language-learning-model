package com.bits.wilp.fsa.langLearnModel.repositories;

import com.bits.wilp.fsa.langLearnModel.models.Alphabet;
import org.springframework.data.repository.CrudRepository;

public interface AlphabetRepo extends CrudRepository<Alphabet, Long> {
    Alphabet findAlphabetByLanguageAndActualLetter(String language, String letter);
}
