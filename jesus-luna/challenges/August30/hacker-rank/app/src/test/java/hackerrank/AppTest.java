/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hackerrank;

import org.junit.jupiter.api.Test;

import bootcamp.App;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test 
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertDoesNotThrow(()->classUnderTest.testHackerRank());
        
    }
}