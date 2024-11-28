package Sockets;
import java.io.*;
import java.net.*;

public class SocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor aguardando conexões...");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                double x = input.readDouble();
                double y = input.readDouble();

                double r = Math.sqrt(x * x + y * y);
                double theta = Math.atan2(y, x);

                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeDouble(r);
                output.writeDouble(theta);

                System.out.println("Conversão enviada para o cliente.");
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
