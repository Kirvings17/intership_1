package Main;

import Exception.EmptyList;
import Exception.NegativeAge;
import Exception.NewZealandNotPresent;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a NDJSON file path: ");
        String filePath = scanner.nextLine();

        try {
            List<List<?>> items = ReadInput.openNDJSON(filePath);
            List<Person> people = (List)items.get(0);
            List<String> countryList = (List)items.get(1);

            label39:
            while(true) {
                while(true) {
                    System.out.println("Type 'o' to get the oldest person");
                    System.out.println("Type 'a' to get the average age");
                    System.out.println("Type 'm' to get the minimum age per country");
                    System.out.println("Type 's' to get the average age per country");
                    System.out.println("Type 'r' to get the age range in New Zealand");
                    System.out.println("Type 'q' to quit");
                    String input = scanner.next();
                    char letter = input.charAt(0);
                    if (letter == 'o') {
                        Person oldest = PeopleArithmethic.getOldestPerson(people);
                        System.out.println("The oldest person is " + oldest);
                    } else if (letter == 'a') {
                        float average = PeopleArithmethic.getAverageAge(people);
                        System.out.println("The average age is: " + average);
                    } else if (letter == 'm') {
                        PeopleArithmethic.minimumPreCountry(people, countryList);
                    } else if (letter == 's') {
                        PeopleArithmethic.averagePreCountry(people, countryList);
                    } else if (letter == 'r') {
                        PeopleArithmethic.peoplePerAgeRanges(people);
                    } else {
                        if (letter == 'q') {
                            System.out.println("Exiting the program...");
                            break label39;
                        }

                        System.out.println("Wrong input, try again.");
                    }
                }
            }
        } catch (NegativeAge | NewZealandNotPresent | EmptyList e) {

            System.out.println("An error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred, check the name of the file and the file style...");
        }

        scanner.close();
    }
}
