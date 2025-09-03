package tp8.ex1;

public class ThreadSimpleTest {
    public static void main(String[] args){
        ThreadSimple thread1 = new ThreadSimple("Thread 1");
        ThreadSimple thread2 = new ThreadSimple("Thread 2");
    
        //los llamo

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main interrumpido mientras esperaba los hilos");
        }

        System.out.println("Thread principal finalizo lanzado de hilos");
    }
}
