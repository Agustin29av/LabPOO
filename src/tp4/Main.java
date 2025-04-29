package src.tp4;

public class Main {
    public static void main(String[] args) {
        Continente america = new Continente("America");
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2780000);
        Provincia er = new Provincia("Entre Ríos");
        america.agregarPais(argentina);
        argentina.agregarProvincia(er);

        System.out.println("Continente: " + america);
        System.out.println("Pais: " + america.getPaises());
        System.out.println("Provincias: " + argentina.getProvincias());
    }
}