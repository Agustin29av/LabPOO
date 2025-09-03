package tp8.ex1;

public class RunnableTest {
public static void main(String[] args) throws InterruptedException {
Thread a = new Thread(new TareaSimple("Asado"));
Thread b = new Thread(new TareaSimple("Chimichurri"));


a.start();
b.start();


a.join();
b.join();
System.out.println("Listo el pollo.");
}
}