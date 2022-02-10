package pro.sky.basiccoursework2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path="/random-questions", params = {"amount"})
    Collection<Question> getQuestions(@RequestParam int amount) {
        return (examinerService.getQuestions(amount));
    }

}
