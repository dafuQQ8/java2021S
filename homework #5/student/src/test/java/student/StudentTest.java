package student;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StudentTest {
    Student humanoid = new Student("Mark", "Zuckerberg", 37,"Facebook");
    Student reptiloid = new Student("Mark", "Zuckerberg", 37,"Facebook");

    @Test
    void humanoidMarkEqualsToReptiloidMark() {
        assertTrue(humanoid.equals(reptiloid));
    }

    @Test
    void humanoidMarkHashCodeEqualsToReptiloidMarkHashCode() {
        assertTrue(humanoid.hashCode() == reptiloid.hashCode());
    }
}


