package es.etg.dam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConversorTest {
    public Comando comando;

    @BeforeEach
    public void setup() {
        comando = new Conversor();
    }

    @Test
    public void testConvertir() throws Exception {
        String[] instruccion = { "echo", "test" };
        String resultado = comando.convertir(instruccion);
        assertEquals(Conversor.MSG_SALIDA, resultado);
    }

    @Test
    public void testConvertirError() throws Exception {
        String[] instruccion = { "ls", "hola que tal" };
        String resultado = comando.convertir(instruccion);
        assertEquals(Conversor.MSG_ERROR, resultado);
    }
}
