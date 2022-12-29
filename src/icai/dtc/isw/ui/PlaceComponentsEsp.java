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

public class PlaceComponentsEsp extends JPanel implements Serializable {


    private JVentana jVentanaMadrimentate;
    public ArrayList<Restaurante> restencesp;
    public ArrayList<String> relespaniola = new ArrayList();


    public PlaceComponentsEsp(/*JVentana jVentanaMadrimentate*/) {

        this.jVentanaMadrimentate = jVentanaMadrimentate;
        this.setLayout(null);

        restencesp = CustomerDAO.fetchRestaurantesxTipoComida("espaniola");
        System.out.println(restencesp);
        System.out.println(CustomerDAO.fetchRestaurantes());

        JLabel labelEsp=new JLabel("ESPAÑA");
        labelEsp.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelEsp.setBounds(350, 20, 400, 200);
        this.add(labelEsp);

        final JTextArea restaurants = new JTextArea();
        restaurants.setBounds(100, 250, 600, 400);
        //platosTextField.setFont(Font.getFont(Font.SANS_SERIF));
        //restaurants.setBackground(Color.lightGray);
        //for(String cancion: relespaniola){
        System.out.println(restencesp);
        System.out.println("ATM");
        for(int i=0; i<(restencesp.toArray().length); i++) {
            restaurants.append("* "+((restencesp.toArray())[i]).toString());
            restaurants.append("\n");

        }
        restaurants.setEditable(false);
        this.add(restaurants);

        JButton btnReservar=new JButton("Reservar Mesa");
        btnReservar.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnReservar.setBounds(200, 750, 160, 60);
        btnReservar.setBackground(Color.white);

        JButton btnPedir=new JButton("Pedir a domicilio");
        btnPedir.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnPedir.setBounds(440, 750, 160, 60);
        btnPedir.setBackground(Color.white);

        this.add(btnReservar);
        this.add(btnPedir);



    }
}