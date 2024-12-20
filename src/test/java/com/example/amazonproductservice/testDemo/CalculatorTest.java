package com.example.amazonproductservice.testDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    final Calculator calculator=new Calculator();
    @Test
    void WhenAddTwoIntegersReturnResultExpected() {
        //Arrange
        int a=10;
        int b=40;

        //Act

        int result=calculator.add(a,b);

        //Assert
        Assertions.assertEquals(50,result);
    }

    @Test
    void WhenDivideByZeroThrowArithmeticException() {
        int a=10;
        int b=0;
        Assertions.assertThrows(ArithmeticException.class,()->calculator.divide(a,b));
    }

    @Test
    void WhenDivideIntegerReturnExpectedResult() {
        int a=10,b=5;
        int result=calculator.divide(10,5);
        Assertions.assertEquals(2,result);
    }
}