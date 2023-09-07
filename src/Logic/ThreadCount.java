package Logic;

import javax.swing.*;
import java.util.Random;

public class ThreadCount implements Runnable{

    private JTextField text;

    private boolean state;

    private boolean sw;

    public ThreadCount(JTextField text, boolean sw) {
        this.text = text;
        this.sw = sw;
        state = true;
    }

    @Override
    public void run() {

        if (sw){
            for (var i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE && state; i++) {

                text.setText(""+i);

                try{
                    Thread.sleep(new Random().nextInt(200));
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        }else{

            for (var i = Integer.MAX_VALUE; i >= Integer.MIN_VALUE && state ; i--) {

                text.setText(""+i);

                try{
                    Thread.sleep(new Random().nextInt(200));
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }

        }

    }

    public void stopThread(){
        state = false;
    }
}

