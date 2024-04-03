import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicialização do objeto Scanner para entrada de dados

        // Solicitação da opção desejada ao usuário
        System.out.println("O que deseja Fazer:");
        System.out.println("1. Criptografar texto");
        System.out.println("2. Descriptografar texto");
        int opcao = scanner.nextInt(); // Leitura da opção escolhida pelo usuário
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:
                System.out.println("Escolha a criptografia desejada:");
                System.out.println("1. Cifra de César");
                System.out.println("2. Código Morse");
                int cOption = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                String textoOriginal;
                // Loop para garantir que o texto inserido pelo usuário não contenha caracteres inválidos
                do {
                    System.out.println("Digite o texto que deseja criptografar (sem caracteres acentuados ou números):");
                    textoOriginal = scanner.nextLine(); // Leitura do texto original
                } while (verificarCaracteresInvalidos(textoOriginal)); // Verificar se o texto contém caracteres inválidos

                switch (cOption) {
                    case 1:
                        System.out.println("Digite a chave de criptografia para a Cifra de César:");
                        int chaveCifra = scanner.nextInt(); // Leitura da chave de criptografia
                        String textoCifra = Criptografia.cifraDeCesar(textoOriginal, chaveCifra);
                        System.out.println("Texto criptografado pela Cifra de César: " + textoCifra);
                        break;
                    case 2:
                        String textoMorse = Criptografia.codigoMorse(textoOriginal);
                        System.out.println("Texto criptografado em código Morse: " + textoMorse);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                break;
            case 2:
                System.out.println("Escolha a criptografia que deseja descriptografar:");
                System.out.println("1. Cifra de César");
                System.out.println("2. Código Morse");
                int dOption = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o texto que deseja descriptografar:");
                String textoCriptografado = scanner.nextLine();

                switch (dOption) {
                    case 1:
                        System.out.println("Digite a chave de criptografia usada na Cifra de César:");
                        int chaveCifra = scanner.nextInt();
                        String textoDecifradoCifra = Descriptografias.decifraCesar(textoCriptografado, chaveCifra);
                        System.out.println("Texto decifrado pela Cifra de César: " + textoDecifradoCifra);
                        break;
                    case 2:
                        String textoDecifradoMorse = Descriptografias.decifraMorse(textoCriptografado);
                        System.out.println("Texto decifrado em código Morse: " + textoDecifradoMorse);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }

    // Método para verificar se o texto contém caracteres inválidos (números e caracteres acentuados)
    private static boolean verificarCaracteresInvalidos(String texto) {
        return texto.matches(".*[áàãâéèêíìîóòõôúùûç\\d].*");
    }
}