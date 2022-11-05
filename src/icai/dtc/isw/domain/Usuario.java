package icai.dtc.isw.domain;

public class Usuario implements CharSequence {

    public int id;
    public String nombre;
    public String password;

    public Usuario (int id, String nombre, String password){
        this.id=id;
        this.nombre=nombre;
        this.password=password;
    }

    public Usuario (int id, String password){
        this.id=id;
        this.password=password;
    }

    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getPassword(){
        return password;
    }

    public void setId(int newId){
        this.id=newId;
    }
    public void setNombre(String newNombre){
        this.nombre=newNombre;
    }
    public void setPassword(String newPassword){
        this.password=newPassword;
    }


    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }
}
