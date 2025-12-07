package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedResult;

    public FelineParameterizedTest(int kittensCount, int expectedResult) {
        this.kittensCount = kittensCount;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0}, {1, 1}, {5, 5}, {10, 10}
        });
    }

    @Test
    public void testGetKittensWithDifferentCounts() {
        Feline feline = new Feline();
        assertEquals("getKittens с аргументом " + kittensCount + " должен возвращать " + expectedResult,
                expectedResult, feline.getKittens(kittensCount));
    }
}