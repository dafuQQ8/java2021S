package registration_application;

import registration_application.model.*;
import registration_application.database.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegistrationApplicationTest {
    Model model;
    DBHandler database;

    @BeforeEach
    void initialise() {
        database = new DBHandler();
        model = new Model();
    }

    @Test
    @DisplayName("Uniqueness test.")
    void uniquenessTest() {
        String genuineUsername = "Smith"; // the one that doen't exist in database.
        String authorUsername = "Kagu-tsuchi";
        assertAll(
            () -> assertTrue(DBHandler.uniqueIndex(genuineUsername), () -> "Gives true if username doesn't exists in database."),
            () -> assertFalse(DBHandler.uniqueIndex(authorUsername), () -> "Gives false if username already exists in database.")
        );
    }
}
