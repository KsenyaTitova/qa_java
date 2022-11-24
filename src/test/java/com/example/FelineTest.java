package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatReturnListOfStringsForThePredator() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals("Строки не совпадают", expectedResult, actualResult);
    }

    @Test
    public void getFamilyReturnTheFelineFamily() {
        String actualResult = feline.getFamily();
        assertEquals("Результат не совпал", "Кошачьи", actualResult);
    }

    @Test
    public void getKittensWithoutParametersReturnKittensCount1() {
        int actualResult = feline.getKittens();
        assertEquals("Результат не совпал", 1, actualResult);
    }

    @Test
    public void getKittensFiveKittensReturnCountFiveKittens() {
        int actualResult = feline.getKittens(5);
        assertEquals("Результат не совпал", 5, actualResult);
    }
}