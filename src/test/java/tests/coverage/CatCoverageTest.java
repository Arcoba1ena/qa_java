package tests.coverage;

import org.junit.Test;
import com.example.Cat;
import org.junit.Assert;
import com.example.Feline;

public class CatCoverageTest {
    Cat cat = new Cat(new Feline());
    Feline feline = new Feline();

    @Test
    public void testCoverageSound() {
        String actual = cat.getSound();
        Assert.assertEquals("should be passed", feline.felineAttributes.get(5), actual);
    }

    @Test
    public void testCoverageFood() throws Exception {
        String actual = cat.getFood().toString().replace("[","").replace("]","");
        Assert.assertEquals("should be passed", feline.felineAttributes.get(4), actual);
    }
}