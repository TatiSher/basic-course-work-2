package pro.sky.basiccoursework2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.impl.JavaQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionServiceImpl questionService;

    public JavaQuestionController(JavaQuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
        return question + " " +
                " - " + answer + " have been added.";
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam String question, @RequestParam String answer) {
        questionService.remove(question, answer);
        return question + " " +
                " - " + answer + " have been deleted.";
    }

    @GetMapping(path = "/questions")
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }
}
