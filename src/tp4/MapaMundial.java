package src.tp4;
import java.util.*;

public class MapaMundial {
    private Set<Continente> continentes;
    private Map<String, Pais> paisesPorNombre;

    public MapaMundial(){
        continentes = new HashSet<>();
        paisesPorNombre = new HashMap<>();
        inicializarDatos();
        inicializarPaisesLimitrofes();
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
        Pais china = new Pais("China", "Pekín", 9597000);
        Pais india = new Pais("India", "Nueva Delhi", 3287000);
        Pais egipto = new Pais("Egipto", "El Cairo", 1010000);
        Pais nigeria = new Pais("Nigeria", "Abuya", 923000);
        Pais australia = new Pais("Australia", "Canberra", 7682000);
        Pais nuevaZelanda = new Pais("Nueva Zelanda", "Wellington", 270000);
   
        america.agregarPais(argentina);
        america.agregarPais(uruguay);
        america.agregarPais(brasil);
        america.agregarPais(chile);
        america.agregarPais(paraguay);
        america.agregarPais(bolivia);
        europa.agregarPais(espana);
        europa.agregarPais(francia);
        europa.agregarPais(italia);
        europa.agregarPais(portugal);
        asia.agregarPais(china);
        asia.agregarPais(india);
        africa.agregarPais(egipto);
        africa.agregarPais(nigeria);
        oceania.agregarPais(australia);
        oceania.agregarPais(nuevaZelanda);
        antartida.agregarPais(new Pais("Antártida", "No tiene", 14000000)); // Aunque no tenga habitantes ni provincia

        paisesPorNombre.put(argentina.getNombre().toLowerCase(), argentina);
        paisesPorNombre.put(uruguay.getNombre().toLowerCase(), uruguay);
        paisesPorNombre.put(brasil.getNombre().toLowerCase(), brasil);
        paisesPorNombre.put(chile.getNombre().toLowerCase(), chile);
        paisesPorNombre.put(paraguay.getNombre().toLowerCase(), paraguay);
        paisesPorNombre.put(bolivia.getNombre().toLowerCase(), bolivia);
        paisesPorNombre.put(espana.getNombre().toLowerCase(), espana);
        paisesPorNombre.put(francia.getNombre().toLowerCase(), francia);
        paisesPorNombre.put(italia.getNombre().toLowerCase(), italia);
        paisesPorNombre.put(portugal.getNombre().toLowerCase(), portugal);
        paisesPorNombre.put(china.getNombre().toLowerCase(), china);
        paisesPorNombre.put(india.getNombre().toLowerCase(), india);
        paisesPorNombre.put(egipto.getNombre().toLowerCase(), egipto);
        paisesPorNombre.put(nigeria.getNombre().toLowerCase(), nigeria);
        paisesPorNombre.put(australia.getNombre().toLowerCase(), australia);
        paisesPorNombre.put(nuevaZelanda.getNombre().toLowerCase(), nuevaZelanda);
        paisesPorNombre.put(antartida.getNombre().toLowerCase(), new Pais("Antartida", "No tiene", 14000000)); // Aunque no tenga habitantes ni provincia

        //algunas provincias de prueba
        argentina.agregarProvincia(new Provincia("Entre Ríos"));
        argentina.agregarProvincia(new Provincia("Santa Fe"));
        argentina.agregarProvincia(new Provincia("Córdoba"));
        argentina.agregarProvincia(new Provincia("Buenos Aires"));
        uruguay.agregarProvincia(new Provincia("Paysandú"));
        uruguay.agregarProvincia(new Provincia("Canelones"));
        uruguay.agregarProvincia(new Provincia("Montevideo"));
        brasil.agregarProvincia(new Provincia("Brasilia"));
        brasil.agregarProvincia(new Provincia("São Paulo"));
        chile.agregarProvincia(new Provincia("Santiago"));
        paraguay.agregarProvincia(new Provincia("Asunción"));
        paraguay.agregarProvincia(new Provincia("Central"));
        bolivia.agregarProvincia(new Provincia("La Paz"));
        espana.agregarProvincia(new Provincia("Madrid"));
        espana.agregarProvincia(new Provincia("Barcelona"));
        francia.agregarProvincia(new Provincia("Marsella"));
        italia.agregarProvincia(new Provincia("Milán"));
        portugal.agregarProvincia(new Provincia("Lisboa"));
        china.agregarProvincia(new Provincia("Shanghái"));
        india.agregarProvincia(new Provincia("Bombay"));
        egipto.agregarProvincia(new Provincia("Alejandría"));
        nigeria.agregarProvincia(new Provincia("Lagos"));
        australia.agregarProvincia(new Provincia("Sídney"));
        nuevaZelanda.agregarProvincia(new Provincia("Auckland"));
    }

