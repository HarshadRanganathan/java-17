package example;

import java.time.LocalDate;
import java.util.Objects;

public record PersonRecord(String lastName, String firstName, LocalDate dateOfBirth) {

    public PersonRecord {
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(firstName);
    }
}
