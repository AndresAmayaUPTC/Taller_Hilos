package Logic;

import javax.swing.*;
import java.awt.*;

public class runGame{

    public runGame(){
    }

    public runGame(JLabel jlOne, JLabel jlTwo, JLabel jlThree, JButton btnOne, JButton btnTwo, JButton btnThree) {

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
