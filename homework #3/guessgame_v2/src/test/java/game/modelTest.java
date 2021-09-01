package game;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class modelTest {

    Model model;
    
    @BeforeEach
    void init() {
        model = new Model();
    }

    @RepeatedTest(150)
    @DisplayName("Randomness test.")
    void testTargedNumberisAlwaysInRange() {
        assertThat(model.targetNumber(0, 100)).isBetween(1, 99);
    }
        
    @Test
    @DisplayName("Legitimacy test.")
    void testIscorrectNumberIsReallyLegit() {
        //given
        model.targetNumber = 57;
        //then
        assertAll(
            () -> assertTrue(model.correctnessProofer(model.targetNumber), () -> "Gives true if input matches targetNumber."),
            () -> assertFalse(model.correctnessProofer(model.targetNumber + 1), () -> "Gives false if input doesn't match targetNumber.")
        );
        model.targetNumber = 0;
    }
    @Nested
    public class RangeTests {
        @Test
        @DisplayName("Range setter test.")
        void testASCIIForRangeSetter() {
            //given
            int j = 0;
            String str = null; 
            int[] numbers = new int[69];
            for (int i = 58; i < 127; i++) {
                numbers[j] = i;
                str = Character.toString((char) i);
                //then
                assertFalse(model.rangeSetter(str), () -> "Gives false in case if rangeSetter didn't accept input." /*Input is restricted for [0-9] only*/);
                j++;
            } 
        }
    
        @Test
        @DisplayName("Range test.")
        void testMethodIsInRange() {
            model.inputRecorder[1] = 999;
            for (int i = 1; i < model.inputRecorder[1]; i++) {
                assertTrue(model.isInRange(i), () -> "Gives true if isInRange method works fine.");
            }
            model.inputRecorder[1] = 0;
        }  
    }
}