package Logic;

import GUI.GUIBet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;

import javax.swing.*;

public class runGame{

    public runGame(){
    }

    public void startGame(JLabel jlOne, JLabel jlTwo, JLabel jlThree, JButton btnOne, JButton btnTwo, JButton btnThree,JButton btnAgain, JFrame window, JLabel cashUpdated) {

        ThreadCount runOne = new ThreadCount(jlOne);
        ThreadCount runTwo = new ThreadCount(jlTwo);
        ThreadCount runThree = new ThreadCount(jlThree);

        Thread thOne = new Thread(runOne);
        Thread thTwo = new Thread(runTwo);
        Thread thThree = new Thread(runThree);

        thOne.start();
        thTwo.start();
        thThree.start();

        btnOne.addActionListener((e)->{
            if(runOne.isState()) {
                runOne.stopThread();
            }
        });
        btnTwo.addActionListener((e)->{
            if(runTwo.isState()) {
                runTwo.stopThread();
            }
        });
        btnThree.addActionListener((e)->{
            if(runThree.isState()) {
                runThree.stopThread();
            }
        });

        new Thread(() ->{

            boolean state = true;

            while (state) {

                System.out.print("");
                if(!runThree.isState() && !runOne.isState() && !runTwo.isState()) {
                    System.out.print("");
                    state=false;
                    finishGame(runOne,runTwo,runThree,btnAgain,window,cashUpdated);
                }
            }
        }).start();

    }
    private void finishGame(ThreadCount runOne, ThreadCount runTwo, ThreadCount runThree,JButton btnAgain, JFrame window, JLabel cashUpdated) {

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        if(runOne.getImage().equals(runTwo.getImage()) || runTwo.getImage().equals(runThree.getImage()) || runThree.getImage().equals(runOne.getImage())){

            if(runOne.getImage().equals(runTwo.getImage()) && runTwo.getImage().equals(runThree.getImage())){

                if(runOne.getImage().equals("/img/siete.png")){

                    int newCash = Integer.parseInt(cashUpdated.getText()) * 3;
                    cashUpdated.setText(""+newCash);
                    JOptionPane.showMessageDialog(null,"Felicidades!! \n Has ganado "+newCash+" en tu apuesta");
                }else{

                    int newCash = Integer.parseInt(cashUpdated.getText()) * 2;
                    cashUpdated.setText(""+newCash);
                    JOptionPane.showMessageDialog(null,"Felicidades!! \n Has ganado "+newCash+" en tu apuesta");
                }

            }else{

                double newCash = Integer.parseInt(cashUpdated.getText()) * 0.5;
                cashUpdated.setText(""+newCash);
                JOptionPane.showMessageDialog(null,"CASI...! \n Has recuperado "+newCash +" de tu apuesta inicial");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Perdiste :( \n Has perdido lo apostado");
            System.out.println("Ninguna");
            int newCash = Integer.parseInt(cashUpdated.getText()) * 0;
            cashUpdated.setText(""+newCash);
        }

        save(cashUpdated,runOne,runTwo,runThree);

        btnAgain.addActionListener((e)->{

            window.dispose();
            new GUIBet();
        });

    }


   public void save(JLabel cashUpdated, ThreadCount runOne,ThreadCount runTwo, ThreadCount runThree ){

        System.out.println(runOne.getImage());
        System.out.println(runTwo.getImage());
        System.out.println(runThree.getImage());

        String cash = cashUpdated.getText().toString();

        Properties properties = new Properties();
        properties.setProperty("Imagen1",runOne.getImage() );
        properties.setProperty("Imagen2",runTwo.getImage() );
        properties.setProperty("Imagen3",runThree.getImage() );
        properties.setProperty("Profit",cash);

        try (OutputStream output = new FileOutputStream("History.properties")) {
            properties.store(output, "HISTORIAL");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
