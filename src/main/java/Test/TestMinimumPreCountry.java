package Test;
import Exception.EmptyList;
import Exception.NegativeAge;
import Main.PeopleArithmethic;
import Main.Person;
import Main.ReadInput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class TestMinimumPreCountry {
    @Test
    public void testMinimumPreCountryNormalCase() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./test1.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> countryList = (List)first.get(1);
        PeopleArithmethic.minimumPreCountry(people, countryList);
        String expectedOutput = "In United States the youngest person is Bertine Philipines, age: 47\nIn Hungary the youngest person is Malissia Theressa, age: 81\nIn Tuvalu the youngest person is Cordy Thunell, age: 77\nIn New Zealand the youngest person is Keelia Alex, age: 44";
        Assert.assertEquals(expectedOutput.trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    public void testwithOneCountry() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./simglep.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> countryList = (List)first.get(1);
        PeopleArithmethic.minimumPreCountry(people, countryList);
        String expectedOutput = "In United States the youngest person is Bertine Philipines, age: 30";
        Assert.assertEquals(expectedOutput.trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    public void testWithLargeFile() throws IOException, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./large.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> countryList = (List)first.get(1);
        PeopleArithmethic.minimumPreCountry(people, countryList);
        String expectedOutput = "In United States the youngest person is Evelyn Uriia, age: 2\nIn Hungary the youngest person is Mariette Eulau, age: 0\nIn Tuvalu the youngest person is Denny Parris, age: 0\nIn New Zealand the youngest person is Mollie Swithbert, age: 0\nIn Kiribati the youngest person is Tandi Newmann, age: 0\nIn Japan the youngest person is Shaine Kalin, age: 1\nIn Indonesia the youngest person is Tally Solenne, age: 1\nIn United Kingdom the youngest person is Abbye Winston, age: 0\nIn Nicaragua the youngest person is Ronnica Humberto, age: 1\nIn Egypt the youngest person is Federica Rorry, age: 0";
        Assert.assertEquals(expectedOutput.trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }
}
