package game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class modelTest {

    Model model = new Model();

    @Test
    void testTargedNumberisAlwaysInRange() {
        for (int i = 2; i < 100; i++) {
            assertThat(model.targetNumber(0, i)).isBetween(1, 99);
        }
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