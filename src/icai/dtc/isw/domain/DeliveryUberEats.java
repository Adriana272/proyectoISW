package icai.dtc.isw.domain;

public class DeliveryUberEats extends Delivery{
    private static float GASTOENVÍO = 3F;
    private float costefinal;
    private static float ENVIOPREFERENTE = 1;
    private boolean enviopreferente;
    private float tiempoMaximoEsperaUber;
    private float tiempoMinimoEsperaUber;

    /*private static final int PRECIOMINIMOPEDIDO = 10;*/

    public DeliveryUberEats(float distanciarestcasa, float costefinal, float tiempoMáximoEsperaUber, float tiempoMínimoEsperaUber) {
        super(distanciarestcasa);
        this.costefinal = costefinal;
        this.tiempoMaximoEsperaUber = tiempoMáximoEsperaUber;
        this.tiempoMinimoEsperaUber = tiempoMínimoEsperaUber;
    }

    public DeliveryUberEats(float distanciarestcasa) {
        super(distanciarestcasa);
    }

    public float coste() {
        return (GASTOENVÍO + super.coste());


    }
    public String toString(){
        return "el servicio Uber Eats" + "tiene un gasto de envio de " +  this.coste();
    }
}
