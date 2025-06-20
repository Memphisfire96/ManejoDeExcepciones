import javax.swing.*;
import java.awt.*;

public class Interfaz {

    JFrame ventana = new JFrame("Calculadora de figuras geométricas");
    //Creo un panel para agregar componentes
    JPanel panel = new JPanel();

    //textos
    JLabel baseTexto = new JLabel("Base: ");
    JLabel alturaTexto = new JLabel("Altura: ");
    JLabel resultadoTexto = new JLabel("Resultado: ");
    //campo de texto
    JTextField baseCampo = new JTextField(20);
    JTextField alturaCampo = new JTextField(20);

    //botón
    JButton boton = new JButton("Calcular área");

    public Interfaz(){
        ventana.setSize(300,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(0,2,10,10));

        //agrego componentes al panel
        panel.add(baseTexto);
        panel.add(baseCampo);
        panel.add(alturaTexto);
        panel.add(alturaCampo);
        panel.add(boton);
        panel.add(resultadoTexto);

        //agrego el panel a la ventana
        ventana.add(panel);
        //visible la ventana
        ventana.setVisible(true);

        //accion del boton

        boton.addActionListener(e -> {
            try {
                //convertimos de texto a numeros
                double base = Double.parseDouble(baseCampo.getText());
                double altura = Double.parseDouble(alturaCampo.getText());

                if (base <= 0 || altura <= 0) {
                    throw new IllegalArgumentException("El valor ingresado debe ser positivo");
                }

                double area = (base * altura) / 2;
                resultadoTexto.setText("Área: " + area);
            } catch (NumberFormatException ex) {
                resultadoTexto.setText("Error: Ingrese solo números.");
            } catch (Throwable t) {
                resultadoTexto.setText("Error desconocido" + t.getMessage());
            }
        });

    }

}
