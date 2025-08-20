package tp7;

class App {
    public static void main(String args[]){
        // Parte C: Actualización de las pruebas para los nuevos casos de error.

        // Prueba 1: Intentar crear una matriz con dimensiones inválidas (negativas).
        System.out.println("--- Prueba 1: Creación de matriz con dimensiones negativas ---");
        try {
            MatrizObjetos ma1 = new MatrizObjetos(-10, 5);
        } catch(MatrizException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("----------------------------------------------------------------\n");

        // Prueba 2: Intentar crear una matriz que excede las dimensiones máximas.
        System.out.println("--- Prueba 2: Creación de matriz con dimensiones excedidas ---");
        try {
            MatrizObjetos ma2 = new MatrizObjetos(402, 2);
        } catch(MatrizException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("----------------------------------------------------------------\n");

        // Prueba 3: Usar una matriz válida e intentar acceder a un índice de fila incorrecto.
        System.out.println("--- Prueba 3: Intentar usar SetRowCol con índice de fila incorrecto ---");
        try {
            MatrizObjetos ma3 = new MatrizObjetos(5, 5);
            String st1 = new String(" esto es un String ");
            ma3.SetRowCol(10, 0, st1); // Índice de fila fuera de rango (0-4)
        } catch(MatrizException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("----------------------------------------------------------------\n");

        // Prueba 4: Usar una matriz válida e intentar acceder a un índice de columna incorrecto.
        System.out.println("--- Prueba 4: Intentar usar GetRowCol con índice de columna incorrecto ---");
        try {
            MatrizObjetos ma4 = new MatrizObjetos(5, 5);
            String st1 = new String("Hola");
            ma4.SetRowCol(0, 0, st1);
            System.out.println(ma4.GetRowCol(0, 10)); // Índice de columna fuera de rango (0-4)
        } catch(MatrizException e) {
            System.out.println("Se capturó la excepción esperada: " + e);
        }
        System.out.println("----------------------------------------------------------------\n");

        // Prueba 5: Escenario del "camino feliz" para verificar que el código sigue funcionando.
        System.out.println("--- Prueba 5: Escenario de éxito (happy path) ---");
        try {
            MatrizObjetos ma5 = new MatrizObjetos(4, 2);
            String st1 = new String(" esto es un String ");
            Integer entero = new Integer(10);
            ma5.SetRowCol(0, 0, st1);
            ma5.SetRowCol(1, 0, entero);
            System.out.println("Objeto en (0,0): " + ma5.GetRowCol(0,0));
            System.out.println("Contenido de la matriz: " + ma5);
        } catch(MatrizException e) {
            System.out.println("Se capturó una excepción inesperada: " + e);
        }
        System.out.println("----------------------------------------------------------------\n");
    }
}