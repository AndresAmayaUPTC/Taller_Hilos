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
                    System.out.println("Tres 7");
                }else{
                    System.out.println("Tres iguales");
                    JOptionPane.showMessageDialog(null,"Felicidades!! \n Has duplicado Tu apuesta");
                }

            }else{

                System.out.println("Dos Iguales");
                JOptionPane.showMessageDialog(null,"CASI...! \n Has recuperado la mitad de tu apuesta");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Perdiste :( \n Has perdido lo apostado");
            System.out.println("Ninguna");
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
