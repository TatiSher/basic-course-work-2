package pro.sky.basiccoursework2.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.Test;
import pro.sky.basiccoursework2.data.Question;
import pro.sky.basiccoursework2.service.QuestionService;

import java.util.List;
import java.util.Random;

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
                new Question(QUESTION_2, ANSWER_2)));
    }

    @Test
    public void testGetQuestions() {
        when(questionServiceMock.getAll()).thenReturn(List.of(
                new Question(QUESTION_1, ANSWER_1),
                new Question(QUESTION_2, ANSWER_2)));
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(0,2);
        out.setRandom(randomMock);

        Assertions.assertEquals(new Question(QUESTION_1, ANSWER_1),out.getRandomQuestion());
        Assertions.assertEquals(new Question(QUESTION_2, ANSWER_2),out.getRandomQuestion());
    }
}