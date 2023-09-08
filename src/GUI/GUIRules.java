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


        String contenido = "Aca van todas las reglas jajajasjsjasj";

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