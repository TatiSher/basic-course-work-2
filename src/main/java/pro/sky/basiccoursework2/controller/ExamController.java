package pro.sky.basiccoursework2.controller;


import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path="/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return (examinerService.getQuestions(amount));
    }

}
