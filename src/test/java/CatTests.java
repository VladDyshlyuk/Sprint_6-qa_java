import com.example.Cat;
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    Feline feline;

    @Test
    public void getSoundIsCorrect() {
        String expectedSound = "Мяу";
        MatcherAssert.assertThat("Некорректный звук кота.",
                new Cat(feline).getSound(),
                equalTo(expectedSound)
        );
    }

    @Test
    public void getFoodIsCorrect() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Вернулась некорректная еда.",
                cat.getFood(),
                equalTo(expectedListOfFood)

        );

    }


}
