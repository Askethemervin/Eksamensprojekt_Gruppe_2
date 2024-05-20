package com.example.eksamenprojekt_gruppe_2.Test;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.eksamenprojekt_gruppe_2.Repository.UserRepository;
import com.example.eksamenprojekt_gruppe_2.Repository.DatabaseManager;
import com.example.eksamenprojekt_gruppe_2.Repository.UserRepository;
import com.example.eksamenprojekt_gruppe_2.Model.User;
import com.example.eksamenprojekt_gruppe_2.Test.SimpleCalculator;
import com.example.eksamenprojekt_gruppe_2.Controller.HomeController;





class SimpleCalculatorTest {

    @Test
    public void twoPlusTwoShouldEqualFour() {
        var calculator = new SimpleCalculator();
        assertEquals(calculator.add(2, 2));
    }
}
