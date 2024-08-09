package com.sujeet.brainbuster.service;

import com.sujeet.brainbuster.dao.IQuestionRepo;
import com.sujeet.brainbuster.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService{

    @Autowired
    private IQuestionRepo repo;

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    @Override
    public String addQuestion(Question question) {
        repo.save(question);
        return "Question added successfully";
    }

    @Override
    public String addAllQuestion(Iterable<Question> questions) {
        repo.saveAll(questions);
        return "All Questions added successfully";
    }

    @Override
    public List<Question> fetchQuestionsByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public String deleteQuestionById(int id) {
        Optional<Question> optional = repo.findById(id);
        optional.ifPresent(question -> repo.delete(question));
        return "Question deleted successfully with id: " + id;
    }

    @Override
    public String updateTheQuestion(Integer id, Question question) {
        Question dbQuestion = repo.findById(id).orElseThrow(() -> new RuntimeException("Question not Found"));
        dbQuestion.setQuestion(question.getQuestion());
        dbQuestion.setDifficulty(question.getDifficulty());
        dbQuestion.setOption1(question.getOption1());
        dbQuestion.setOption2(question.getOption2());
        dbQuestion.setOption3(question.getOption3());
        dbQuestion.setOption4(question.getOption4());
        dbQuestion.setCategory(question.getCategory());
        dbQuestion.setRightAnswer(question.getRightAnswer());
        repo.save(dbQuestion);
        return "Question updated successfully with id: " + id;
    }

    @Override
    public String updateAnsById(Integer id, String answer) {
        Question dbQuestion = repo.findById(id).orElseThrow(() -> new RuntimeException("Question not Found"));
        dbQuestion.setRightAnswer(answer);
        repo.save(dbQuestion);
        return "Answer for question updated successfully with id: " + id;
    }


}

