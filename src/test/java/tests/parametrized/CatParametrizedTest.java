package tests.parametrized;

import org.junit.Test;
import com.example.Cat;
import org.junit.Assert;
import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.ComparisonFailure;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CatParametrizedTest {

    Cat cat = new Cat(new Feline());
    private final String animalFood;
    private final String animalSound;

    public CatParametrizedTest(String animalSound, String animalFood) {
        this.animalSound = animalSound;
        this.animalFood = animalFood;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Му-Му","Трава"},
                {"Мяу-Мяу","Корм для кошек"},
                {"Гав-Гав","Корм для собак"},
        };
    }

    @Test(expected = ComparisonFailure.class)
    public void testWithUnValidParams() throws Exception {
        String actualSound = cat.getSound();
        Assert.assertEquals("should be passed with ComparisonFailure exception", actualSound, animalSound);

        String actualFood = cat.getFood().toString();
        Assert.assertEquals("should be passed with ComparisonFailure exception",actualFood, animalFood);
    }
}