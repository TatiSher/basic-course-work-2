package pro.sky.basiccoursework2.impl;

import org.springframework.stereotype.Service;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.exceptions.BadRequestException;
import pro.sky.basiccoursework2.service.ExaminerService;
import pro.sky.basiccoursework2.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private Random random;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.random = new Random();
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getSize();
        if (amount <=0 || size < amount) {
            throw new BadRequestException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size()< amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }

}
