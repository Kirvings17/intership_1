package Test;
import Exception.EmptyList;
import Exception.NegativeAge;
import Main.Person;
import Main.ReadInput;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class TestReadInput {
    @Test
    public void testCheckNotEmpty() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./test1.ndjson");
        Assert.assertTrue(!first.isEmpty());
    }

    @Test
    public void testCheckIOError() {
        try {
            List<List<?>> first = ReadInput.openNDJSON("test");
            Assert.fail("Expected IOEXCEPTION  to be thrown");
        } catch (IOException var2) {
            IOException e = var2;
            System.out.println(e.getMessage());
        } catch (NegativeAge | EmptyList var3) {
            Assert.fail("Expected IOEXCEPTION to be thrown");
        }

    }

    @Test
    public void testCheckEmptyListError() {
        try {
            List<List<?>> first = ReadInput.openNDJSON("empty.ndjson");
            Assert.fail("Expected EmptyList to be thrown");
        } catch (NegativeAge | IOException var2) {
            Assert.fail("Expected EmptyList to be thrown");
        } catch (EmptyList var3) {
            EmptyList e = var3;
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testCheckSize() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("test1.ndjson");
        List<Person> people = (List)first.get(0);
        List<String> countryList = (List)first.get(1);
        Assert.assertEquals((long)people.size(), 4L);
        Assert.assertEquals((long)countryList.size(), 4L);
    }

    @Test
    public void testWrongFormat() {
        try {
            List<List<?>> first = ReadInput.openNDJSON("./test4.ndjson");
            Assert.fail("Expected exception due to missing fields");
        } catch (Exception var2) {
        }

    }

    @Test
    public void testLargeFile() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./large.ndjson");
        Assert.assertTrue(!first.isEmpty());
        List<Person> people = (List)first.get(0);
        List<String> countries = (List)first.get(1);
        Assert.assertTrue(people.size() == 1174);
        Assert.assertTrue(countries.size() > 8);
    }

    @Test
    public void testcountry() throws IOException, EmptyList, NegativeAge {
        List<List<?>> first = ReadInput.openNDJSON("./large.ndjson");
        Assert.assertTrue(!first.isEmpty());
        List<String> countries = (List)first.get(1);
        Assert.assertTrue(countries.contains("New Zealand"));
        Assert.assertTrue(countries.contains("United States"));
        Assert.assertTrue(countries.contains("Japan"));
    }

    @Test
    public void testCheckNegativeAge() {
        try {
            List<List<?>> first = ReadInput.openNDJSON("negativeage.ndjson");
            Assert.fail("Expected NegativeAge to be thrown");
        } catch (NegativeAge var2) {
            NegativeAge e = var2;
            System.out.println(e.getMessage());
        } catch (EmptyList | IOException var3) {
            Assert.fail("Expected NegativeAge to be thrown");
        }

    }
}
