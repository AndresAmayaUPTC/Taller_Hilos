package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GUIRecord extends JFrame {
    private JTextArea textArea;
    private JButton btnBack;

    public GUIRecord() {

        setVisible(true);
        setTitle("Historial");
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


        String contenido = "";

        String filePath = "History.txt"; // Reemplaza con la ruta de tu archivo txt

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Procesa cada línea del archivo aquí
                contenido = contenido+"\n"+line;
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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