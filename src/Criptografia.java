import java.util.HashMap;
public class Criptografia {
    public static String cifraDeCesar(String texto, int chave) {
        StringBuilder textoCriptografado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            // Verifica se o caractere é uma letra
            if (Character.isLetter(caractere)) {
                // Verifica se o caractere é maiúsculo ou minúsculo e ajusta a base de acordo
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                // Aplica a cifra de César
                char novoCaractere = (char) (((caractere - base + chave) % 26) + base);
                textoCriptografado.append(novoCaractere);
            } else {
                // Caso o caractere não seja uma letra, adiciona-o sem modificação
                textoCriptografado.append(caractere);
            }
        }

        return textoCriptografado.toString();
    }

    private static final HashMap<Character, String> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put('A', ".- ");
        morseCodeMap.put('B', "-... ");
        morseCodeMap.put('C', "-.-. ");
        morseCodeMap.put('D', "-.. ");
        morseCodeMap.put('E', ". ");
        morseCodeMap.put('F', "..-. ");
        morseCodeMap.put('G', "--. ");
        morseCodeMap.put('H', ".... ");
        morseCodeMap.put('I', ".. ");
        morseCodeMap.put('J', ".--- ");
        morseCodeMap.put('K', "-.- ");
        morseCodeMap.put('L', ".-.. ");
        morseCodeMap.put('M', "-- ");
        morseCodeMap.put('N', "-. ");
        morseCodeMap.put('O', "--- ");
        morseCodeMap.put('P', ".--. ");
        morseCodeMap.put('Q', "--.- ");
        morseCodeMap.put('R', ".-. ");
        morseCodeMap.put('S', "... ");
        morseCodeMap.put('T', "- ");
        morseCodeMap.put('U', "..- ");
        morseCodeMap.put('V', "...- ");
        morseCodeMap.put('W', ".-- ");
        morseCodeMap.put('X', "-..- ");
        morseCodeMap.put('Y', "-.-- ");
        morseCodeMap.put('Z', "--.. ");
    }

    public static String codigoMorse(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (char caractere : texto.toUpperCase().toCharArray()) {
            String codigo = morseCodeMap.get(caractere);
            if (codigo != null) {
                resultado.append(codigo);
            } else {
                resultado.append(caractere).append(" / "); // Adiciona espaço entre palavras
            }
        }

        return resultado.toString();
    }

}
