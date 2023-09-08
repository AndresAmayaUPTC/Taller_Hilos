package Logic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class runGame{

    public runGame(){
    }

    public void startGame(JLabel jlOne, JLabel jlTwo, JLabel jlThree, JButton btnOne, JButton btnTwo, JButton btnThree, JButton btnFinish) {

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
                finishGame(runOne,runTwo,runThree);
            }
        });

    }
    private void finishGame(ThreadCount runOne, ThreadCount runTwo, ThreadCount runThree) {

        System.out.println(runOne.getImage());

        System.out.println(runTwo.getImage());

        System.out.println(runThree.getImage());

    }
}
