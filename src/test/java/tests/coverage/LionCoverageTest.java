package tests.coverage;

import org.junit.Test;
import com.example.Lion;
import org.junit.Assert;
import com.example.Feline;

public class LionCoverageTest {

    Lion lion;
    Feline feline = new Feline();

    @Test
    public void testCoverageDoesHaveMane() throws Exception {
        lion = new Lion(feline.felineAttributes.get(0) ,new Feline());
        Assert.assertTrue("should be [true]", lion.doesHaveMane());

        lion = new Lion(feline.felineAttributes.get(1) ,new Feline());
        Assert.assertFalse("should be [false]",lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testCoverageDoesHaveManeUnValid() throws Exception {
        lion = new Lion(feline.felineAttributes.get(2),new Feline());
        lion.doesHaveMane();
        Assert.assertFalse("should be [error]", lion.doesHaveMane());
    }

    @Test
    public void testCoverageGetKittens() throws Exception {
        lion = new Lion(feline.felineAttributes.get(1),new Feline());
        lion.getKittens();
        Assert.assertEquals("should be passed", lion.getKittens(), 1);
    }

    @Test
    public void testCoverageGetFood() throws Exception {
        lion = new Lion(feline.felineAttributes.get(0),new Feline());
        String actual = lion.getFood().toString().replace("[","").replace("]","");;
        Assert.assertEquals("should be passed", feline.felineAttributes.get(4), actual);
    }
}