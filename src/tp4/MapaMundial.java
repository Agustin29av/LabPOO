package src.tp4;
import java.util.*;

public class MapaMundial {
    private Set<Continente> continentes;

    public MapaMundial(){
        continentes = new HashSet<>();
        inicializarDatos();
    }
    
    private void inicializarDatos(){
        //aca creo los continentes america etcetc no especifica separar america en sur central y norte, el q calla otorga
        Continente america = new Continente("America");
        Continente europa = new Continente("Europa");
        Continente asia = new Continente("Asia");
        Continente africa = new Continente("África");
        Continente oceania = new Continente("Oceanía");
        Continente antartida = new Continente("Antárida");

        // agrego los continentes al conjunto de continentes
        continentes.add(america);
        continentes.add(europa);
        continentes.add(asia);
        continentes.add(africa);
        continentes.add(oceania);
        continentes.add(antartida);

        // creo los paises 
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2800000);
        Pais uruguay = new Pais("Uruguay", "Montevideo", 176000);
        Pais brasil = new Pais("Brasil", "Brasilia", 8516000);
        Pais chile = new Pais("Chile", "Santiago", 756000);
        Pais paraguay = new Pais("Paraguay", "Asunción", 406000);
        Pais bolivia = new Pais("Bolivia", "La Paz", 1099000);
        Pais espana = new Pais("España", "Madrid", 505000); // escribo espana para que no se arme lio
        Pais francia = new Pais("Francia", "París", 643000);
        Pais italia = new Pais("Italia", "Roma", 301000);
        Pais portugal = new Pais("Portugal", "Lisboa", 92200);
   
        america.agregarPais(argentina);
        america.agregarPais(uruguay);
        america.agregarPais(brasil);
        america.agregarPais(chile);
        america.agregarPais(paraguay);
        america.agregarPais(bolivia);
        europa.agregarPais(espana);
        america.agregarPais(francia);
        america.agregarPais(italia);
        america.agregarPais(portugal);

        //algunas provincias de prueba
        argentina.agregarProvincia(new Provincia("Entre Ríos"));
        argentina.agregarProvincia(new Provincia("Santa Fe"));
        argentina.agregarProvincia(new Provincia("Córdoba"));
        argentina.agregarProvincia(new Provincia("Buenos Aires"));
        uruguay.agregarProvincia(new Provincia("Paysandú"));
        uruguay.agregarProvincia(new Provincia("Canelones"));
        uruguay.agregarProvincia(new Provincia("Montevideo"));
        brasil.agregarProvincia(new Provincia("Brasilia"));
        chile.agregarProvincia(new Provincia("Santiago"));
        paraguay.agregarProvincia(new Provincia("Asunción"));
        bolivia.agregarProvincia(new Provincia("La Paz"));
        espana.agregarProvincia(new Provincia("Madrid"));
    }
    // Get paises por continente 
    private Set<Pais> getPaises(String nombreContinente){
        for (Continente c : continentes){
            if (c.getNombre().equalsIgnoreCase(nombreContinente)){
                return c.getPaises();
            }
        }
        return new HashSet<>();
    }
    // Get provincias por pais
    private Set<Provincia> getProvincias(String nombrePais){
        for (Continente c : continentes){
            for (Pais p : c.getPaises()){
                if (p.getNombre().equalsIgnoreCase(nombrePais)){
                    return p.getProvincias();
                }
            }
        }
        return new HashSet<>();
    }
}
