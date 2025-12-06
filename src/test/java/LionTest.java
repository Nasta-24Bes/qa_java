import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void lionConstructorInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "Неизвестный"));
        assertEquals("Используйте допустимые значения пола - Самец или Самка", exception.getMessage());
    }

    @Test
    public void getKittensUsesFelineKittens() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion(feline, "Самец");
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void getFamilyUsesFelineFamily() throws Exception {
        when(feline.getFamily()).thenReturn("Кошачьи");
        Lion lion = new Lion(feline, "Самка");
        assertEquals("Кошачьи", lion.getFamily());
    }

    @Test
    public void eatMeatUsesFelineEatMeat() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(feline, "Самец");
        assertEquals(List.of("Мясо"), lion.eatMeat());
    }
}
