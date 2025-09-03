package tp8.ex1;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadSimple extends Thread{

    public ThreadSimple(String name){
        super(name); // el trhead maneja el nombre 
    }

    @Override
    public void run(){ // este run yo lo heredo de Thread
        for (int i = 0; i < 10; i++){
            System.out.println(getName());
            try{
                // Genera un intervalo aleatorio entre 0 y 1000 milisegundos (0 y 1 seg)
                long sleepTime = ThreadLocalRandom.current().nextInt(0,1001);
                Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                // re marcar y salir, esto es una buena practica nomas
                Thread.currentThread().interrupt();
                System.out.println("interrumpido: " + getName());
                return;
            }
        }
        System.out.println("Ya esta maestro! - " + getName());
    }
}
