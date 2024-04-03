//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("O que deseja Fazer:");
        System.out.println("1. Criptografar texto");
        System.out.println("2. Descriptografar texto");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao){
            case 1:
                System.out.println("Escolha a criptografia desejada:");
                System.out.println("1. Cifra de César");
                System.out.println("2. Código Morse");
                int cOption = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                System.out.println("Digite o texto que deseja criptografar:");
                String textoOriginal = scanner.nextLine();

                switch (cOption) {
                    case 1:
                        System.out.println("Digite a chave de criptografia para a Cifra de César:");
                        int chaveCifra = scanner.nextInt();
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
                scanner.nextLine(); // Limpar o buffer

                System.out.println("Digite o texto que deseja descriptografar:");
                String textoCriptografado = scanner.nextLine();

                switch (dOption){
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

}