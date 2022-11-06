package icai.dtc.isw.domain;

import static java.lang.Boolean.TRUE;

public class Delivery {
    private float tiempoMaximoEsperaTotal;
    private float tiempoMinimoEsperaTotal;
    protected double distanciarestcasa; //en km
    protected float precioenvio;
    protected static float ENVIOPREFERENTE = 1;
    protected boolean preferencia;

    public Delivery(float tiempoMaximoEsperaTotal, float tiempoMinimoEsperaTotal, double distanciarestcasa, float precioenvio, boolean preferencia) {
        this.tiempoMaximoEsperaTotal = tiempoMaximoEsperaTotal;
        this.tiempoMinimoEsperaTotal = tiempoMinimoEsperaTotal;
        this.distanciarestcasa = distanciarestcasa;
        this.precioenvio = precioenvio;
        this.preferencia = preferencia;
    }

    public Delivery(float distanciarestcasa) {
        this.distanciarestcasa = distanciarestcasa;
        this.precioenvio = precioenvio;
    }

    public float coste(){
        if(distanciarestcasa>20){
            return precioenvio=precioenvio+2;
        }
        else if(preferencia==TRUE){ //esto creo que no está muy bien

            precioenvio = precioenvio + ENVIOPREFERENTE;
        }
        return precioenvio;
    }
}