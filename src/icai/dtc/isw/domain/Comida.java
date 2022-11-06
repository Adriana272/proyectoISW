package icai.dtc.isw.domain;

public class Comida {
    private int precio;

    private String descripcion;
    private String intolerancias;

    public Comida(int precio, String descripcion, String intolerancias) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.intolerancias = intolerancias;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIntolerancias() {
        return intolerancias;
    }
}
