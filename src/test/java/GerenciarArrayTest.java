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
        assertFalse(ga.adicionarOuRemover(11));
    }

    @Test
    public void testArrayFicaVazioEProgramaTermina() {
        GerenciarArray ga = new GerenciarArray(new int[]{1, 2, 3, 4, 5});
        ga.adicionarOuRemover(1);
        ga.adicionarOuRemover(2);
        ga.adicionarOuRemover(3);
        ga.adicionarOuRemover(4);
        ga.adicionarOuRemover(5);
        assertTrue(ga.isEmpty());
        assertFalse(ga.adicionarOuRemover(1));
    }

    @Test
    public void testAdicaoAposCheioNaoAlteraArray() {
        GerenciarArray ga = new GerenciarArray(new int[]{1, 2, 3, 4, 5});
        assertTrue(ga.adicionarOuRemover(6));
        assertTrue(ga.adicionarOuRemover(7));
        assertTrue(ga.adicionarOuRemover(8));
        assertTrue(ga.adicionarOuRemover(9));
        assertTrue(ga.adicionarOuRemover(10));
        assertTrue(ga.isFull());
        assertFalse(ga.adicionarOuRemover(11));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, ga.getArray());
    }

    @Test
    public void testRemocaoAposVazioNaoAlteraArray() {
        GerenciarArray ga = new GerenciarArray(new int[]{1, 2, 3, 4, 5});
        assertTrue(ga.adicionarOuRemover(1));
        assertTrue(ga.adicionarOuRemover(2));
        assertTrue(ga.adicionarOuRemover(3));
        assertTrue(ga.adicionarOuRemover(4));
        assertTrue(ga.adicionarOuRemover(5));
        assertTrue(ga.isEmpty());
        assertFalse(ga.adicionarOuRemover(1));
        assertArrayEquals(new int[0], ga.getArray());
    }
}
