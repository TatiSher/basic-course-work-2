package pro.sky.basiccoursework2.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.exceptions.BadRequestException;
import pro.sky.basiccoursework2.service.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.*;

import static pro.sky.basiccoursework2.impl.QuestionServiceTestConstants.*;
import static org.mockito.Mockito.mock;

class JavaQuestionServiceImplTest {

    private QuestionService out = new JavaQuestionServiceImpl();

    @Test
    public void testAddQuestionAnswer() {
        Question question1 = out.add(QUESTION_1, ANSWER_1);
        Question expected = new Question(QUESTION_1, ANSWER_1);
        assertEquals(expected, question1);
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
        assertEquals(expected, question1);
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
        when(out.getAll()).thenReturn(List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3)));

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(0, 3);
        out.setRandom(random);

        Assertions.assertEquals(new Question(QUESTION_1, ANSWER_1), out.getRandomQuestion());
        Assertions.assertEquals(new Question(QUESTION_3, ANSWER_3), out.getRandomQuestion());
    }
}