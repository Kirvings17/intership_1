package Test;

import Exception.EmptyList;
import Exception.NegativeAge;
import Main.PeopleArithmethic;
import Main.Person;
import Main.ReadInput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestAveragePreCountry {

    @Test
    public void testcountry() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./test1.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> country = (List)first.get(1);
        PeopleArithmethic.averagePreCountry(people, country);
        Iterator var6 = country.iterator();

        while(var6.hasNext()) {
            String countryT = (String)var6.next();
            Assert.assertTrue(outContent.toString().contains(countryT));
        }

        System.setOut(originalOut);
    }

    @Test
    public void testLargeFile() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./large.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> country = (List)first.get(1);
        PeopleArithmethic.averagePreCountry(people, country);
        Iterator var6 = country.iterator();

        while(var6.hasNext()) {
            String countryT = (String)var6.next();
            Assert.assertTrue(outContent.toString().contains(countryT));
        }

        System.setOut(originalOut);
    }

    @Test
    public void testWithAvrg() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./allNZ.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> country = (List)first.get(1);
        PeopleArithmethic.averagePreCountry(people, country);
        Assert.assertTrue(outContent.toString().contains("" + PeopleArithmethic.getAverageAge(people)));
        System.setOut(originalOut);
    }

    @Test
    public void testWithAvrglarge() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./largeJapan.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> country = (List)first.get(1);
        PeopleArithmethic.averagePreCountry(people, country);
        Assert.assertTrue(outContent.toString().contains("" + PeopleArithmethic.getAverageAge(people)));
        System.setOut(originalOut);
    }
}
