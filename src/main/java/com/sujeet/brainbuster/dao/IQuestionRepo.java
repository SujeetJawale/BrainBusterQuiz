package com.sujeet.brainbuster.dao;

import com.sujeet.brainbuster.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Integer> {
    public List<Question> findByCategory(String category);
}
