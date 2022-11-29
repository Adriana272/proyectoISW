package icai.dtc.isw.domain;

public  class Comida {
    private int precio;

    private String descripcion;
    private int idrest;
    private int idmenu;

    public Comida(int idrest,int idmenu, String descripcion, int precio) {
        this.idrest = idrest;
        this.idmenu = idmenu;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIDRest(){
        return idrest;
    }
    public int getIDMenu(){return idmenu;}


    @Override
    public String toString(){
        return ("IdRestaurante: "+ getIDRest()+ ", IdMenu: "+getIDMenu()+", TipoComida: "+getDescripcion()+" y precio: "+getPrecio()+".\n");
    }
}
