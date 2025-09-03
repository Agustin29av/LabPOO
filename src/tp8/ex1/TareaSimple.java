package tp8.ex1;

import java.util.concurrent.ThreadLocalRandom;


public class TareaSimple implements Runnable {
private final String nombre;


public TareaSimple(String nombre) {
this.nombre = nombre;
}


@Override
public void run() {
for (int i = 1; i <= 1000; i++) {
System.out.printf("[%s] %d%n", nombre, i);
try {
Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1001));
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
System.out.printf("[%s] Interrumpido%n", nombre);
return;
}
}
System.out.printf("[%s] HECHO!%n", nombre);
}
}