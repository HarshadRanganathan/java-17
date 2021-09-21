package example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

public class LocalRecords {

    public static List<PersonRecord> sortPeopleByAgeDesc(final List<PersonRecord> personRecords) {

        record Data(PersonRecord personRecord, int age){}

        return personRecords.stream()
                .map(personRecord -> new Data(personRecord, computeAge(personRecord)))
                .sorted(Comparator.comparingDouble(Data::age).reversed())
                .map(Data::personRecord)
                .toList();
    }

    private static int computeAge(final PersonRecord personRecord) {
        return Period.between(personRecord.dateOfBirth(), LocalDate.now()).getYears();
    }
}
