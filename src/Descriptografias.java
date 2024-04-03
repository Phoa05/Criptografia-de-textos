import java.util.*;

public class Descriptografias {

    public static String decifraCesar(String texto, int chave) {
        StringBuilder textoDecifrado = new StringBuilder();

        // Itera sobre cada caractere do texto fornecido
        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            // Verifica se o caractere é uma letra
            if (Character.isLetter(caractere)) {
                // Verifica se o caractere é maiúsculo ou minúsculo e ajusta a base de acordo
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                // Aplica a decifra de César
                char novoCaractere = (char) (((caractere - base - chave + 26) % 26) + base);
                textoDecifrado.append(novoCaractere);
            } else {
                // Caso o caractere não seja uma letra, adiciona-o sem modificação
                textoDecifrado.append(caractere);
            }
        }

        return textoDecifrado.toString();
    }

    private static final HashMap<String, Character> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put(".-", 'a');
        morseCodeMap.put("-...", 'b');
        morseCodeMap.put("-.-.", 'c');
        morseCodeMap.put("-..", 'd');
        morseCodeMap.put(".", 'e');
        morseCodeMap.put("..-.", 'f');
        morseCodeMap.put("--.", 'g');
        morseCodeMap.put("....", 'h');
        morseCodeMap.put("..", 'i');
        morseCodeMap.put(".---", 'j');
        morseCodeMap.put("-.-", 'k');
        morseCodeMap.put(".-..", 'l');
        morseCodeMap.put("--", 'm');
        morseCodeMap.put("-.", 'n');
        morseCodeMap.put("---", 'o');
        morseCodeMap.put(".--.", 'p');
        morseCodeMap.put("--.-", 'q');
        morseCodeMap.put(".-.", 'r');
        morseCodeMap.put("...", 's');
        morseCodeMap.put("-", 't');
        morseCodeMap.put("..-", 'u');
        morseCodeMap.put("...-", 'v');
        morseCodeMap.put(".--", 'w');
        morseCodeMap.put("-..-", 'x');
        morseCodeMap.put("-.--", 'y');
        morseCodeMap.put("--..", 'z');
    }

    public static String decifraMorse(String codigoMorse) {
        StringBuilder resultado = new StringBuilder();
        String[] palavras = codigoMorse.split(" / "); // Divide o texto em palavras separadas por " / "

        for (String palavraMorse : palavras) {
            String[] letrasMorse = palavraMorse.split(" ");
            for (String letraMorse : letrasMorse) {
                Character caractere = morseCodeMap.get(letraMorse);
                if (caractere != null) {
                    resultado.append(caractere); // Adiciona o caractere ao resultado
                }
            }
            resultado.append(" ");
        }

        return resultado.toString().trim(); // Retorna o texto decifrado sem espaços extras no início ou no final
    }
}