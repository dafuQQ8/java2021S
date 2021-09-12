package immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImmutableCompanyTest {
    ImmutableCompany immutableCompany;

    @Test
    void ImmutabilityTest() {
        immutableCompany = new ImmutableCompany("Google");
        assertAll(
            () -> assertTrue(immutableCompany.currentIndustry().equals(immutableCompany.currentIndustry()),
                () -> "Gives true if deep copy's Industry is equal to constructors."),
            () -> assertFalse(immutableCompany.currentIndustry().equals(immutableCompany.newIndustry("IT").currentIndustry()),
                () -> "Gives false if deep copy's Industry is not equal to newly created one."),
            () -> assertFalse(immutableCompany.equals(immutableCompany.newIndustry("IT")),
                () -> "Gives false if immutableCompanys are considered to be different.")
        );
    }
}
