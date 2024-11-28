package Sockets;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {

            String xInput = JOptionPane.showInputDialog("Digite o valor de X:");
            String yInput = JOptionPane.showInputDialog("Digite o valor de Y:");
            double x = Double.parseDouble(xInput);
            double y = Double.parseDouble(yInput);


            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeDouble(x);
            output.writeDouble(y);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            double r = input.readDouble();
            double theta = input.readDouble();

            JOptionPane.showMessageDialog(null, 
                String.format("Coordenadas Polares:\nr = %.2f\n θ = %.2f rad", r, theta));

        } catch (IOException e) {
            System.err.println("Erro no cliente: " + e.getMessage());
        }
    }
}
