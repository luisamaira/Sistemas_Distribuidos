package RMI;
import javax.swing.*;

import java.rmi.*;

public class RmiClient {
    public static void main(String[] args) {
        try {
            PolarConverter converter = (PolarConverter) Naming.lookup("rmi://localhost/PolarConverter");

            String xInput = JOptionPane.showInputDialog("Digite o valor de X: ");
            String yInput = JOptionPane.showInputDialog("Digite o valor de Y: ");
            double x = Double.parseDouble(xInput);
            double y = Double.parseDouble(yInput);

            double[] polar = converter.convertToPolar(x, y);

            JOptionPane.showMessageDialog(null, 
                String.format("Coordenadas Polares:\nr = %.2f\n θ = %.2f rad", polar[0], polar[1]));

        } catch (Exception e) {
            System.err.println("Erro no cliente RMI: " + e.getMessage());
        }
    }
}

