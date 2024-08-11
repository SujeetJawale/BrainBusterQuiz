package com.sujeet.brainbuster.service;

import com.sujeet.brainbuster.dao.IQuestionRepo;
import com.sujeet.brainbuster.dao.IQuizRepo;
import com.sujeet.brainbuster.model.Question;
import com.sujeet.brainbuster.model.QuestionWrapper;
import com.sujeet.brainbuster.model.Quiz;
import com.sujeet.brainbuster.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements IQuizService {

    @Autowired
    private IQuizRepo quizRepo;

    @Autowired
    private IQuestionRepo questionRepo;

    @Override
    public String createQuiz(String category, Integer numQ, String quizTitle) {
        Quiz q = new Quiz();
        q.setTitle(quizTitle);
        q.setQuestions(questionRepo.findRandomQuestionsByCategory(category,numQ));
        quizRepo.save(q);
        return "Successfully created Quiz";
    }

    @Override
    public List<QuestionWrapper> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question question : questions) {
            QuestionWrapper questionWrapper = new QuestionWrapper(
                    question.getId(), question.getQuestion(),
                    question.getOption1(), question.getOption2(),
                    question.getOption3(), question.getOption4());
            questionForUser.add(questionWrapper);
        }
        return questionForUser;
    }

    @Override
    public String calculateResult(Integer id, List<Response> resp) {
        Quiz q = quizRepo.findById(id).get();
        List<Question> questions = q.getQuestions();
        int right = 0;
        int increment = 0;
        for (Response response : resp) {
            if(response.getResponse().equals(questions.get(increment).getRightAnswer()))
                right++;

            increment++;
        }
        return "Correct Answers: " + right;
    }
}
