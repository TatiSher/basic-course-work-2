package pro.sky.basiccoursework2.impl;

import org.springframework.stereotype.Service;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.exceptions.BadRequestException;
import pro.sky.basiccoursework2.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions;
    private Random random;

    public JavaQuestionServiceImpl() {
        questions = new HashSet<>();
        this.random = new Random();
    }
    
    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (!questions.add(question1)) {
            throw new BadRequestException();
        }
        return question1;
    }

//    @Override
//    public Question add(Question question) {
//        Question question1 = new Question(question);
//        if (!questions.add(question1)) {
//            throw new BadRequestException();
//        }
//        return question;
//    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (!questions.remove(question1)) {
            throw new BadRequestException();
        }
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = List.copyOf(getAll());
        return questions.get(random.nextInt(questions.size()));
    }
}
