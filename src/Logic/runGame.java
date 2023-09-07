package Logic;

import javax.swing.*;
import java.util.ArrayList;

public class runGame{

    private ArrayList<String> imagenes = new ArrayList<>();

    public runGame(){
    }

    public void startGame(JLabel jlOne, JLabel jlTwo, JLabel jlThree, JButton btnOne, JButton btnTwo, JButton btnThree) {

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
    public void finishThread(String image) {

        imagenes.add(image);

    }

    public void finishGame() {

    }
}
