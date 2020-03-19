package io.ghevi;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


// Every test that runs, there will be a new instance of this whole class
// DO NOT use the @Order annotation, tests should be decoupled from one another
// DO NOT declare instance variables to use in the methods, except ofc for the class instance,
// because isn't tied of the methods order (which junit execute randomly)
// @Before* annotations creates "hooks" (see tests life cycle)


// @TestInstance(TestInstance.Lifecycle.PER_CLASS)  <!-- This will create just one instances of the class for all the tests, before all methods -->
class MathUtilsTest {

    MathUtils mathUtils;

    /*
    @BeforeAll // It runs as the first method
    static void beforeAllInit(){  // This method cant run because there are no instances of MathUtils yet, so we need to add static
        System.out.println("This needs to run before all");
    }

    @BeforeAll // It runs as the first method
    void beforeAllInit(){  // Here we removed static because of @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        System.out.println("This needs to run before all");
    }

    @AfterEach
    void cleanup() { // It will run after each test
        System.out.print("Cleaning up..");
    }
    */

    @BeforeEach // It will run before each test
    void init(){
        mathUtils = new MathUtils();
    }

    @Test
    @DisplayName("Testing add method") // Change the label of the test
    void testAdd() {
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
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Test divide method")
    void testDivide() {
        boolean isServerUp = true;

        assumeTrue(isServerUp); // Run the test only if argument is true, useful in case that we have a server that is not running
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }

    @Test
    @DisplayName("Test computeCircleArea")
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @Disabled // Ignore the test
    @DisplayName("Test disabled")
    void testDisabled(){
        fail("This test should be disabled");
    }

    @Test
    @EnabledOnOs(OS.LINUX) // There are also EnabledOnJre, EnabledIf, EnabledIfSystemProperty, EnabledIfEnvironmentVariable
    @DisplayName("This enabled on linux")
    void testEnabledOnLinux(){
        fail("This test should run only on linux");
    }

}