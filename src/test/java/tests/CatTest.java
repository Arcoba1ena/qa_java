package tests;

import org.junit.Test;
import com.example.Cat;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Assert;
import com.example.Feline;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;
import static com.constants.Constants.*;

@RunWith(Parameterized.class)
public class CatTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Cat cat = new Cat(new Feline());
    private final String animalSound;

    public CatTest(String animalSound) {
        this.animalSound = animalSound;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Мяу"},
                {"Му-Му"},
                {"Гав-Гав"},
        };
    }

    @Test
    public void testCoverageSound() {
        String actual = cat.getSound();
        Assert.assertEquals("should be passed", CAT_SOUNDS, actual);
    }

    @Test
    public void testCoverageFood() throws Exception {
        String actual = cat.getFood().toString();
        Assert.assertEquals("should be passed", FELINE_FOODS, actual);
    }

    @Mock
    Cat mockCat;

    @Test
    public void testSoundMockMethod() {
        mockCat.getSound();
        Mockito.verify(mockCat).getSound();
        Mockito.when(mockCat.getSound()).thenReturn(animalSound);
        Assert.assertEquals(mockCat.getSound(), animalSound);
    }

    @Test
    public void testFoodMockMethod() throws Exception {
        mockCat.getFood();
        Mockito.verify(mockCat).getFood();
        Mockito.verify(mockCat, Mockito.times(1)).getFood();
    }
}