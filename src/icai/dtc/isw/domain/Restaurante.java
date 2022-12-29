package icai.dtc.isw.domain;

import java.util.Arrays;
import java.util.List;

public  class Restaurante {

    private String nombre;
    /*enum TIPOS{
         PIZZA, ASIATICA, BURGUER, ESPANOLA, ITALIAN, CASA, VASCO, ITALIANO, ALTACOCINA
     }*/
    //  public static final int size = TIPOS.values().length;
    public static String [] tiposrestaurante= { "PIZZA", "ASIATICA", "BURGUER", "ESPANOLA", "ITALIAN", "CASA", "VASCO", "ITALIANO", "ALTACOCINA"};
    public static List<String> tipos = Arrays.asList(tiposrestaurante);
    private static int capacidad;
    private static int mesasreservadas;
    private boolean availabilityRestauran;


    private String calle;
    private int id;
    private int puntacion;
    private String opinion;
    private float precioMedio;
    private boolean servicioDelivery;
    private Comida comida[];
    private int elementos;
    private String tipoComida;

    public Restaurante(int id, String nombre, String calle, String tipoComida){
        this.id = id;
        this.nombre = nombre;
        this.calle = calle;
        this.tipoComida = tipoComida;

    }


    public Restaurante(int id, String nombre, String calle, int puntacion, String opinion, float precioMedio, boolean servicioDelivery, Comida[] comida) {
        this.nombre = nombre;
        this.calle = calle;
        this.puntacion = puntacion;
        this.opinion = opinion;
        this.precioMedio = precioMedio;
        this.servicioDelivery = servicioDelivery;
        comida = new Comida[elementos];
    }



    public void Menu(){
        int size = comida.length;
        for(int i=0; i<size;i++){
            if(comida[i]!=null){

                System.out.print("\n n" + (i+1)+ "\n \t"+comida[i].getDescripcion()+".........."+comida[i].getPrecio());


            }
        }


    }
    public int getCapacidad() {
        return capacidad;
    }
    public static boolean haySitio(){
        while(mesasreservadas!=capacidad){
            return true;
        }return false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoComida(){
        return tipoComida;
    }

    public static String[] getTiposrestaurante() {
        return tiposrestaurante;
    }

    public static List<String> getTipos() {
        return tipos;
    }

    public static int getMesasreservadas() {
        return mesasreservadas;
    }

    public boolean isAvailabilityRestauran() {
        return availabilityRestauran;
    }

    public String getCalle() {
        return calle;
    }

    public int getId() {
        return id;
    }

    public int getPuntacion() {
        return puntacion;
    }

    public String getOpinion() {
        return opinion;
    }

    public float getPrecioMedio() {
        return precioMedio;
    }

    public boolean isServicioDelivery() {
        return servicioDelivery;
    }

    public Comida[] getComida() {
        return comida;
    }

    public int getElementos() {
        return elementos;
    }

    @Override
    public String toString(){
        return ("Restaurante: "+getNombre()+", id: "+getId()+", dirección: "+getCalle()+" y tipo de comida: "+getTipoComida()+".\n");
    }
}

