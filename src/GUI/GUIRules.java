package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIRules extends JFrame {
    private JTextArea textArea;
    private JButton btnBack;

    public GUIRules() {

        setVisible(true);
        setTitle("Reglas");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        begin();
    }

    public void begin() {
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        textArea = new JTextArea();
        btnBack=new JButton("VOLVER");
    }

    private void addComponents() {

        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);


        JScrollPane scrollPane = new JScrollPane(textArea);


        String contenido = "Reglas:\n" +
                "\n" +
                "El juego consiste en una maquina paga monedas, en pantalla se cambiaran tres imagenes de forma aleatorio, despues de un tiempo o hacerlo manualmente con los botones" +
                "se detendran, dependiendo de las imagenes que queden se daran los siguientes resultados:\n" +
                "\n" +
                "\n" +
                "1.Tres imagenes iguales: En este caso se devolvera el doble de lo apostado, a menos que las tres imagenes sean el 7, en cuyo caso se devolvera el triple de lo apostado\n" +
                "\n" +
                "2.Dos imagenes iguales: Si se tienen dos imagenes iguales se devolvera la mitad de lo apostado\n" +
                "\n" +
                "3.Por ultimo si no coinciden ninguna de las imagenes se perdera el dinero apostado";

        textArea.setText(contenido);
        setLocationRelativeTo(null);

        revalidate();

        this.add(scrollPane, BorderLayout.CENTER);


        this.add(btnBack,BorderLayout.SOUTH);

        btnBack.addActionListener((e) -> {
            new MainWindow();
            dispose();
        });
    }


}