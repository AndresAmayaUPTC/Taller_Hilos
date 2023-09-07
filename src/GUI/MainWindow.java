package GUI;

import Logic.ThreadCount;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class MainWindow extends JFrame {

    private JTextField txtOne;
    private JTextField txtTwo;
    private JTextField txtThree;
    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnThree;
    public MainWindow() {

        setTitle("Ejemplo de Hilos");
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

        JLabel hour = new JLabel();

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        panel.add(hour);

        this.add(panel, BorderLayout.NORTH);

        new Thread(() ->{
            while (true){
                LocalTime time = LocalTime.now();

                hour.setText(time.getHour()+" : "+time.getMinute()+" : "+time.getSecond());

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }).start();

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
