package Logic;

import GUI.GUIBet;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class runGame{

    public runGame(){
    }

    public void startGame(JLabel jlOne, JLabel jlTwo, JLabel jlThree, JButton btnOne, JButton btnTwo, JButton btnThree, JButton btnFinish,JButton btnAgain, JFrame window) {

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

        btnFinish.addActionListener((e)->{
            if(!runThree.isState() && !runOne.isState() && !runTwo.isState()) {
                finishGame(runOne,runTwo,runThree,btnAgain,window);
            }
        });

    }
    private void finishGame(ThreadCount runOne, ThreadCount runTwo, ThreadCount runThree,JButton btnAgain, JFrame window) {

        if(runOne.getImage().equals(runTwo.getImage()) || runTwo.equals(runThree.getImage()) || runThree.equals(runOne.getImage())){

            if(runOne.getImage().equals(runTwo.getImage()) && runTwo.equals(runThree.getImage())){

                if(runOne.getImage().equals("/img/siete.png")){
                    System.out.println("Tres 7");
                }else{
                    System.out.println("Tres iguales");
                }

            }else{

                System.out.println("Dos Iguales");
            }
        }else{
            System.out.println("Ninguna");
        }

        btnAgain.addActionListener((e)->{

            window.dispose();
            new GUIBet();
        });

    }
}
