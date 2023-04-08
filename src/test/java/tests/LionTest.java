package tests;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import com.example.Lion;
import org.junit.Assert;
import com.example.Feline;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;
import static com.example.constants.Constants.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Lion lion = new Lion(new Feline());
    private final int lionKittens;

    public LionTest(Integer lionKittens) {
        this.lionKittens = lionKittens;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {0}, {5}, {10}
        };
    }

    @Test
    public void testCoverageDoesHaveMane() throws Exception {
        Lion male = new Lion(LION_MALE);
        Assert.assertTrue("should be [true]", male.doesHaveMane());

        Lion female = new Lion(LION_FEMALE);
        Assert.assertFalse("should be [false]",female.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testCoverageDoesHaveManeUnValid() throws Exception {
        Lion lion = new Lion(NEUTER_GENDER);
        lion.doesHaveMane();
        Assert.assertFalse("should be [error]", lion.doesHaveMane());
    }

    @Test
    public void testCoverageGetKittens() {
        lion.getKittens();
        Assert.assertEquals("should be passed", lion.getKittens(), KITTENS_COUNT);
    }

    @Test
    public void testCoverageGetFood() throws Exception {
        String actual = lion.getFood().toString();
        Assert.assertEquals("should be passed", FELINE_FOODS, actual);
    }

    @Mock
    Lion mockLion;

    @Test
    public void testKittensMockMethod() {
        mockLion.getKittens();
        Mockito.verify(mockLion).getKittens();
        Mockito.when(mockLion.getKittens()).thenReturn(lionKittens);
        Assert.assertEquals(mockLion.getKittens(), lionKittens);
    }

    @Test
    public void testGetFoodMockMethod() throws Exception {
        mockLion.getFood();
        Mockito.verify(mockLion).getFood();
        Mockito.verify(mockLion, Mockito.times(1)).getFood();
    }
}