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


    @Test
    public void testAdicaoEremocaoDeElemento() {
        GerenciarArray ga = new GerenciarArray(new int[]{10, 20, 30, 40, 50});
        ga.adicionarOuRemover(60);
        ga.adicionarOuRemover(60);
        assertArrayEquals(new int[]{10, 20, 30, 40, 50}, ga.getArray());
    }

    @Test
    public void testArrayFicaCheioEProgramaTermina() {
        GerenciarArray ga = new GerenciarArray(new int[]{1, 2, 3, 4, 5});
        ga.adicionarOuRemover(6);
        ga.adicionarOuRemover(7);
        ga.adicionarOuRemover(8);
        ga.adicionarOuRemover(9);
        ga.adicionarOuRemover(10);
        assertTrue(ga.isFull());
        assertThrows(IllegalStateException.class, () -> ga.adicionarOuRemover(11));
    }

}
