package pro.sky.basiccoursework2.service;

import pro.sky.basiccoursework2.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

//    Question add(Question question);

    Question remove(String question, String answer);

    Collection <Question> getAll();

    Question getRandomQuestion();
}
