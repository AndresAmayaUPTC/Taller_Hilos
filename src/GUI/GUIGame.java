package GUI;

import Logic.runGame;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends JFrame {

    private JLabel jlOne, jlTwo, jlThree;
    private JButton btnOne, btnTwo, btnThree, btnAgain, btnReturn;

    private JLabel cash, auxcash;

    private JLabel jlCash;
    public GUIGame() {

        setTitle("Traga Monedas");
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
        btnReturn = new JButton("VOLVER AL MENÚ");

        cash = new JLabel(text);
        auxcash = new JLabel("Dinero: ");

    }

    private void addComponents() {

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1,1));
        cash.setBackground(Color.blue);
        auxcash.setBackground(Color.blue);
        auxcash.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(auxcash);
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

        JPanel pnlEast = new JPanel();
        pnlEast.setLayout(new GridLayout(2,1));

        pnlEast.add(btnReturn);
        pnlEast.add(btnAgain);

        this.add(pnlEast,BorderLayout.EAST);

        runGame run = new runGame();

        run.startGame(jlOne,jlTwo,jlThree,btnOne,btnTwo,btnThree,btnAgain,this,cash,btnReturn);
    }

}
