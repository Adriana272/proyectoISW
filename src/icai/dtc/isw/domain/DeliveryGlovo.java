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


    public float coste(){
        return(GASTOENVIO+ super.coste());


    }
    public String toString(){
        return "el servicio delivery Glovo" + "tiene un gasto de envio de " +  this.coste();
    }
}
