package tp7p2;

public abstract class app {
    public class App {
    public static void main(String[] args) {

        System.out.println("--- Prueba 1: Crear Empleado con nombre inválido ---");
        try {
            Empleado empleado1 = new Empleado("A", 50000);
        } catch (StringException | EnteroPositivoException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("---------------------------------------------------\n");

        System.out.println("--- Prueba 2: Crear Empleado con sueldo inválido ---");
        try {
            Empleado empleado2 = new Empleado("Ana", -100);
        } catch (StringException | EnteroPositivoException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("---------------------------------------------------\n");

        System.out.println("--- Prueba 3: Escenario de éxito (happy path) ---");
        try {
            Empleado empleado3 = new Empleado("Carlos", 75000);
            Empleado empleado4 = new Empleado("Maria", 90000);
            
            EmpleadoService.agregar(empleado3);
            EmpleadoService.agregar(empleado4);

            System.out.println("Empleado agregado: " + empleado3);
            System.out.println("Empleado agregado: " + empleado4);
            System.out.println("Empleado con mayor sueldo: " + EmpleadoService.mayorSueldo().getNombre());
            System.out.println("Sueldo promedio: " + EmpleadoService.sueldoPromedio());
            
        } catch (StringException | EnteroPositivoException | CollectionVaciaException e) {
            System.out.println("Se capturó una excepción inesperada: " + e);
        }
        System.out.println("---------------------------------------------------\n");
        
        System.out.println("--- Prueba 4: Eliminar un empleado no existente ---");
        try {
            EmpleadoService.eliminar("Pedro");
        } catch (CollectionVaciaException | NoEncontradoException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("---------------------------------------------------\n");
        
        System.out.println("--- Prueba 5: Eliminar un empleado de la lista ---");
        try {
            EmpleadoService.eliminar("Carlos");
            System.out.println("Empleado Carlos eliminado con éxito.");
            System.out.println("Sueldo promedio después de eliminar: " + EmpleadoService.sueldoPromedio());
        } catch (CollectionVaciaException | NoEncontradoException e) {
            System.out.println("Se capturó una excepción inesperada: " + e);
        }
        System.out.println("---------------------------------------------------\n");
    }
}
}
