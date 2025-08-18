package tp3.exercise6;
import java.util.ArrayList;

public class gestionEmpleados {
    
    private ArrayList<Empleado> empleados;

    public gestionEmpleados(){
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(String nombre, double sueldo){
        empleados.add(new Empleado(nombre, sueldo));
    }
    
     // 3. Buscar el que más gana
        public Empleado obtenerMejorPago(){
            Empleado mejorPago = empleados.get(0);
            for(Empleado emp : empleados){
                if(emp.getSueldo()>mejorPago.getSueldo()){
                    mejorPago = emp;
                }
            }
            return mejorPago;
        }

        public double obtenerSueldoPromedio(){
            double totalSueldos = 0;
            for(Empleado emp:empleados){
                totalSueldos += emp.getSueldo();
            }
            return totalSueldos / empleados.size();
        }
        
}
