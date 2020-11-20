import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordTest {
    @Test
    public void computeFrequencyTest(){
        List<Word> listFrequency = Main.computeFrequency("baz bar foo foo zblah zblah zblah baz toto bar", 3);
        Assert.assertEquals(3, listFrequency.size());
        Assert.assertEquals("zblah", listFrequency.get(0).getWord());
        Assert.assertEquals(3, listFrequency.get(0).getFrequency());
        Assert.assertEquals("bar", listFrequency.get(1).getWord());
        Assert.assertEquals(2, listFrequency.get(1).getFrequency());
        Assert.assertEquals("baz", listFrequency.get(2).getWord());
        Assert.assertEquals(2, listFrequency.get(2).getFrequency());
    }
}
