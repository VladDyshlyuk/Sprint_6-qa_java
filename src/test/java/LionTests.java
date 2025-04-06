import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {


    @Mock
    Feline feline;

    @Test
    public void getKittensIsCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedCount = 3;
        when(feline.getKittens()).thenReturn(expectedCount);

        assertThat("Неверное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getFoodIsCorrect() throws Exception {

        Lion lion = new Lion(feline, "Самец");
        List<String> expectedListOfFood = List.of("Хищник");
        when(feline.eatMeat()).thenReturn(expectedListOfFood);


        assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)
        );
    }

    @Test
    public void createLionThrowsException() throws Exception {
       Exception e = assertThrows(
                Exception.class, () -> new Lion(feline, "Недопустимо"));


        assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
    }
}