    private void inicializarPaisesLimitrofes(){
        // defino los paises

        Pais argentina = buscarPaisPorNombre("Argentina");
        Pais uruguay = buscarPaisPorNombre("Uruguay");
        Pais brasil = buscarPaisPorNombre("Brasil");
        Pais chile = buscarPaisPorNombre("Chile");
        Pais paraguay = buscarPaisPorNombre("Paraguay");
        Pais bolivia = buscarPaisPorNombre("Bolivia");
        Pais espana = buscarPaisPorNombre("España");
        Pais francia = buscarPaisPorNombre("Francia");
        Pais italia = buscarPaisPorNombre("Italia");
        Pais portugal = buscarPaisPorNombre("Portugal");
        Pais china = buscarPaisPorNombre("China");
        Pais india = buscarPaisPorNombre("India");
        Pais egipto = buscarPaisPorNombre("Egipto");
        Pais nigeria = buscarPaisPorNombre("Nigeria");
        Pais australia = buscarPaisPorNombre("Australia");
        Pais nuevaZelanda = buscarPaisPorNombre("Nueva Zelanda");


        // ahora defino las relaciones de paises limitrofes
        // AMERICA !!!
        // ARGENTINA
        if (argentina != null) {
            argentina.agregarPaisesLimitrofes(brasil);
            argentina.agregarPaisesLimitrofes(uruguay);
            argentina.agregarPaisesLimitrofes(bolivia);
            argentina.agregarPaisesLimitrofes(chile);
            argentina.agregarPaisesLimitrofes(paraguay);
        }
        //BRASIL 
        if(brasil != null) {
            brasil.agregarPaisesLimitrofes(argentina);
            brasil.agregarPaisesLimitrofes(bolivia);
            brasil.agregarPaisesLimitrofes(paraguay);
            brasil.agregarPaisesLimitrofes(uruguay);
        }
        // URUGUAY 
        if (uruguay != null) {
            uruguay.agregarPaisesLimitrofes(argentina);
            uruguay.agregarPaisesLimitrofes(brasil);
        }
        // PARAGUAY
        if (paraguay != null) {
            paraguay.agregarPaisesLimitrofes(argentina);
            paraguay.agregarPaisesLimitrofes(bolivia);
            paraguay.agregarPaisesLimitrofes(brasil);
        }
        // BOLIVIA
        if (bolivia != null) {
            bolivia.agregarPaisesLimitrofes(argentina);
            bolivia.agregarPaisesLimitrofes(paraguay);
            bolivia.agregarPaisesLimitrofes(brasil);
        }
        // CHILE 
        if (chile != null) {
            chile.agregarPaisesLimitrofes(argentina);
            chile.agregarPaisesLimitrofes(bolivia);
        }
        // EUROPA !!!
        // ESPAÑA
        if (espana != null) {
            espana.agregarPaisesLimitrofes(francia);
            espana.agregarPaisesLimitrofes(portugal);
        }
        // FRANCIA
        if (francia != null) {
            francia.agregarPaisesLimitrofes(espana);
            francia.agregarPaisesLimitrofes(italia);
        }
        // ITALIA
        if (italia != null) {
            italia.agregarPaisesLimitrofes(francia);
        }
        // PORTUGAL
        if (portugal != null) {
            portugal.agregarPaisesLimitrofes(espana);
        }
        // ASIA !!!
        // CHINA
        if (china != null) {
            china.agregarPaisesLimitrofes(india);
        }
        // INDIA
        if (india != null) {
            india.agregarPaisesLimitrofes(china);
        }
        // LOS QUE SIGUEN NO LIMITAN CON NINGUNO DE MI LISTA, POR LO QUE NO LOS PONGO
       
    }
    // Get paises por continente 
    public Set<Pais> getPaises(String nombreContinente){
        for (Continente c : continentes){
            if (c.getNombre().equalsIgnoreCase(nombreContinente)){
                return c.getPaises();
            }
        }
        return new HashSet<>(); // devuelvo un conjunto vacio de paises para evitar que retorne null
    }
    // Get provincias por pais
    public Set<Provincia> getProvincias(String nombrePais){
        for (Continente c : continentes){
            for (Pais p : c.getPaises()){
                if (p.getNombre().equalsIgnoreCase(nombrePais)){
                    return p.getProvincias();
                }
            }
        }
        return new HashSet<>();
    }

    public Set<Pais> getTodolosPaises() {
        Set<Pais> todosLosPaises = new HashSet<>();
        for (Continente continente : continentes) {
            todosLosPaises.addAll(continente.getPaises());
        }
        return todosLosPaises;
    }

    public Pais buscarPaisPorNombre(String nombrePais) {
        return paisesPorNombre.get(nombrePais.toLowerCase());
    }
    
}

