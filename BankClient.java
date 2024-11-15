import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado ao servidor bancário.");

            System.out.print("Digite o número da conta: ");
            String numeroConta = scanner.nextLine();

            System.out.print("Digite a operação (deposito/saque): ");
            String operacao = scanner.nextLine();

            System.out.print("Digite o valor: ");
            String valor = scanner.nextLine();

            String requisicao = numeroConta + "," + operacao + "," + valor;
            out.println(requisicao);

            String resposta = in.readLine();
            System.out.println("Resposta do servidor: " + resposta);
        } catch (IOException e) {
            System.err.println("Erro no cliente: " + e.getMessage());
        }
    }
}
