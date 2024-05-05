package com.bits.wilp.fsa.langLearnModel.repositories;

import com.bits.wilp.fsa.langLearnModel.models.ReadingLesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadingLessonRepo extends CrudRepository<ReadingLesson, Long> {

    List<ReadingLesson> findByLanguageAndLessonId(String language, Long lessonId);
    ReadingLesson findByLanguageAndActualWord(String language, String actualWord);

}