package example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LocalRecords {

    public static List<PersonRecord> sortPeopleByAgeDesc(final List<PersonRecord> personRecords) {

        record Data(PersonRecord personRecord, int age){}

        return personRecords.stream()
                .map(personRecord -> new Data(personRecord, computeAge(personRecord)))
                .sorted(Comparator.comparingDouble(Data::age).reversed())
                .map(Data::personRecord)
                .collect(Collectors.toList());
    }

    private static int computeAge(final PersonRecord personRecord) {
        return Period.between(personRecord.dateOfBirth(), LocalDate.now()).getYears();
    }
}
