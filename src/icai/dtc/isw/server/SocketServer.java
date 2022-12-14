package icai.dtc.isw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Restaurante;
import icai.dtc.isw.message.Message;

import javax.swing.*;

public class SocketServer extends Thread {
	public static int port = 8081; //Valor por defecto

	protected Socket socket;

	private SocketServer(Socket socket) {
		this.socket = socket;
		//Configure connections
		this.port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}

	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			//in = socket.getInputStream();
			//out = socket.getOutputStream();

			in = socket.getInputStream();
			out = socket.getOutputStream();

			//first read the object that has been sent
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
		    Message mensajeIn= (Message)objectInputStream.readObject();
		    //Object to return informations 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		    Message mensajeOut=new Message();
			HashMap<String,Object> session=mensajeIn.getSession();
			CustomerControler customerControler;
		    switch (mensajeIn.getContext()) {
		    	case "/getCustomers":
		    		customerControler=new CustomerControler();
		    		ArrayList<Customer> lista=new ArrayList<Customer>();
		    		customerControler.getCustomers(lista);
		    		mensajeOut.setContext("/getCustomersResponse");
		    		//HashMap<String,Object> session=new HashMap<String, Object>();
		    		session.put("Customers",lista);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);		    		
		    		break;
				case "/getCustomer":
					int id= (int) session.get("id");
					System.out.println(id);
					String password= (String) session.get("password");
					customerControler=new CustomerControler();
					Customer cu=customerControler.getCustomer(id, password);
					System.out.println("id:"+cu.getId());
					System.out.println("contrasena:"+cu.getPw());
					mensajeOut.setContext("/getCustomerResponse");
					session.put("Customer",cu);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				/*case "/getRestaurantes":
					customerControler=new CustomerControler();
					ArrayList<Restaurante> lista2=new ArrayList<Restaurante>();
					customerControler.getCustomers(lista2);
					mensajeOut.setContext("/getRestaurantesResponse");
					//HashMap<String,Object> session=new HashMap<String, Object>();
					session.put("Restaurantes",lista2);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getRestaurante":
					String tipo= (String) session.get("tipo");
					System.out.println(tipo);
					//String password= (String) session.get("password");
					customerControler=new CustomerControler();
					Restaurante re=customerControler.getRest(tipo);
					System.out.println("tipo:"+re.getTipo());
					mensajeOut.setContext("/getRestauranteResponse");
					session.put("Restaurante",re);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;*/
		    	
		    	default:
		    		System.out.println("\nPar??metro no encontrado");
		    		break;
		    }
		    
		    //L??gica del controlador 
		    //System.out.println("\n1.- He le??do: "+mensaje.getContext());
		    //System.out.println("\n2.- He le??do: "+(String)mensaje.getSession().get("Nombre"));
		    
		    
		    
		    //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			
			//Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" a??ado informaci??n";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He le??do: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
			JOptionPane.showMessageDialog(null, "No hay ningun usuario con esos datos registrado");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}