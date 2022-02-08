package pro.sky.basiccoursework2.service;

import pro.sky.basiccoursework2.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
