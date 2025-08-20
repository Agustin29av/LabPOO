package tp4;
import java.util.HashSet;
import java.util.Set;

public class Continente {
    private String nombre;
    private Set<Pais> paises;

    public Continente(String nombre){
        this.nombre = nombre;
        this.paises = new HashSet<>(); // la caja vacia para paises
    }
    
    public void agregarPais(Pais pais){
        paises.add(pais); // agrego pais a la caja
    }

    public Set<Pais> getPaises(){
        return paises; // para consultar que paises tienen
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

// si algo no anda revisar si no edclare algo en private otravezzzzzzzzzzzzzzzzz
