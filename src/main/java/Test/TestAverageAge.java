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

public class TestAverageAge {

    @Test
    public void testAvgAge() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./test1.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        float average = PeopleArithmethic.getAverageAge(people);
        Assert.assertEquals(62.25, average,0.001);
    }

    @Test
    public void testAvrgSamePerson() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./simglep.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        float avgAge = PeopleArithmethic.getAverageAge(people);
        Assert.assertEquals(30.0, (double)avgAge, 0.01);
    }

    @Test
    public void testAvrgAllSameAge() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./AllSameAge.ndjson");
        List<Person> people = (List)first.get(0);
        Assert.assertFalse(people.isEmpty());
        float avgAge = PeopleArithmethic.getAverageAge(people);
        Assert.assertEquals(44.0, (double)avgAge, 0.01);
    }
}

