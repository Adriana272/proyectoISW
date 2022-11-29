package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Comida;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.domain.Usuario;

public class CustomerDAO {
	Connection con;




	public CustomerDAO(Connection con) {
		con = ConnectionDAO.getInstance().getConnection();
	}

	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}
	public static Customer getCliente(int id, String password) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		Customer cu=null;
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE id="+id);
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				cu= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		return cu;
		//return new Customer("1","Atilano");
	}


	public static ArrayList<Comida> getComida(int idrest){
		Connection con=ConnectionDAO.getInstance().getConnection();
		ArrayList<Comida> comidas = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement("SELECT idmenu , producto,precio FROM menu WHERE idrest="+ idrest);
			 ResultSet rs = pst.executeQuery()
		)

		{

			while (rs.next()) {
				comidas.add(new Comida(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getInt(4)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		return comidas;
		//return new Customer("1","Atilano");
	}
	public static ArrayList<Comida> fetchComidas(){
		ArrayList<Comida> comidas = new ArrayList<>();
		Connection con=ConnectionDAO.getInstance().getConnection();


		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM menu");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				comidas.add(new Comida(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return comidas;
	}

	public static void addUsuario(Usuario usuario) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		//Customer cu=null;
		try {
			PreparedStatement pst= con.prepareStatement("INSERT INTO usuarios VALUES ('" + usuario.getId() + "', '" + usuario.getNombre() + "', '" + usuario.getPassword() + "')");
			pst.executeQuery();
			pst.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Usuario creado correctamente");
	}



	/*public ArrayList<Comida> comidas(int idRest){
		ArrayList<Comida> comidasrest = new ArrayList<>();
		String x = String.valueOf(idRest);

		comidasrest.forEach(comidas -> {
			if (comidas.getIDRest().contains((x))){
				comidasrest.add(comidas);
			}
		});

		return comidasrest;
	}*/


	public void addRestaurante(Restaurante restaurante) {
		try {
			con.prepareStatement("INSERT INTO restaurantes VALUES ('" + restaurante.getNombre() + "', '" + restaurante.getId() + "', '" + restaurante.getCalle() + "')").executeQuery();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static ArrayList<Restaurante> fetchRestaurantes(){
		ArrayList<Restaurante> restaurantes = new ArrayList<>();
		Connection con=ConnectionDAO.getInstance().getConnection();


		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes ");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return restaurantes;
	}









	public static void main(String[] args) {


		ArrayList<Customer> lista= new ArrayList<>();
		CustomerDAO.getClientes(lista);


		for (Customer customer : lista) {
			System.out.println("He leído el id: "+customer.getId()+" con nombre: "+customer.getName());
		}


	}

}
