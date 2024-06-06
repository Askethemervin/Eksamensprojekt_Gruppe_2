package com.example.eksamenprojekt_gruppe_2.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    public void twoPlusTwoShouldEqualFour() {
        var calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void oneMinusTwoShouldEqualMinusThree() {
        var calculator = new SimpleCalculator();
        assertEquals(-3, calculator.add(-1, -2));
    }
}











