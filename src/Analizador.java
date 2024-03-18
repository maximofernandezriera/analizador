import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Analizador {
    public static boolean analizarSimbolos(String cadena) {
        // Diccionario para almacenar los símbolos y su contraparte, es decir el símbolo contrario
        Map<Character, Character> simbolos;
        simbolos = new HashMap<Character, Character>();
        simbolos.put('(', ')');
        simbolos.put('[', ']');

        // Lista para almacenar los símbolos abiertos
        ArrayList<Character> lista = new ArrayList<Character>();

        // Recorrer la cadena caracter a caracter
        for (char simbolo : cadena.toCharArray()) {
            // Si el símbolo es un paréntesis o corchete abierto, se agrega a la lista
            if (simbolos.containsKey(simbolo)) {
                lista.add(simbolo);
            } else {
                // Si el símbolo es un paréntesis o corchete cerrado
                if (simbolos.containsValue(simbolo)) {
                    // Si la lista está vacía, la cadena no está bien formada
                    if (lista.isEmpty()) {
                        return false;
                    }

                    // Si el símbolo no coincide con el último símbolo abierto, la cadena no está bien formada
                    char ultimoSimboloAbierto = lista.remove(lista.size() - 1);
                    if (simbolos.get(ultimoSimboloAbierto) != simbolo) {
                        return false;
                    }
                }
            }
        }

        // Si la lista no está vacía, la cadena no está bien formada
        return lista.isEmpty();
    }
}