package Logic;

import GUI.GUIBet;
import GUI.MainWindow;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

import javax.swing.*;

public class runGame{
    private int i=0;
    public runGame(){
    }

    public void startGame(JLabel jlOne, JLabel jlTwo, JLabel jlThree, JButton btnOne, JButton btnTwo, JButton btnThree,JButton btnAgain, JFrame window, JLabel cashUpdated,JButton btnReturn) {

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
                    finishGame(runOne,runTwo,runThree,btnAgain,window,cashUpdated,btnReturn);
                }
            }
        }).start();

    }
    private void finishGame(ThreadCount runOne, ThreadCount runTwo, ThreadCount runThree,JButton btnAgain, JFrame window, JLabel cashUpdated,JButton btnReturn) {

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
            int newCash = Integer.parseInt(cashUpdated.getText()) * 0;
            cashUpdated.setText(""+newCash);
        }

        save(cashUpdated,runOne,runTwo,runThree);

        btnAgain.addActionListener((e)->{

            window.dispose();
            new GUIBet();
        });
        btnReturn.addActionListener((e)->{

            window.dispose();
            new MainWindow();
        });

    }


   public void save(JLabel cashUpdated, ThreadCount runOne,ThreadCount runTwo, ThreadCount runThree ){

        String cash = cashUpdated.getText().toString();

       String fileName = "History.txt";

       try (FileOutputStream fos = new FileOutputStream(fileName, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw)) {

           LocalDateTime fechaHoraActual = LocalDateTime.now();
           DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           String fechaHoraActualStr = fechaHoraActual.format(formato);

           String newData = fechaHoraActualStr+"\n \n"+"Imagen 1:"+runOne.getImage().replace("/img/", "").replace(".png", "")+"\n"+"Imagen 2:"+runTwo.getImage().replace("/img/", "").replace(".png", "")+"\n"+"Imagen 3:"+runThree.getImage().replace("/img/", "").replace(".png", "")+"\n"+"Ganancia: "+cash+"\n \n \n \n";

           writer.write(newData);

           System.out.println("Información agregada exitosamente.");

       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
