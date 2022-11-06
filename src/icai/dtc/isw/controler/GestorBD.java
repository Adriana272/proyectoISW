package icai.dtc.isw.controler;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Restaurante;

import java.util.ArrayList;

public class GestorBD {
    private ArrayList <Client> clientes;
    private ArrayList<Restaurante> restaurantes;

    private CustomerDAO customerDAO;

    public GestorBD(CustomerDAO customerDAO){
        this.customerDAO=customerDAO;
        restaurantes=CustomerDAO.fetchRestaurantes();
    }

    public CustomerDAO getBdRestaurantes(){
        return customerDAO;
    }

    public ArrayList<Restaurante> getRestaurantes(){
        return restaurantes;
    }

    public Restaurante getRestaurante(String nombre){
        for(Restaurante restaurante : restaurantes){
            if (restaurante.getNombre().equals(nombre)){
                return restaurante;
            }
        }
        return null;
    }

    public ArrayList<Restaurante> buscarRestaurante(String nombre){
        ArrayList<Restaurante> restaurantesencontrados = new ArrayList<>();

        restaurantes.forEach(restaurante -> {
            if (restaurante.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                restaurantesencontrados.add(restaurante);
            }
        });

        return restaurantesencontrados;
    }

    public ArrayList<Restaurante> buscarRestauranteTipo(String tipo){
        ArrayList<Restaurante> restaurantesencontrados = new ArrayList<>();
        System.out.println(restaurantes);
        restaurantes.forEach(restaurante -> {
            if (restaurante.getTipo().toLowerCase().contains(tipo.toLowerCase())){
                restaurantesencontrados.add(restaurante);
            }
        });

        return restaurantesencontrados;
    }

    /*public ArrayList<Restaurante> buscarClientes(String nombre){
        ArrayList<Cliente> clientesEncontrados = new ArrayList<>();

        clientes.forEach(c -> {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                clientesEncontrados.add(c);

            }
        });

        return clientesEncontrados;
    }*/

    public ArrayList<String> getNombreRestaurantes(){
        ArrayList<String> nombresRestaurantes = new ArrayList<>();

        restaurantes.forEach(p -> nombresRestaurantes.add(p.getNombre()));
        return nombresRestaurantes;
    }

    public ArrayList<String> getTipoRestaurantes(String tipo){
        ArrayList<String> tiporestaurantes = new ArrayList<>();

        restaurantes.forEach(c -> tiporestaurantes.add(c.getTipo()));
        return tiporestaurantes;
    }


    public ArrayList<String> getTipoRestaurantes(){
        ArrayList<String> tiporestaurantes = new ArrayList<>();

        restaurantes.forEach(c -> tiporestaurantes.add(c.getTipo()));
        return tiporestaurantes;
    }

    public void addRestaurante(Restaurante restaurante)
    {

    }
}


