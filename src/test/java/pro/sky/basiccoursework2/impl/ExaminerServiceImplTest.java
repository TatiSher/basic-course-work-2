package pro.sky.basiccoursework2.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.exceptions.BadRequestException;
import pro.sky.basiccoursework2.service.QuestionService;
import pro.sky.basiccoursework2.impl.ExaminerServiceImpl;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pro.sky.basiccoursework2.impl.QuestionServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void settings() {
        when(questionServiceMock.getAll()).thenReturn(List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3)));
    }

    @Test
    public void testGetQuestions() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2));
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(0,1);
        out.setRandom(randomMock);

        Collection<Question> actual = out.getQuestions(5);
        List<Question> expected = List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2),
                new Question(QUESTION_3, ANSWER_3),
                new Question(QUESTION_4, ANSWER_4),
                new Question(QUESTION_5, ANSWER_5));

        Assertions.assertIterableEquals(expected,actual);
    }
}