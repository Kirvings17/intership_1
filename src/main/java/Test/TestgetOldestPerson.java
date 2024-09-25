package Test;
import Exception.EmptyList;
import Exception.NegativeAge;
import Main.PeopleArithmethic;
import Main.Person;
import Main.ReadInput;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class TestgetOldestPerson {
    @Test
    public void test0ldage() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./test1.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        Person oldest = PeopleArithmethic.getOldestPerson(people);
        Assert.assertEquals(81L, (long)oldest.getAge());
    }

    @Test
    public void testMultiplePeopleSameAge() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./sameagepeople.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        Person oldest = PeopleArithmethic.getOldestPerson(people);
        Assert.assertEquals(0L, (long)oldest.getAge());
        Assert.assertEquals("Bertine", oldest.getFirstname());
    }

    @Test
    public void testOldLarge() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./test3.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        Person oldest = PeopleArithmethic.getOldestPerson(people);
        Assert.assertEquals(125L, (long)oldest.getAge());
    }

    @Test
    public void testOldGetResult() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./test3.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        Person oldest = PeopleArithmethic.getOldestPerson(people);
        Assert.assertNotNull(oldest);
    }
}
