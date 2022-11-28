package icai.dtc.isw.domain;

import static java.lang.Boolean.TRUE;

public abstract class Delivery {
    private static final float tiempoMaximoEsperaTotal= 150;
    private static final float tiempoMinimoEsperaTotal= 40;
    protected  static double distanciarestcasa; //en km
    protected static  float precioenvio;
    protected static float ENVIOPREFERENTE = 1;
    protected boolean preferencia;
    protected static double tiempo;

    public Delivery( double distanciarestcasa, float precioenvio, boolean preferencia) {

        this.distanciarestcasa = distanciarestcasa;
        this.precioenvio = precioenvio;
        this.preferencia = preferencia;
    }

    public Delivery(float distanciarestcasa) {
        this.distanciarestcasa = distanciarestcasa;
        this.precioenvio = precioenvio;
    }

    public static float calcularTiempo(boolean preferencia) {
        do {
            if (preferencia == true)
            {
                tiempo = Math.random() * (100 - tiempoMinimoEsperaTotal + 1);

            } else {
                tiempo = Math.random() * (tiempoMaximoEsperaTotal - tiempoMinimoEsperaTotal + 1);
            }
            return (float) tiempo;
        }while(tiempo>40.0);
    }

    public static float coste(boolean preferencia) {

        if (preferencia == true) { //esto creo que no está muy bien

            precioenvio = precioenvio + ENVIOPREFERENTE;
        } else {
            return precioenvio;
        }return precioenvio;
    }



}