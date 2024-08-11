package com.sujeet.brainbuster.service;

import com.sujeet.brainbuster.model.Question;
import com.sujeet.brainbuster.model.QuestionWrapper;
import com.sujeet.brainbuster.model.Response;

import java.util.List;

public interface IQuizService {
    public String createQuiz(String category, Integer numQ, String quizTitle);
    public List<QuestionWrapper> getQuiz(Integer quizTitle);
    public String calculateResult(Integer id, List<Response> resp);
}
