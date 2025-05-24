package src.tp4;
import java.util.Scanner;
import java.util.Set;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MapaMundiController {
    private MapaMundial mapaMundial;
    private Scanner scanner;

    public MapaMundiController() {
        this.mapaMundial = new MapaMundial();
        this.scanner = new Scanner(System.in);
    }


public void iniciar(){
    int opcion;
    do{
       mostrarMenu();
       System.out.println("Ingrese una opción: ");
       opcion = scanner.nextInt();
       scanner.nextLine(); //consume la nueva linea despues de leer el entero

       switch (opcion) {
        case 1: 
            listaPaisesPorContinente();
            break;

        case 2:
            listaProvinciasPorPais();
            break;
        case 3:
            listaPaisesOrdenadosPorSuperficie();
            break;
        case 4:
            comparaPaisesPorSuperficie();
            break;
        case 5:
            listarPaisesLimitrofes();
            break;    
        case 0:
            System.out.println("Hastas Luego!");
            break;
        default:
            System.out.println("Opción inválida. Intente nuevamente.");
            break;
       }
       System.out.println(); // linea en blanco para separar las interacciones
       if (opcion != 0) {
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine(); // Espera a que el usuario presione Enter
        }   
    } while (opcion != 0);
    scanner.close();
}

    private void mostrarMenu() {
        System.out.println("--- Menu del Mapa Mundial ---");
        System.out.println("1. Listar países por continente");
        System.out.println("2. Listar provincias de un país");
        System.out.println("3. Listar países ordenados por superficie");
        System.out.println("4. Comparar 2 países por superficie");
        System.out.println("5. Listar países limítrofes de un país");
        System.out.println("0. Salir");
    }


private void listaPaisesPorContinente() {
    System.out.println("Ingrese el nombre del continente: ");
    String nombreContinente = scanner.nextLine();
    Set<Pais> paises = mapaMundial.getPaises(nombreContinente);

    if(!paises.isEmpty()){
        System.out.println("Paises en " + nombreContinente + ":");
        for (Pais pais : paises){
            System.out.println("- " + pais);
        }
    }else{
        System.out.println("No se encontraron paises en el continente " + nombreContinente);
    }
}

private void listaProvinciasPorPais() {
    System.out.println("Ingrese el nombre del país: ");
    String nombrePais = scanner.nextLine();
    Set<Provincia> provincias = mapaMundial.getProvincias(nombrePais);

    if(!provincias.isEmpty()){
        System.out.println("Provincias en " + nombrePais + ":");
        for (Provincia provincia : provincias){
            System.out.println("- " + provincia);
        }
    }else{
        System.out.println("No se encontraron provincias en el pais " + nombrePais);
    }
}
private void listaPaisesOrdenadosPorSuperficie() {
        Set<Pais> paisesSet = mapaMundial.getTodolosPaises();
        List<Pais> paisesList = new ArrayList<>(paisesSet);

        // aca para ordenarlo uso Comparator para deicrle como ordenar
        // pais1.getSuperficie() - pais2.getSuperficie() ordenará de menor a mayor superficie <<< asi labura el comparator
        // si la superficie de pais1 es menor que la de pais2, devuelve un valor negativo, lo que indica que pais1 debe ir antes que pais2 en el orden
        // si la superficie de pais1 es mayor que la de pais2, devuelve un valor positivo, lo que indica que pais1 debe ir después de pais2 en el orden
        // si son iguales devuelve 0, lo que indica que no hay cambio de orden entre ellos
        Collections.sort(paisesList, new Comparator<Pais> (){
            @Override
            public int compare(Pais pais1, Pais pais2) {
                return Double.compare(pais1.getSuperficie(), pais2.getSuperficie());
            }
        });
        if (!paisesList.isEmpty()) {
            System.out.println("Paises Ordenados por superficie: ( de menor a mayor ) ");
            for (Pais pais : paisesList){
                // toString() de País ya me daria el nombre, pero para ver la superficie también
                System.out.printf("- %s (Superficie: %.2f km²)", pais.getNombre(), pais.getSuperficie());
                System.out.println();
            }
        }else {
            System.out.println("No hay paises cargados en el mapa para ordenar.");
        }
    }

    private void comparaPaisesPorSuperficie() {
        System.out.println("Ingrese el nombre del primer pais: ");
        String nombrePais1 = scanner.nextLine();
        System.out.println("Ingrese el nombre del segundo pais: ");
        String nombrePais2 = scanner.nextLine();

        Pais pais1 = mapaMundial.buscarPaisPorNombre(nombrePais1);
        Pais pais2 = mapaMundial.buscarPaisPorNombre(nombrePais2);

        if (pais1 != null && pais2 != null){
            System.out.println("Ambos paises fueron encontrados, calculando..");
            if (pais1.getSuperficie() > pais2.getSuperficie()){
                System.out.println("\n" + pais1.getNombre() + " es mas grande que " + pais2.getNombre());
            }else if (pais2.getSuperficie() > pais1.getSuperficie()){
                System.out.println("\n" + pais2.getNombre() + " es mas grande que " + pais1.getNombre());
            } else{
                System.out.println("\n" + pais1.getNombre() + " y " + pais2.getNombre() + "tienen la misma superficie");
            }
        }else {
        System.out.println("Uno o ambos paises no fueron encontrados.");
        }
        }

        private void listarPaisesLimitrofes() { 
            System.out.println("Ingrese el nombre del pais para ver sus limitrofes: ");
            String nombrePais = scanner.nextLine();
            Pais pais = mapaMundial.buscarPaisPorNombre(nombrePais);
            if(pais != null){
                Set<Pais> limitrofes = pais.getPaisesLimitrofes(); // obtengo los limitrofes de mi objeto pais
                if (!limitrofes.isEmpty()){
                    System.out.println(pais.getNombre() + " tiene los siguientes limitrofes: ");
                    for (Pais limitrofe : limitrofes) { 
                        System.out.println("- " + limitrofe.getNombre());
                    }
            } else {
                    System.out.println("El pais " + pais.getNombre() + " no tiene paises limitrofes registrados en esta lista.");
                    }
            }
        }

    



    public static void main(String[] args) {
        MapaMundiController controller = new MapaMundiController();
        controller.iniciar();
    }
}