package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasMane;

    @Mock
    Feline feline;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    // Тестовые данные
    @Parameterized.Parameters(name = "{index} - sex: {0}, expectedResult: {1}")
    public static Object[][] getDataForTheMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensReturn1Kitten() throws Exception {
            Lion lion = new Lion(sex, feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            int actualResult = lion.getKittens();
            assertEquals("Результат не совпал", 1, actualResult);
        }

    @Test
    public void doesHaveMane() throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals("Результат отличается от ожидаемого", hasMane, lion.doesHaveMane());
    }

    @Test
    public void unknownSexReturnException() {
        Exception thrown = assertThrows(
                Exception.class, () ->new Lion("Неизвестно", feline));
        assertEquals("Результат отличается от ожидаемого", "Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }

    @Test
    public void getFood() throws Exception {
            Lion lion = new Lion(sex, feline);
            List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
            List<String> actualResult = lion.getFood();
            assertEquals("Результат не совпал", expectedResult, actualResult);
    }

}