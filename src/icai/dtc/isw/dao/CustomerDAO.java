package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		System.out.println(id);
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE id=?"); // WHERE id="+id);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cu= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
				System.out.println(rs.getInt(1));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return cu;
		//return new Customer("1","Atilano");
	}

	/*public static void getRestaurantes(ArrayList<Customer> lista2) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista2.add(new Restaurante(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static Restaurante getRestaurante(String tipo) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		Restaurante re=null;
		System.out.println(tipo);
		try {
			 PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes WHERE tipo=?"); // WHERE id="+id);
			 pst.setInt(1,tipo);
			 ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				re= new Restaurante(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
				System.out.println(rs.getInt(1));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return re;
		//return new Customer("1","Atilano");
	}*/

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

	public void addRestaurante(Restaurante restaurante){
		try{
			con.prepareStatement("INSERT INTO restaurantes VALUES('"+ restaurante.getNombre()+ "', '"+restaurante.getId()+"', '"+restaurante.getDireccion()+ "')").executeQuery();
		} catch (SQLException e){
			System.out.println(e);
		}
	}

	public static ArrayList<Restaurante> fetchRestaurantes(){
		ArrayList<Restaurante> restaurantes= new ArrayList<>();
		Connection con=ConnectionDAO.getInstance().getConnection();

		try(PreparedStatement pst=con.prepareStatement("SELECT * FROM restaurantes ");
			ResultSet rs=pst.executeQuery()){
			while (rs.next()){
				restaurantes.add(new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException ex){
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
