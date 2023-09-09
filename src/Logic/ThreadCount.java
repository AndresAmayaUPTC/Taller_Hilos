package Logic;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
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
        long tiempoLimite = tiempoInicio + 8000;

        String[] imagenes = {
                "/img/cereza.png",
                "/img/naranja.png",
                "/img/sandia.png",
                "/img/siete.png",
                "/img/uva.png"
        };

        while (System.currentTimeMillis() < tiempoLimite && state) {

            try{
                Thread.sleep(100);

                int a = new Random().nextInt(5);

                ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagenes[a])));

                text.setSize(100,70);

                Icon myIcon = new ImageIcon(img.getImage().getScaledInstance(text.getWidth(),text.getHeight(),0));

                text.setIcon(myIcon);

                image = imagenes[a];
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }

        tiempoLimite = tiempoInicio + 13000;

        while (System.currentTimeMillis() < tiempoLimite && state) {

            try{
                Thread.sleep(350);

                int a = new Random().nextInt(5);

                ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagenes[a])));

                text.setSize(100,70);

                Icon myIcon = new ImageIcon(img.getImage().getScaledInstance(text.getWidth(),text.getHeight(),0));

                text.setIcon(myIcon);

                image = imagenes[a];
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }

        tiempoLimite = tiempoInicio + 15000;

        while (System.currentTimeMillis() < tiempoLimite && state) {

            try{
                Thread.sleep(600);
                int a = new Random().nextInt(5);

                ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagenes[a])));

                text.setSize(100,70);

                Icon myIcon = new ImageIcon(img.getImage().getScaledInstance(text.getWidth(),text.getHeight(),0));

                text.setIcon(myIcon);

                image = imagenes[a];
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }

        stopThread();

    }
    public boolean isState() {
        return state;
    }

    public String getImage() {
        return image;
    }

    public void stopThread(){

        state = false;
    }
}

