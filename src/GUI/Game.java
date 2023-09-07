package GUI;

import Logic.ThreadCount;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class Game extends JFrame {

    private JTextField txtOne;
    private JTextField txtTwo;
    private JTextField txtThree;
    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnThree;
    public Game() {

        setTitle("Reglas");
        setSize(480,240);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void begin(){

        beginComponents();

        addComponents();

    }

    private void beginComponents() {

        txtOne = new JTextField();
        txtTwo = new JTextField();
        txtThree = new JTextField();

        btnOne = new JButton("STOP");
        btnTwo = new JButton("STOP");
        btnThree = new JButton("STOP");
    }

    private void addComponents() {

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(2,3));

        pnlCenter.add(txtOne);
        pnlCenter.add(txtTwo);
        pnlCenter.add(txtThree);

        pnlCenter.add(btnOne);
        pnlCenter.add(btnTwo);
        pnlCenter.add(btnThree);

        this.add(pnlCenter,BorderLayout.CENTER);

        ThreadCount runOne = new ThreadCount(txtOne, true );
        ThreadCount runTwo = new ThreadCount(txtTwo, false );
        ThreadCount runThree = new ThreadCount(txtThree, true);

        Thread thOne = new Thread(runOne);
        Thread thTwo = new Thread(runTwo);
        Thread thThree = new Thread(runThree);

        thOne.start();
        thTwo.start();
        thThree.start();

        btnOne.addActionListener((e)->{
            runOne.stopThread();
        });
        btnTwo.addActionListener((e)->{
            runTwo.stopThread();
        });
        btnThree.addActionListener((e)->{
            runThree.stopThread();
        });
    }
}
