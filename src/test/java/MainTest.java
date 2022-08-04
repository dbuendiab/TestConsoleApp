import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // MainFunc es una interfaz funcional para pasar main() como parámetro
    private String MockTest(String userInput, MainFunc func) {
        MockIO mio = new MockIO(userInput);
        func.main(null);
        return mio.getOutput();
    }

    @Test
    void normal_way() {
        String simulatedUserInput = """
                1
                2
                0
                """;

        String expectedOutput = """
                1. Elevar al cuadrado
                2. Elevar al cubo
                0. Salir
                12
                24
                Adios
                """;

        String output = MockTest(simulatedUserInput, Main::main);
        assertEquals(expectedOutput, output);
    }

    @Test
    void inverse_way() {
        String simulatedUserInput = """
                2
                1
                0
                """;

        String expectedOutput = """
                1. Elevar al cuadrado
                2. Elevar al cubo
                0. Salir
                24
                12
                Adios
                """;

        String output = MockTest(simulatedUserInput, Main::main);
        assertEquals(expectedOutput, output);
/*
        MockIO mio = new MockIO(simulatedUserInput);
        Main.main(null);
        String salida = mio.output();

        // Comparar salida esperada y real
        assertEquals(expectedOutput, salida);*/
    }

    @Test
    void bad_number() {
        String simulatedUserInput = """
                5
                0
                """;

        String expectedOutput = """
                1. Elevar al cuadrado
                2. Elevar al cubo
                0. Salir
                Introduce 1, 2 o 0
                Adios
                """;

        String output = MockTest(simulatedUserInput, Main::main);
        assertEquals(expectedOutput, output);
    }

    @Test
    void bad_input() {
        String simulatedUserInput = """
                texto de entrada
                0
                """;

        String expectedOutput = """
                1. Elevar al cuadrado
                2. Elevar al cubo
                0. Salir
                Error entrada
                Adios
                """;

        String output = MockTest(simulatedUserInput, Main::main);
        assertEquals(expectedOutput, output);
    }

    interface MainFunc {
        void main(String[] s);
    }

}
