package GUI;

import Logic.runGame;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends JFrame {

    private JLabel jlOne, jlTwo, jlThree;
    private JButton btnOne, btnTwo, btnThree, btnAgain;

    private JLabel cash;

    private JLabel jlCash;
    public GUIGame() {

        setTitle("Reglas");
        setSize(480,240);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void begin(String text){

        beginComponents(text);
        addComponents();

    }

    private void beginComponents(String text) {

        jlOne = new JLabel();
        jlTwo = new JLabel();
        jlThree = new JLabel();

        btnOne = new JButton("STOP");
        btnTwo = new JButton("STOP");
        btnThree = new JButton("STOP");
        btnAgain = new JButton("VOLVER A JUGAR");

        cash = new JLabel("Dinero: "+text);

    }

    private void addComponents() {

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        cash.setBackground(Color.blue);
        panel.add(cash);

        this.add(panel, BorderLayout.NORTH);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2,3));

        jlOne.setHorizontalAlignment(SwingConstants.CENTER);
        jlTwo.setHorizontalAlignment(SwingConstants.CENTER);
        jlThree.setHorizontalAlignment(SwingConstants.CENTER);

        pnlCenter.add(jlOne);
        pnlCenter.add(jlTwo);
        pnlCenter.add(jlThree);

        pnlCenter.add(btnOne);
        pnlCenter.add(btnTwo);
        pnlCenter.add(btnThree);

        this.add(pnlCenter,BorderLayout.CENTER);

        this.add(btnAgain,BorderLayout.EAST);

        runGame run = new runGame();

        run.startGame(jlOne,jlTwo,jlThree,btnOne,btnTwo,btnThree,btnAgain,this,cash);
    }

}
