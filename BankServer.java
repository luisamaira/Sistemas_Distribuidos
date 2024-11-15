import java.io.*;
import java.net.*;
import java.util.*;

public class BankServer {
    private static final String ARQUIVO_CONTAS = "contas.txt";
    private static Map<String, Double> contas = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor bancário está em execução...");
            carregarContas();

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String requisicao = in.readLine();
                    String resposta = processarRequisicao(requisicao);
                    out.println(resposta);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

    private static void carregarContas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CONTAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                contas.put(partes[0], Double.parseDouble(partes[1]));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar contas: " + e.getMessage());
        }
    }

    private static void salvarContas() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_CONTAS))) {
            for (Map.Entry<String, Double> entry : contas.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar contas: " + e.getMessage());
        }
    }

    private static String processarRequisicao(String requisicao) {
        String[] partes = requisicao.split(",");
        if (partes.length != 3) {
            return "Formato de requisicao inválido.";
        }

        String numeroConta = partes[0];
        String operacao = partes[1];
        double valor;

        try {
            valor = Double.parseDouble(partes[2]);
        } catch (NumberFormatException e) {
            return "Valor inválido.";
        }

        if (!contas.containsKey(numeroConta)) {
            return "Conta não encontrada.";
        }

        double saldoAtual = contas.get(numeroConta);

        if (operacao.equalsIgnoreCase("deposito")) {
            saldoAtual += valor;
            contas.put(numeroConta, saldoAtual);
            salvarContas();
            return "Depósito realizado com sucesso. Novo saldo: " + saldoAtual;
        } else if (operacao.equalsIgnoreCase("saque")) {
            if (saldoAtual < valor) {
                return "Saldo insuficiente.";
            }
            saldoAtual -= valor;
            contas.put(numeroConta, saldoAtual);
            salvarContas();
            return "Saque realizado com sucesso. Novo saldo: " + saldoAtual;
        } else {
            return "Operação inválida.";
        }
    }
}
