import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnalizadorTest {

    @Test
    public void testAnalizarSimbolos() {
        assertTrue(Analizador.analizarSimbolos("([])"));
        assertFalse(Analizador.analizarSimbolos("([)]"));
        assertTrue(Analizador.analizarSimbolos(""));
        assertFalse(Analizador.analizarSimbolos("(["));
    }
}