package Main;

import Exception.EmptyList;
import Exception.NewZealandNotPresent;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PeopleArithmethic {

    public static Person getOldestPerson(List<Person> peopleList) {
        try {
            if (peopleList.isEmpty()) {
                throw new EmptyList();
            }
        } catch (EmptyList var2) {
            EmptyList e = var2;
            System.out.println(e.getMessage());
        }

        return peopleList.stream().max(Comparator.comparingInt(Person::getAge)).get();
    }

    public static float getAverageAge(List<Person> peopleList) {
        int sumAllAges=
                peopleList.stream().map(person -> person.getAge()).mapToInt(Integer::intValue).sum();
        return (float) sumAllAges / peopleList.size();
    }

    public static void minimumPreCountry (List<Person> peopleList,
                                          List<String> countryList) {
        for (String country : countryList) {
            Person minPreCountryPerson =
                    peopleList.stream().filter(person -> Objects.equals(person.getCountry(), country))
                            .min(Comparator.comparingInt(Person::getAge)).get();
            System.out.println("In "+country+" the youngest person is "+minPreCountryPerson.toStringNoCountry());
        }
    }

    public static void peoplePerAgeRanges (List<Person> peopleList) throws NewZealandNotPresent {
        String country= "New Zealand";
        boolean countryPresent = peopleList.stream()
                .anyMatch(person -> Objects.equals(person.getCountry(), "New Zealand"));
        if (!countryPresent ) {
            throw new NewZealandNotPresent();
        } else {
            Person oldestNewZealand= peopleList.stream().filter(person -> Objects.equals(person.getCountry(), country))
                    .max(Comparator.comparingInt(Person::getAge)).get();
            for (int i =0 ; i<= oldestNewZealand.getAge() ; i+=10) {
                int lowerBound= i;
                int upperBound= i+10;
                int countPreRange = (int) peopleList.stream().filter(person -> person.getAge() >= lowerBound && person.getAge() < upperBound).count();
                System.out.println("Range "+lowerBound+"-"+upperBound + " has "+countPreRange+" people");
            }
        }

    }

    public static void averagePreCountry (List<Person> peopleList,
                                          List<String> countryList) {
        for (String country : countryList) {
            int sumAllAgesPreCountry=
                    peopleList.stream().filter(person -> Objects.equals(person.getCountry(), country)).map(person -> person.getAge()).mapToInt(Integer::intValue).sum();
            int total=
                    (int) peopleList.stream().filter(person -> Objects.equals(person.getCountry(), country)).count();
            System.out.println("In " + country + " the average age is " + (float)sumAllAgesPreCountry / total);

        }
    }

}
