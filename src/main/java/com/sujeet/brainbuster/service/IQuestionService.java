package com.sujeet.brainbuster.service;

import com.sujeet.brainbuster.model.Question;

import java.util.List;

public interface IQuestionService {
    public List<Question> getAllQuestions();
    public String addQuestion(Question question);
    public String addAllQuestion(Iterable<Question> questions);
    public List<Question> fetchQuestionsByCategory(String category);
    public String deleteQuestionById(int id);
    public String updateTheQuestion(Integer id, Question question);
    public String updateAnsById(Integer id, String answer);
}
