package tp7p2;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {

    private static List<Empleado> empleados = new ArrayList<>();

    // Este método ya no es estático porque la lista 'empleados' es estática
    public static Boolean agregar(Empleado empleado) throws EnteroPositivoException {
        empleado.setLegajo(empleados.size() + 1); // Lanza EnteroPositivoException si el legajo es inválido
        return empleados.add(empleado);
    }

    public static Empleado mayorSueldo() throws CollectionVaciaException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException("No hay empleados.");
        }

        Empleado mayor = empleados.get(0);
        for (Empleado e : empleados) {
            if (e.getSueldo() > mayor.getSueldo()) {
                mayor = e;
            }
        }
        return mayor;
    }

    public static Double sueldoPromedio() throws CollectionVaciaException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException("No hay empleados.");
        }

        double totalSueldo = 0;
        for (Empleado e : empleados) {
            totalSueldo += e.getSueldo();
        }
        return totalSueldo / empleados.size();
    }

    public static void eliminar(String nombre) throws CollectionVaciaException, NoEncontradoException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException("No hay empleados.");
        }

        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equals(nombre)) {
                empleados.remove(i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            throw new NoEncontradoException("No se encontro el empleado.");
        }
    }
}