import org.example.GerenciarArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciarArrayTest {
    @Test
    public void testInicializacaoCorreta() {
        GerenciarArray ga = new GerenciarArray(new int[]{10, 20, 30, 40, 50});
        assertNotNull(ga);
        assertEquals("10 20 30 40 50", ga.toString());
    }

    @Test
    public void testInicializacaoComNumerosRepetidos() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new GerenciarArray(new int[]{10, 20, 30, 30, 50});
        });

        assertTrue(thrown.getMessage().contains("nao podem ser repetidos"));
    }
}
