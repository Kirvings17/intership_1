package Main;

import Exception.EmptyList;
import Exception.NegativeAge;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ReadInput {
    public ReadInput() {
    }

    public static List<List<?>> openNDJSON(String name) throws IOException, EmptyList, NegativeAge {
        List<Person> people = new ArrayList();
        List<String> countryList = new ArrayList();
        List<String> lines = Files.readAllLines(Paths.get(name));
        if (lines.isEmpty()) {
            throw new EmptyList();
        } else {
            Iterator var4 = lines.iterator();

            while(true) {
                String line;
                do {
                    do {
                        if (!var4.hasNext()) {
                            List<List<?>> listOfLists = new ArrayList();
                            listOfLists.add(people);
                            listOfLists.add(countryList);
                            return listOfLists;
                        }

                        line = (String)var4.next();
                        line = line.trim();
                    } while(line.isEmpty());
                } while(!line.startsWith("{"));

                JSONObject object = new JSONObject(line);
                String firstName = object.getString("firstName");
                String lastName = object.getString("lastName");
                String country = object.getString("country");
                if (object.getInt("age") < 0) {
                    throw new NegativeAge();
                }

                int age = object.getInt("age");
                if (countryList.isEmpty() || !countryList.contains(country)) {
                    countryList.add(country);
                }

                Person personToAdd = new Person(firstName, lastName, country, age);
                people.add(personToAdd);
            }
        }
    }
}