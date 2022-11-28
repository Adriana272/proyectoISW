package icai.dtc.isw.domain;

public class DeliveryGlovo extends Delivery{

    private static float GASTOENVIO = 3.5F;
    private float costefinal;
    private static float ENVIOPREFERENTE = 1;
    private float tiempoMaximoEsperaGlovo;
    private float tiempoMinimoEsperaGlovo;

    public DeliveryGlovo(float distanciarestcasa) {
        super(distanciarestcasa);
    }

    public DeliveryGlovo(float distanciarestcasa, float costefinal, float tiempoMaximoEsperaGlovo, float tiempoMínimoEsperaGlovo) {
        super(distanciarestcasa);
        this.costefinal = costefinal;
        this.tiempoMaximoEsperaGlovo = tiempoMaximoEsperaGlovo;
        this.tiempoMinimoEsperaGlovo = tiempoMinimoEsperaGlovo;
    }
    /*private static final int PRECIOMINIMOPEDIDO = 10;*/


    public static float coste(boolean preferencia){
        return(GASTOENVIO+ Delivery.coste(preferencia));


    }
    public String toString(){
        return "el servicio delivery Glovo" + "tiene un gasto de envio de " +  this.coste(preferencia);
    }

    public float calcularTiempo(){
        return(calcularTiempo(preferencia)-10);

    }

    public void getTiempo(){
        System.out.println(calcularTiempo());
    }





}
