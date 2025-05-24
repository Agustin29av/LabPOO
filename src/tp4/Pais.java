package src.tp4;

import java.util.HashSet;
import java.util.Set;

public class Pais {
    private String nombre;
    private String capital;
    private double superficie;
    private Set<Provincia> provincias;
    private Set<Pais> paisesLimitrofes; // RELACION DE ASOCIACION, un pais tiene una colecion de paises limitrofes 

    public Pais(String nombre, String capital, double superficie){
        this.nombre = nombre;
        this.capital = capital;
        this.superficie = superficie;
        this.provincias = new HashSet<>(); // cuando creo un pais creo un hashset osea una caja vacia donde voy a guardar la provincia dsp
        this.paisesLimitrofes = new HashSet<>(); // inicializo la coleccion de paises limitrofes
    }


    public void agregarProvincia(Provincia provincia){ // relacion de composicion, una clase contiene a otra entonces le doy una funcion que permita agregarle elementos al hijo
        provincias.add(provincia);
    }

    public Set<Provincia> getProvincias(){
        return provincias;
    }

    public void agregarPaisesLimitrofes(Pais pais){
        if (pais != null && !this.equals(pais)) { // para que no se agregue a si mismo y un null, osea, argentina no puede ser limitrofe de argentina basicamente}
            this.paisesLimitrofes.add(pais);
        }
    }
    public Set<Pais> getPaisesLimitrofes(){
        return paisesLimitrofes;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getCapital(){
        return capital; 
    }
    
    public double getSuperficie(){
        return superficie;
    }
    @Override
    public String toString() {
        return nombre;
    }


    // aca le voy a decir por ejemplo que argentina es argentina, osea, argentina1 cordoba, argentina 2buenos aires, es la misma argentina que me la labure como la misma argentina
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // si son el mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // si el objeto es null o no es de la misma clase
        Pais pais = (Pais) obj; // casteo el objeto a pais
        return nombre.equalsIgnoreCase(pais.nombre); // comparo los nombres de los paises, ignore case para que no me importe si es mayuscula o minuscula
    }

    //decirle a Java cómo determinar si dos objetos Pais son "iguales". Por defecto, equals solo compara si son el mismo objeto en memoria. Al sobreescribirlos, le decimos que dos Pais son iguales si tienen el mismo nombre (ignorando mayúsculas/minúsculas). Esto es crucial para que Set funcione bien y para buscarPaisPorNombre también.

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode(); // devuelvo el hashcode del nombre en minuscula
    }

}
