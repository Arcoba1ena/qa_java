package tests.parametrized;

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

import java.util.Collections;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Feline feline = new Feline();
    private final int lionKittens;
    private final String lionFood;

    public LionParametrizedTest(Integer lionKittens, String lionFood) {
        this.lionKittens = lionKittens;
        this.lionFood = lionFood;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0},{1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, "Травоядное"},
                {5, "Хищник"},
                {10, "Всеядное"}
        };
    }

    @Mock
    Feline mockFeline;

    @Test
    public void testKittensMockMethod() throws Exception {
        Lion lion = new Lion(feline.felineAttributes.get(1), mockFeline);
        Mockito.when(lion.getKittens()).thenReturn(lionKittens);
        Assert.assertEquals(lion.getKittens(), lionKittens);
    }

    @Test
    public void testGetFoodMockMethod() throws Exception {
        Lion lion = new Lion(feline.felineAttributes.get(0), mockFeline);
        Mockito.when(lion.getFood()).thenReturn(Collections.singletonList(lionFood));
        Assert.assertEquals(lion.getFood()
                .toString().replace("[","").replace("]",""), lionFood);
    }
}