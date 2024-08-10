package com.sujeet.brainbuster.dao;

import com.sujeet.brainbuster.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepo extends JpaRepository<Quiz, Integer> {

}
