import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class geraSenha {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao gerador de senhas!");
        System.out.println("Quantos dígitos você deseja que a senha tenha?");
        int numDigits = scanner.nextInt();

        scanner.nextInt();
        
        System.out.println("Para qual rede social ou serviço essa senha será usada?");
        String service = scanner.nextLine();

        String password = generatePassword(numDigits);
        System.out.println("A senha gerada para " + service + " é: " + password);

        try (PrintWriter writer = new PrintWriter(new FileWriter("senhas.txt", true))) {
            writer.println(service + ": " + password);
            System.out.println("Senha salva com sucesso no arquivo 'senhas.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar senha no arquivo 'senhas.txt': " + e.getMessage());
        }
        scanner.close();
    }

    private static String generatePassword(int numDigits) {
        StringBuilder sb = new StringBuilder(numDigits);
        Random random = new Random();

        for (int i = 0; i < numDigits; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            sb.append(ALPHA_NUMERIC_STRING.charAt(index));
        }

        return sb.toString();
    }
}

