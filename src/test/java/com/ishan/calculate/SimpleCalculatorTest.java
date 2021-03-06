package com.ishan.calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @BeforeEach
    public void initSimpleCalculator(){
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void testEmptyString(){
        int actualResult = simpleCalculator.Add("");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult, "Empty string for Add method will return 0");
    }

    @Test
    public void testStringWithTwoNumbers(){
        int actualResult = simpleCalculator.Add("1,2");
        int expectedResult = 3;
        assertEquals(expectedResult,actualResult, "String 1,2 for Add method will return 3");
    }

    @Test
    public void testStringWithUnknownAmountOfNumbers(){
        int actualResult = simpleCalculator.Add("1,2,3,4,5,6,7,8,9,10");
        int expectedResult = 55;
        assertEquals(expectedResult,actualResult,"String with 1 to 10 will return 55");
    }

    @Test
    public void testStringWithNewLine(){
        int actualResult = simpleCalculator.Add("1\n2,3");
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult,"String with new line will return 6");
    }

    @Test
    public void testStringWithDelimiter(){
        int actualResult = simpleCalculator.Add("//;\n1;2");
        int expectedResult = 3;
        assertEquals(expectedResult,actualResult,"String with delimiter will return 3");
    }

    @Test
    public void testStringWithNegativeNumbers(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->simpleCalculator.Add("-1\n-22,3"));
        assertEquals("negatives not allowed -1,-22",exception.getMessage());
    }

    @Test
    public void testStringNotValid(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->simpleCalculator.Add("1,\n,2"));
        assertEquals("Input is NOT ok",exception.getMessage());
    }
}