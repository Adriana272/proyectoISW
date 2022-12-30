package icai.dtc.isw.ui;

import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PlaceComponentsBL extends JPanel implements Serializable {


    private JVentana jVentanaMadrimentate;
    public Restaurante restaurantebuscado;
    public ArrayList<String> relitaliana = new ArrayList();


    public PlaceComponentsBL(/*JVentana jVentanaMadrimentate*/) {

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setLayout(null);
    /*
        restaurantebuscado = CustomerDAO.fetchRestaurantexNombre(txtRest.getText());
        System.out.println(restaurantebuscado);
        System.out.println(CustomerDAO.fetchRestaurantes());

        JLabel labelBL=new JLabel("BUSCADOR");
        labelBL.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelBL.setBounds(350, 20, 400, 200);
        this.add(labelBL);

        final JTextArea restaurants = new JTextArea();
        restaurants.setBounds(100, 250, 600, 400);
        //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
        //restaurants.setBackground(Color.lightGray);
        //for(String cancion: relespaniola){
        System.out.println(restaurantebuscado);
        System.out.println("ATM");
        restaurants.append("* "+((restaurantebuscado).toString());
        restaurants.append("\n");

        restaurants.setEditable(false);
        this.add(restaurants);

        JButton btnReservarBL=new JButton("Reservar Mesa");
        btnReservarBL.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnReservarBL.setBounds(200, 750, 160, 60);
        btnReservarBL.setBackground(Color.white);

        JButton btnPedirBL=new JButton("Pedir a domicilio");
        btnPedirBL.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPedirBL.setBounds(440, 750, 160, 60);
        btnPedirBL.setBackground(Color.white);

        this.add(btnReservarBL);
        this.add(btnPedirBL);
*/


    }
}