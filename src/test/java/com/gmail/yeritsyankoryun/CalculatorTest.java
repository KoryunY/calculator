package com.gmail.yeritsyankoryun;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculatorTest {
    Calculator calculator = null;
    CalcService calcService = Mockito.mock(CalcService.class);

    @BeforeEach
    public void setup() {
        calculator = new Calculator(calcService);
    }


    @Test
    void doStaff() {
        when(calcService.multiply(3, 2)).thenReturn(6);
        when(calcService.add(6, 6)).thenReturn(12);
        assertEquals(12, calculator.doStaff(3, 2));
    }

    @Test
    void division() {
        assertThrows(ArithmeticException.class, () -> calculator.division(5, 0));
    }

    @DisplayName("Enhanced add test")
    @Test
    void myAdd() {
        assertEquals(4, calculator.myAdd(2, 2));
        assertThrows(RuntimeException.class, () -> calculator.myAdd(4, Integer.MAX_VALUE-2));
    }

    @DisplayName("Sum of Many")
    @Test
    void sumAll() {
        assertEquals(6,calculator.sumAll(1,2,3,0));
    }

    @DisplayName("Sqaure Test")
    @ParameterizedTest
    @CsvFileSource(files = "src\\test\\resources\\numbers.csv")
    void square(int a) {
        assertEquals(a*a,calculator.square(a));
    }
}