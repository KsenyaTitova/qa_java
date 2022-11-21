package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat;

    @Mock
    Feline feline;

    @Test
    public void getSound() {
        cat = new Cat(feline);
        String actualResult = cat.getSound();
        assertEquals("Результат не совпал с ожидаемым значением", "Мяу", actualResult);
    }

    @Test
    public void getFoodReturnException() throws Exception {
        cat = new Cat(feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedResult);
        List<String> actualResult = cat.getFood();
        assertEquals("Строки не совпадают", expectedResult, actualResult);
    }
}