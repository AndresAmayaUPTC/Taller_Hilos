package Logic;

import javax.swing.*;
import java.util.Random;

public class ThreadCount implements Runnable{

    private JLabel text;

    private boolean state;

    private String image;

    public ThreadCount(JLabel text) {
        this.text = text;
        state = true;
    }

    @Override
    public void run() {

        long tiempoInicio = System.currentTimeMillis();
        long tiempoLimite = tiempoInicio + 10000;

        String[] imagenes = {
                "/img/cereza.png",
                "/img/naranja.png",
                "/img/sandia.png",
                "/img/siete.png",
                "/img/uva.png"
        };

        while (System.currentTimeMillis() < tiempoLimite && state) {

            int a = new Random().nextInt(5);

            Icon myIcon = new ImageIcon(new ImageIcon(getClass().getResource(imagenes[a])).getImage().getScaledInstance(text.getWidth(),text.getHeight(),0));

            text.setIcon(myIcon);

            image = imagenes[a];

        }

        state = false;
        new runGame().finishThread(image);

    }
    public boolean isState() {
        return state;
    }

    public void stopThread(){

        state = false;
        new runGame().finishThread(image);
    }
}

