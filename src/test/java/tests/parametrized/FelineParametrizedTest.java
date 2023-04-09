package tests.parametrized;

import org.junit.Test;
import org.junit.Assert;
import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.ComparisonFailure;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    Feline feline = new Feline();
    private final int kittensValue;
    private final String felineEatValue;
    private final String felineFamilyValue;

    public FelineParametrizedTest(int kittensValue, String felineEatValue, String felineFamilyValue) {
        this.kittensValue = kittensValue;
        this.felineEatValue = felineEatValue;
        this.felineFamilyValue = felineFamilyValue;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0},{1},{2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, "Мясо", "Заячьи"},
                {10, "Рыба", "Беличьи"},
                {100, "Трава", "Медвежьи"}
        };
    }

    @Test
    public void testGetKittensWithCount() {
        int actual = feline.getKittens(kittensValue);
        Assert.assertEquals("should be passed", actual, kittensValue);
    }

    @Test(expected = ComparisonFailure.class)
    public void testEatMeatWithUnValidParams() throws Exception {
        String actual = feline.eatMeat().toString();
        Assert.assertEquals("should be passed with ComparisonFailure exception",actual, felineEatValue);
    }

    @Test(expected = ComparisonFailure.class)
    public void testGetFamilyWithUnValidParams() {
        String actual = feline.getFamily();
        Assert.assertEquals("should be passed with ComparisonFailure exception",actual, felineFamilyValue);
    }
}