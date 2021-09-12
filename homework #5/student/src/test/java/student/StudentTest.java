package student;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class StudentTest {
    Student humanoid;
    Student reptiloid;

    @BeforeEach
    void initialise() {
        humanoid = new Student("Mark", "Zuckerberg", 37,"Facebook");
        reptiloid = new Student("Mark", "Zuckerberg", 37,"Facebook");
    }

    @Test
    void humanoidMarkEqualsToReptiloidMark() {
        assertTrue(humanoid.equals(reptiloid));
    }

    @RepeatedTest(100)
    void humanoidMarkHashCodeEqualsToReptiloidMarkHashCode() {
        assertTrue(humanoid.hashCode() == reptiloid.hashCode());
    }
}


