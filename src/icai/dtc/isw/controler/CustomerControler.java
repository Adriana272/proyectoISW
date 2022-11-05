package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;

public class CustomerControler {

	public void getCustomers(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}
	public Customer getCustomer(int id, String password) {return(CustomerDAO.getCliente(id,password));}
	//public void setCustomer(int newid, String newnombre, String newpassword) {return(CustomerDAO.setCliente(newid, newnombre, newpassword));}
}
