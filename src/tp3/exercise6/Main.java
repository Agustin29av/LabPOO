package tp3.exercise6;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gestionEmpleados gestion = new gestionEmpleados();

        System.out.print("¿Cuántos empleados vas a cargar? ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpia buffer

        // Carga de empleados
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre del empleado " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Sueldo de " + nombre + ": ");
            double sueldo = scanner.nextDouble();
            scanner.nextLine(); // Limpia buffer

            gestion.agregarEmpleado(nombre, sueldo);
        }


        Empleado mejorPago = gestion.obtenerMejorPago();
        double sueldoPromedio = gestion.obtenerSueldoPromedio();

        // Mostrar resultados:
        
        System.out.println("\nEmpleado que más gana:");
        System.out.println(mejorPago.getNombre() + " - $" + mejorPago.getSueldo());

        System.out.println("\nSueldo promedio: $" + sueldoPromedio);
        scanner.close();
}
}