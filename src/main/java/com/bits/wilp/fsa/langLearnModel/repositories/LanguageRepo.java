package com.bits.wilp.fsa.langLearnModel.repositories;

import com.bits.wilp.fsa.langLearnModel.models.Alphabet;
import com.bits.wilp.fsa.langLearnModel.models.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepo extends CrudRepository<Language, Long> {
    List<Language> findAll();
}
