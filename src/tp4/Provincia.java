package tp4;

public class Provincia {
    private String nombre;

    public Provincia(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){ // esto por si tenemos que cambiar el nombre ed la provincia dsp
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre; // Esto es para q cuando lo llamo no me tire el nombre del archivo si no la variable
    }
}