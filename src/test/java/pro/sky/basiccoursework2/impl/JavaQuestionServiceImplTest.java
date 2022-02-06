package pro.sky.basiccoursework2.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.exceptions.BadRequestException;
import pro.sky.basiccoursework2.service.QuestionService;

import java.util.Collection;
import java.util.List;

import static pro.sky.basiccoursework2.impl.QuestionServiceTestConstants.*;


class JavaQuestionServiceImplTest {
    private QuestionService out = new JavaQuestionServiceImpl();

    @Test
    public void testAddQuestionAnswer() {
        Question question1 = out.add(QUESTION_1, ANSWER_1);
        Question expected = new Question(QUESTION_1, ANSWER_1);
        Assertions.assertEquals(expected, question1);
    }

    @Test
    public void testAddQuestionAnswerExceptionCheck() {
        out.add(QUESTION_1, ANSWER_1);
        Assertions.assertThrowsExactly(BadRequestException.class,
                () -> out.add(QUESTION_1, ANSWER_1));
    }

    @Test
    public void testRemoveQuestionAnswer() {
        out.add(QUESTION_2, ANSWER_2);
        Question question1 = out.remove(QUESTION_2, ANSWER_2);
        Question expected = new Question(QUESTION_2, ANSWER_2);
        Assertions.assertEquals(expected, question1);
    }

    @Test
    public void testRemoveQuestionAnswerExceptionCheck() {
        Assertions.assertThrowsExactly(BadRequestException.class,
                () -> out.remove(QUESTION_1, ANSWER_1));
    }

    @Test
    public void testGetAll() {
        out.add(QUESTION_1, ANSWER_1);
        out.add(QUESTION_2, ANSWER_2);
        Collection<Question> question = out.getAll();
        List<Question> expected = List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2));
        Assertions.assertTrue(expected.containsAll(question));
    }

    @Test
    public void testGetRandomQuestion() {
        out.add(QUESTION_1, ANSWER_1);
        out.add(QUESTION_2, ANSWER_2);
        List<Question> expected = List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2));
        Assertions.assertEquals(expected, out.getRandomQuestion());
    }
}