package tests.coverage;

import org.junit.Test;
import org.junit.Assert;
import com.example.Feline;

public class FelineCoverageTest {

    Feline feline = new Feline();

    @Test
    public void testCoverageEatMeat() throws Exception {
        String actual = feline.eatMeat().toString().replace("[","").replace("]","");;
        Assert.assertEquals("should be passed", feline.felineAttributes.get(4), actual);
    }

    @Test
    public void testCoverageGetFamily() {
        String actual = feline.getFamily();
        Assert.assertEquals("should be passed", feline.felineAttributes.get(3), actual);
    }

    @Test
    public void testCoverageGetKittens() {
        feline.getKittens();
        Assert.assertEquals("should be passed", feline.getKittens(), 1);
    }
}