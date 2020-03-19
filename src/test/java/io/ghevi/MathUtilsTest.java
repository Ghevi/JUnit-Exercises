package io.ghevi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MathUtilsTest {

    @Test
    void testAdd(){
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);

        /* This is not good because is print all to console and not the red failing test
        if(expected != actual)
            System.out.println("Test failed");
        */

        // So we use assertEquals
        assertEquals(expected, actual, "The add method should add two numbers");

    }

    @Test
    void testDivide(){
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }

    @Test
    void testComputeCircleRadius(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }



}