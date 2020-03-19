package io.ghevi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// Every test that runs, there will be a new instance of this whole class
// DO NOT use the @Order annotation, tests should be decoupled from one another
// DO NOT declare instance variables to use in the methods, except ofc for the class instance,
// because isn't tied of the methods order (which junit execute randomly)

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach // It will run before each Test
    void init(){
        mathUtils = new MathUtils();
    }

    @Test
    void testAdd(){
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
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }

    @Test
    void testComputeCircleRadius(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }




}