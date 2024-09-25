package Test;
import Exception.EmptyList;
import Exception.NegativeAge;
import Exception.NewZealandNotPresent;
import Main.PeopleArithmethic;
import Main.Person;
import Main.ReadInput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestPeoplePerAgeRanges {
    @Test
    public void testException() throws IOException, EmptyList, NegativeAge {
        try {
            List<List<?>> first = ReadInput.openNDJSON("noNZ.ndjson");
            List<Person> person = (List)first.get(0);
            PeopleArithmethic.peoplePerAgeRanges(person);
            Assert.fail("Expected NewZealandNotPresent exception to be thrown");
        } catch (NewZealandNotPresent var3) {
            NewZealandNotPresent e = var3;
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testRangeEdge() throws IOException, EmptyList, NegativeAge, NewZealandNotPresent {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./allNZ.ndjson");
        List<Person> people = (List)first.get(0);
        PeopleArithmethic.peoplePerAgeRanges(people);
        String expectedOutput = "Range 0-10 has 1 people\nRange 10-20 has 1 people\nRange 20-30 has 1 people\nRange 30-40 has 1 people\nRange 40-50 has 1 people";
        Assert.assertEquals(expectedOutput.trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    public void testMissingAge() throws IOException, EmptyList, NegativeAge, NewZealandNotPresent {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./allNZgap.ndjson");
        List<Person> people = (List)first.get(0);
        PeopleArithmethic.peoplePerAgeRanges(people);
        String expectedOutput = "Range 0-10 has 0 people\nRange 10-20 has 1 people\nRange 20-30 has 1 people\nRange 30-40 has 1 people\nRange 40-50 has 1 people\nRange 50-60 has 0 people\nRange 60-70 has 1 people";
        Assert.assertEquals(expectedOutput.trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    public void testLargeFile() throws IOException, NewZealandNotPresent, EmptyList, NegativeAge {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<List<?>> first = ReadInput.openNDJSON("./large.ndjson");
        List<Person> people = (List)first.get(0);
        PeopleArithmethic.peoplePerAgeRanges(people);
        Assert.assertTrue(outContent.toString().contains("Range 0-10 has"));
        Assert.assertTrue(outContent.toString().contains("Range 110-120 has"));
        System.setOut(originalOut);
    }
}
