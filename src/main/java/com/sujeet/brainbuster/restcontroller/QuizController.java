package com.sujeet.brainbuster.restcontroller;

import com.sujeet.brainbuster.model.Question;
import com.sujeet.brainbuster.model.QuestionWrapper;
import com.sujeet.brainbuster.model.Response;
import com.sujeet.brainbuster.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private IQuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String quizTitle) {
        String msg = quizService.createQuiz(category, numQ, quizTitle);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getAllQuestions(@PathVariable Integer id) {
        List<QuestionWrapper> list = quizService.getQuiz(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> createQuiz(@PathVariable Integer id, @RequestBody List<Response> resp) {
        String msg = quizService.calculateResult(id, resp);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
