package game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
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
    void testTargedNumberisAlwaysInRange() {
        assertThat(model.targetNumber(0, 100)).isBetween(1, 99);
    }

    @Test
    void testASCIIForRangeSetter() {
        //given
        int j = 0;
        String str = null; 
        int[] numbers = new int[69];
        for (int i = 58; i < 127; i++) {
            numbers[j] = i;
            str = Character.toString((char) i);
            //then
            assertFalse(model.rangeSetter(str));
            j++;
        } 
    }
    
    @Test
    void testIscorrectNumberIsReallyLegit() {
        //given
        model.targetNumber = 57;
        //then
        assertTrue(model.correctnessProofer(model.targetNumber));
        assertFalse(model.correctnessProofer(model.targetNumber + 1));
    }
    
    @Test
    void testMethodIsInRange() {
        model.inputRecorder[1] = 999;
        for (int i = 1; i < model.inputRecorder[1]; i++) {
            assertTrue(model.isInRange(i));
        }
    }
}