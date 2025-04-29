package src.tp4;

import java.util.HashSet;
import java.util.Set;

public class Pais {
    private String nombre;
    private String capital;
    private double superficie;
    private Set<Provincia> provincias;

    public Pais(String nombre, String capital, double superficie){
        this.nombre = nombre;
        this.capital = capital;
        this.superficie = superficie;
        this.provincias = new HashSet<>(); // cuando creo un pais creo un hashset osea una caja vacia donde voy a guardar la provincia dsp
    }

<<<<<<< HEAD
    public void agregarProvincia(Provincia provincia){ // relacion de composicion, una clase contiene a otra entonces le doy una funcion que permita agregarle elementos al hijo
=======
    public void agregarProvincia(Provincia provincia){
>>>>>>> b7fb9ccdc91afdc6f86b49d7dd7526e2c54fa780
        provincias.add(provincia);
    }

    public Set<Provincia> getProvincias(){
        return provincias;
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
}
