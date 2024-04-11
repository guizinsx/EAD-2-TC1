import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GerenciarArrayTest {
    @Test
    public void testInicializacaoCorreta() {
        GerenciarArray ga = new GerenciarArray(new int[]{10, 20, 30, 40, 50});
        assertNotNull(ga);
        assertEquals("10 20 30 40 50", ga.toString());
    }
}
