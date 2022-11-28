package icai.dtc.isw.domain;

public class DeliveryDeliveroo extends Delivery{
    private static final float GASTOENVIO = 2.75F;
    private float costefinal;
    private static final  float ENVIOPREFERENTE = 1;
    private float tiempoMaximoEsperaGlovo;
    private float tiempoMinimoEsperaGlovo;

    public DeliveryDeliveroo(float distanciarestcasa) {
        super(distanciarestcasa);
    }


    /*private static final int PRECIOMINIMOPEDIDO = 10;*/


    public float coste(){
        return(GASTOENVIO+  coste(preferencia));


    }

    public float calcularTiempo(){
        return(calcularTiempo(preferencia)+15);
    }
    public String toString(){
        return "el servicio delivery Deliveroo" + "tiene un gasto de envio de " +  this.coste();
    }
}
