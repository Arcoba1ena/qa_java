package tests;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Assert;
import com.example.Feline;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;
import static com.example.constants.Constants.*;

@RunWith(Parameterized.class)
public class FelineTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Feline feline = new Feline();
    private final int resultValue;
    private final int kittensValue;


    public FelineTest(int kittensValue, int resultValue) {
        this.resultValue = resultValue;
        this.kittensValue = kittensValue;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, 1},
                {20, 50},
                {100,101}
        };
    }

    @Test
    public void testCoverageEatMeat() throws Exception {
        String actual = feline.eatMeat().toString();
        Assert.assertEquals("should be passed", FELINE_FOODS, actual);
    }

    @Test
    public void testCoverageGetFamily() {
        String actual = feline.getFamily();
        Assert.assertEquals("should be passed", FAMILY_NAME, actual);
    }

    @Test
    public void testCoverageGetKittens() {
        feline.getKittens();
        Assert.assertEquals("should be passed", feline.getKittens(), KITTENS_COUNT);
    }

    @Mock
    Feline mockFeline;

    @Test
    public void testGetKittensWithCount() {
        mockFeline.getKittens(kittensValue);
        Mockito.verify(mockFeline).getKittens(kittensValue);
        Mockito.when(mockFeline.getKittens(kittensValue)).thenReturn(resultValue);
        Assert.assertEquals(mockFeline.getKittens(kittensValue), resultValue);
    }
}