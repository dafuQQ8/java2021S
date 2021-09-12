package student;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class StudentTest {
    Student humanoid;
    Student reptiloid;
    Student jackMa;

    @BeforeEach
    void initialise() {
        humanoid = new Student("Mark", "Zuckerberg", 37,"Facebook, Inc.");
        reptiloid = new Student("Mark", "Zuckerberg", 37,"Facebook, Inc.");
        jackMa = new Student("Jack", "Ma", 57,"Alibaba Group");
    }

    @Test
    void humanoidMarkEqualsToReptiloidMark() {
        assertAll(
            () -> assertTrue(humanoid.equals(reptiloid), () -> "Gives true if Mark is actual reptiloid."),
            () -> assertFalse(humanoid.equals(jackMa), () -> "Gives false if Mark is not Jack Ma")
        );
    }

    @RepeatedTest(100)
    void humanoidMarkHashCodeEqualsToReptiloidMarkHashCode() {
        assertAll(
            () -> assertTrue(humanoid.hashCode() == reptiloid.hashCode(), () -> "Gives true if Mark's hash code is same as reptiloid's."),
            () -> assertFalse(humanoid.hashCode() == jackMa.hashCode(), () -> "Gives false if Mark's hash code doesn't match Jack Ma's")
        );
    }
}


